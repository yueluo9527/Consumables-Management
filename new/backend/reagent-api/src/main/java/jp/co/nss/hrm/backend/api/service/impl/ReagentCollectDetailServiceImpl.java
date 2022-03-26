package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dao.ReagentCollectDetailDao;
import jp.co.nss.hrm.backend.api.dao.ReagentStockDetailDao;
import jp.co.nss.hrm.backend.api.service.ReagentCollectDetailService;
import jp.co.nss.hrm.backend.mapper.ReagentCollectDetailMapper;
import jp.co.nss.hrm.backend.model.ReagentCollectDetail;
import jp.co.nss.hrm.backend.model.ReagentCollectDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReagentCollectDetailServiceImpl implements ReagentCollectDetailService {

    @Autowired
    private ReagentCollectDetailMapper collectDetailMapper;
    @Autowired
    private ReagentCollectDetailDao collectDetailDao;
    @Autowired
    private ReagentAdminDao adminDao;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;
    @Autowired
    private ReagentStockDetailDao stockDetailDao;


    /**
     * 获取所有领用详细信息
     */
    @Override
    public List<ReagentCollectDetail> list() {

        return collectDetailMapper.selectByExample(new ReagentCollectDetailExample());
    }

    /**
     * 添加领用详细信息
     *
     * @param collect
     */
    @Override
    public int create(ReagentCollectDetail collect) {

        collect.setCreateTime(new Date());
        return collectDetailMapper.insert(collect);
    }

    /**
     * 修改领用详细信息
     *
     * @param collect
     */
    @Override
    public int update(ReagentCollectDetail collect) {
        //根据创建人判断属于一级还是二级，以及科室名称，根据领用单号判断是移库还是领用（一级不用判断），
        //移库根据试剂id查询中心库中试剂状态为1998的有多少，
        //领用根据试剂id查询一级或者二级科室，对应科室名下试剂状态为1998的有多少
        //比较大小看是否支持移库和领用

        String branch = adminDao.selectBranch(collect.getCreateBy());
        Long adminId = adminDao.selectByUser(collect.getCreateBy());
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        int quantity = 0;
        String stockType = null;
        if (roleId == 4) {
            //一级库试剂操作员，只有领用操作，面向科室库
            stockType = "1";
            quantity = stockDetailDao.searchInStockNum(collect.getReagentCode(), branch, stockType);
        } else if (roleId == 9) {
            //二级库试剂操作员，领用操作，面向科室库
            stockType = "3";
            quantity = stockDetailDao.searchInStockNum(collect.getReagentCode(), branch, stockType);
        } else if (roleId == 3) {
            //科室库库管员-两级库，移库操作,面向中心库
            stockType = "3";
            branch = "中心库";
            quantity = stockDetailDao.searchInStockNum(collect.getReagentCode(), branch, stockType);
        }
        //System.out.println("num:" + quantity);

        if (collect.getReagentNumber() > quantity) {
            String Message;
            int Diff = (int) (collect.getReagentNumber() - quantity);
            //System.out.println("Diff:" + Diff);
            //Message = "申请试剂：" + collect.getReagentName() + "超出库存" + Diff + "支，申请失败！";
            return Diff;
        } else {//成功则返回1-1=0，防止与上面的数量差1相同
            return (collectDetailMapper.updateByPrimaryKeySelective(collect) - 1);
        }
    }

    /**
     * 级联删除领用详细信息
     *
     * @param collectNos
     */

    @Override
    public int delete(List<String> collectNos) {
        ReagentCollectDetailExample example = new ReagentCollectDetailExample();
        example.createCriteria().andCollectNoIn(collectNos);
        int count = collectDetailMapper.deleteByExample(example);
        return count;
    }

    /**
     * 删除指定领用详情
     */

    @Override
    public int delete(Long id) {
        int count = collectDetailMapper.deleteByPrimaryKey(id);
        return count;
    }

    /**
     * 分页获取领用详细信息
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentCollectDetail> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return collectDetailDao.selectByCollectNo(keyword);
    }

    /**
     * 根据领用号获取领用详细信息
     *
     * @param collectNo
     */
    @Override
    public List<ReagentCollectDetail> getItem(String collectNo) {

        return collectDetailDao.selectByCollectNo(collectNo);
    }

    @Override
    public ReagentCollectDetail getItem(Long id) {

        return collectDetailMapper.selectByPrimaryKey(id);
    }

}
