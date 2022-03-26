package jp.co.nss.hrm.backend.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dao.ReagentStockDao;
import jp.co.nss.hrm.backend.api.dao.ReagentStockDetailDao;
import jp.co.nss.hrm.backend.api.dto.AdminUserDetails;
import jp.co.nss.hrm.backend.api.dto.ReagentAdminParam;
import jp.co.nss.hrm.backend.api.dto.UpdateAdminPasswordParam;
import jp.co.nss.hrm.backend.api.service.ReagentAdminService;
import jp.co.nss.hrm.backend.common.exception.Asserts;
import jp.co.nss.hrm.backend.common.util.RequestUtil;
import jp.co.nss.hrm.backend.mapper.ReagentAdminLoginLogMapper;
import jp.co.nss.hrm.backend.mapper.ReagentAdminMapper;
import jp.co.nss.hrm.backend.mapper.ReagentAdminRoleRelationMapper;
import jp.co.nss.hrm.backend.model.*;
import jp.co.nss.hrm.backend.security.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ReagentAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class ReagentAdminServiceImpl implements ReagentAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReagentAdminServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ReagentAdminMapper adminMapper;
    @Autowired
    private ReagentAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private ReagentAdminLoginLogMapper loginLogMapper;
    @Autowired
    private ReagentAdminDao adminDao;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    @Override
    public ReagentAdmin getAdminByUsername(String username) {
        ReagentAdmin admin;
        ReagentAdminExample example = new ReagentAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<ReagentAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            return admin;
        }
        return null;
    }

    @Override
    public ReagentAdmin register(ReagentAdminParam ReagentAdminParam) {
        ReagentAdmin ReagentAdmin = new ReagentAdmin();
        BeanUtils.copyProperties(ReagentAdminParam, ReagentAdmin);
        ReagentAdmin.setCreateTime(new Date());
        ReagentAdmin.setLoginTime(new Date());
        ReagentAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        ReagentAdminExample example = new ReagentAdminExample();
        example.createCriteria().andUsernameEqualTo(ReagentAdmin.getUsername());
        List<ReagentAdmin> ReagentAdminList = adminMapper.selectByExample(example);
        if (ReagentAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(ReagentAdmin.getPassword());
        ReagentAdmin.setPassword(encodePassword);
        adminMapper.insert(ReagentAdmin);
        Long adminId = adminDao.selectByUser(ReagentAdmin.getUsername());

        //根据创建人查询是否为中心库管或者科室库管-单级库，若是，则创建的用户默认为供应商
        Long createAdminId = adminDao.selectByUser(ReagentAdminParam.getCreateBy());
        Long createRoleId = adminRoleDao.selectByAdmin(createAdminId);
        long roleId;
        if (createRoleId == 2 || createRoleId == 6) {
            roleId = 5L;
        } else {
            roleId = 10L;
        }
        adminRoleDao.insertRoleId(adminId, roleId);
        return ReagentAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Asserts.fail("密码不正确");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            //updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        ReagentAdmin admin = getAdminByUsername(username);
        if (admin == null) return;
        ReagentAdminLoginLog loginLog = new ReagentAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        loginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     */
    private void updateLoginTimeByUsername(String username) {
        ReagentAdmin record = new ReagentAdmin();
        record.setLoginTime(new Date());
        ReagentAdminExample example = new ReagentAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.updateByExampleSelective(record, example);
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public ReagentAdmin getItem(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ReagentAdmin> getTrueName(String username) {
        ReagentAdminExample example = new ReagentAdminExample();
        ReagentAdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return adminMapper.selectByExample(example);
    }

    @Override
    public PageInfo<ReagentAdmin> list(String keyword, String username, Integer pageSize, Integer pageNum) {
        ReagentAdminExample example = new ReagentAdminExample();
        ReagentAdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andTrueNameLike("%" + keyword + "%"));
        }
        PageInfo<ReagentAdmin> adminList = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            adminMapper.selectByExample(example);
        });
        // 对查询的list进行下一步操作
        List<ReagentAdmin> collect = adminMapper.selectByExample(example);
        //创建Page类
        Page<ReagentAdmin> page = new Page<>(pageNum, pageSize);
        int total;

        //根据用户名查找用户ID，根据用户ID查找角色ID，
        //如果是医管，查找到的用户里面剔除超管，否则就是超管，展示所有
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        List<ReagentAdmin> adminOfList = new ArrayList<>();

        //如果是一级医管，去除超管，科管，二级医管，二级中管用户
        if (roleId == 7) {
            collect.forEach(adminItem -> {
                Long adminIdIndex = adminDao.selectByUser(adminItem.getUsername());
                Long roleIdIndex = adminRoleDao.selectByAdmin(adminIdIndex);
                if (roleIdIndex == 2 || roleIdIndex == 4 || roleIdIndex == 5 || roleIdIndex == 7 || roleIdIndex == 10) {
                    adminOfList.add(adminItem);
                }
            });
            //为Page类中的total属性赋值
            total = adminOfList.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(adminOfList.subList(startIndex, endIndex));
            //以Page创建PageInfo
            return new PageInfo<>(page);
        } else if (roleId == 8) {
            //如果是二级医管，去除超管，科管，一级医管
            collect.forEach(adminItem -> {
                Long adminIdIndex = adminDao.selectByUser(adminItem.getUsername());
                Long roleIdIndex = adminRoleDao.selectByAdmin(adminIdIndex);
                if (roleIdIndex == 3 || roleIdIndex == 5 || roleIdIndex == 6 || roleIdIndex == 8 || roleIdIndex == 9 || roleIdIndex == 10) {
                    adminOfList.add(adminItem);
                }
            });
            //为Page类中的total属性赋值
            total = adminOfList.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(adminOfList.subList(startIndex, endIndex));
            //以Page创建PageInfo
            return new PageInfo<>(page);
        } else if (roleId == 2 || roleId == 6) {
            //如果是中心库管或者科室库管-单级库，只保留供货商
            collect.forEach(adminItem -> {
                Long adminIdIndex = adminDao.selectByUser(adminItem.getUsername());
                Long roleIdIndex = adminRoleDao.selectByAdmin(adminIdIndex);
                if (roleIdIndex == 5) {
                    adminOfList.add(adminItem);
                }
            });
            //为Page类中的total属性赋值
            total = adminOfList.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(adminOfList.subList(startIndex, endIndex));
            //以Page创建PageInfo
            return new PageInfo<>(page);
        } else {
            //返回全部
            return adminList;
        }
    }

    @Override
    public int update(Long id, ReagentAdmin admin, String username) {
        admin.setId(id);
        ReagentAdmin rawAdmin = adminMapper.selectByPrimaryKey(id);
        if (rawAdmin.getPassword().equals(admin.getPassword())) {
            //与原加密密码相同的不需要修改
            admin.setPassword(null);
        } else {
            //与原加密密码不同的需要加密修改
            if (StrUtil.isEmpty(admin.getPassword())) {
                admin.setPassword(null);
            } else {
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }

        //被操作人id
        Long roleId = adminRoleRelationDao.selectByAdmin(id);
        //操作人id
        if (username != null) {
            Long adminId = adminDao.selectByUser(username);
            Long manId = adminRoleDao.selectByAdmin(adminId);
            if ((manId == 7 || manId == 8) && (roleId == 7 || roleId == 8)) {
                //超管可禁管理员，管理员不可禁管理员
                return 3;
            }
        }
        //超管不可禁
        if (roleId == 1 && admin.getStatus() == 0) {
            return 2;
        }
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = adminMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        ReagentAdminRoleRelationExample adminRoleRelationExample = new ReagentAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<ReagentAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                ReagentAdminRoleRelation roleRelation = new ReagentAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }

    @Override
    public List<ReagentRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public List<ReagentResource> getResourceList(Long adminId) {
        List<ReagentResource> resourceList;
        resourceList = adminRoleRelationDao.getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)) {
            //adminCacheService.setResourceList(adminId, resourceList);
        }
        return resourceList;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if (StrUtil.isEmpty(param.getUsername())
                || StrUtil.isEmpty(param.getOldPassword())
                || StrUtil.isEmpty(param.getNewPassword())) {
            return -1;
        }
        ReagentAdminExample example = new ReagentAdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername());
        System.out.println(param.getUsername());
        List<ReagentAdmin> adminList = adminMapper.selectByExample(example);
        if (CollUtil.isEmpty(adminList)) {
            return -2;
        }
        ReagentAdmin ReagentAdmin = adminList.get(0);
        if (!passwordEncoder.matches(param.getOldPassword(), ReagentAdmin.getPassword())) {
            return -3;
        }
        ReagentAdmin.setPassword(passwordEncoder.encode(param.getNewPassword()));
        adminMapper.updateByPrimaryKey(ReagentAdmin);
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        ReagentAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<ReagentResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    /**
     * 根据当前登录用户名获取科室名
     * 查找目标用户是否存在于该科室中
     *
     * @param usernameCurrent 当前登录用户名
     * @param usernameTarget  目标用户
     * @return 0-不存在；1-存在
     */
    @Override
    public int checkUserFromBranch(String usernameCurrent, String usernameTarget) {
        String branch = adminDao.selectBranch(usernameCurrent);

        return adminDao.checkUserFromBranch(branch, usernameTarget);
    }

    @Override
    public List<ReagentAdmin> getOperatorList(String branch) {
        return adminDao.getOperatorList(branch);
    }

}
