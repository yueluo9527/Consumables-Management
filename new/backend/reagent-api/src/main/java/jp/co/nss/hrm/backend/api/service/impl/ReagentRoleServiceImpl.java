package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dao.ReagentRoleDao;
import jp.co.nss.hrm.backend.api.service.ReagentRoleService;
import jp.co.nss.hrm.backend.mapper.ReagentRoleMapper;
import jp.co.nss.hrm.backend.mapper.ReagentRoleMenuRelationMapper;
import jp.co.nss.hrm.backend.mapper.ReagentRoleResourceRelationMapper;
import jp.co.nss.hrm.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台角色管理Service实现类
 * Created by macro on 2018/9/30.
 */
@Service
public class ReagentRoleServiceImpl implements ReagentRoleService {
    @Autowired
    private ReagentRoleMapper roleMapper;

    @Autowired
    private ReagentRoleMenuRelationMapper roleMenuRelationMapper;

    @Autowired
    private ReagentRoleResourceRelationMapper roleResourceRelationMapper;

    @Autowired
    private ReagentRoleDao roleDao;

    @Autowired
    private ReagentAdminDao adminDao;

    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    @Override
    public int create(ReagentRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return roleMapper.insert(role);
    }

    @Override
    public int update(Long id, ReagentRole role) {
        if (id == 1) {
            return 0;
        }
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(List<Long> ids) {
        ReagentRoleExample example = new ReagentRoleExample();
        example.createCriteria().andIdIn(ids);
        for (Long id : ids) {
            if (id == 1) return 0;
        }
        int count = roleMapper.deleteByExample(example);
        return count;
    }

    @Override
    public List<ReagentRole> list() {

        return roleMapper.selectByExample(new ReagentRoleExample());
    }

    @Override
    public PageInfo<ReagentRole> list(String keyword, String username, Integer pageSize, Integer pageNum) {
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        //计算各个角色对应的用户数量
        List<ReagentRole> userCountList = adminRoleDao.getUserCount();

        PageHelper.startPage(pageNum, pageSize);
        ReagentRoleExample example = new ReagentRoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        List<ReagentRole> roleListAll1 = roleMapper.selectByExample(example);

        //从两个列表中根据id进行对应，将用户数写进去
        for (ReagentRole role : roleListAll1) {
            for (ReagentRole userCount : userCountList) {
                if (role.getId().equals(userCount.getId())) {
                    role.setAdminCount(userCount.getAdminCount());
                    //更新用户数
                    //updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
                    ReagentRoleExample upExample = new ReagentRoleExample();
                    upExample.createCriteria().andIdEqualTo(role.getId());
                    roleMapper.updateByExampleSelective(role, upExample);
                }
            }
        }
        //筛选用的all
        List<ReagentRole> roleListAll = roleMapper.selectByExample(example);
        //如果是admin返回全部
        PageInfo<ReagentRole> roleListAll2 = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            roleMapper.selectByExample(example);
        });

        List<ReagentRole> roleList = new ArrayList<>();
        //创建Page类
        Page<ReagentRole> page = new Page<>(pageNum, pageSize);
        int total;
        if (roleId == 7) {
            for (ReagentRole reagentRole : roleListAll) {
                if (reagentRole.getId() == 2 || reagentRole.getId() == 4 || reagentRole.getId() == 5 || reagentRole.getId() == 7 || reagentRole.getId() == 10) {
                    roleList.add(reagentRole);
                }
            }
            //为Page类中的total属性赋值
            total = roleList.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(roleList.subList(startIndex, endIndex));
            //以Page创建PageInfo
            return new PageInfo<>(page);
        } else if (roleId == 8) {
            for (ReagentRole reagentRole : roleListAll) {
                if (reagentRole.getId() == 3 || reagentRole.getId() == 5 || reagentRole.getId() == 6 || reagentRole.getId() == 8 || reagentRole.getId() == 9 || reagentRole.getId() == 10 || reagentRole.getId() == 11 || reagentRole.getId() == 12 || reagentRole.getId() == 13 || reagentRole.getId() == 14 || reagentRole.getId() == 15) {
                    roleList.add(reagentRole);
                }
            }
            //为Page类中的total属性赋值
            total = roleList.size();
            page.setTotal(total);
            //计算当前需要显示的数据下标起始值
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, total);
            page.addAll(roleList.subList(startIndex, endIndex));
            //以Page创建PageInfo
            return new PageInfo<>(page);
        } else if (roleId == 1) {
            return roleListAll2;
        }
        return null;
    }

    @Override
    public List<ReagentRole> getRoleListByAdmin(String adminName) {
        //先查找出全部角色列表，再根据角色ID进行删选
        List<ReagentRole> allRoleList;
        allRoleList = roleMapper.selectByExample(new ReagentRoleExample());
        Long adminId = adminDao.selectByUser(adminName);
        Long roleId = adminRoleDao.selectByAdmin(adminId);

        List<ReagentRole> roleList = new ArrayList<>();
        //如果是一级医管，去除超管，科管，二级医管，二级中管角色
        if (roleId == 7) {
            allRoleList.forEach(roleItem -> {
                if (roleItem.getId() == 2 || roleItem.getId() == 4 || roleItem.getId() == 5 || roleItem.getId() == 10) {
                    roleList.add(roleItem);
                }
            });
            return roleList;
        } else if (roleId == 8) {
            //如果是二级医管，去除超管，科管，一级医管角色
            allRoleList.forEach(roleItem -> {
                if (roleItem.getId() == 3 || roleItem.getId() == 5 || roleItem.getId() == 6 || roleItem.getId() == 9 || roleItem.getId() == 10) {
                    roleList.add(roleItem);
                }
            });
            return roleList;
        } else if (roleId == 1) {
            return allRoleList;
        }
        return null;
    }

    @Override
    public List<ReagentMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<ReagentMenu> listMenu(Long roleId) {
        return roleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public List<ReagentResource> listResource(Long roleId) {
        return roleDao.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        ReagentRoleMenuRelationExample example = new ReagentRoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long menuId : menuIds) {
            ReagentRoleMenuRelation relation = new ReagentRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        ReagentRoleResourceRelationExample example = new ReagentRoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            ReagentRoleResourceRelation relation = new ReagentRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        return resourceIds.size();
    }
}
