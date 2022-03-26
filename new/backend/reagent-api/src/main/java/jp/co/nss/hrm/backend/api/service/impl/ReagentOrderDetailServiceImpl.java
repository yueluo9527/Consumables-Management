package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentOrderDetailDao;
import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.api.service.ReagentOrderDetailService;
import jp.co.nss.hrm.backend.mapper.ReagentOrderDetailMapper;
import jp.co.nss.hrm.backend.model.ReagentOrderDetail;
import jp.co.nss.hrm.backend.model.ReagentOrderDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReagentOrderDetailServiceImpl implements ReagentOrderDetailService {

    @Autowired
    private ReagentOrderDetailMapper orderDetailMapper;

    @Autowired
    private ReagentOrderDetailDao orderdetailDao;

    /**
     * 获取所有科订单详细信息
     */
    @Override
    public List<ReagentOrderDetail> list() {

        return orderDetailMapper.selectByExample(new ReagentOrderDetailExample());
    }

    /**
     * 添加订单详细信息
     *
     * @param orderDetail
     */
    @Override
    public int create(ReagentOrderDetail orderDetail) {

        orderDetail.setCreateTime(new Date());
        return orderDetailMapper.insert(orderDetail);
    }

    /**
     * 修改订单详细信息
     *
     * @param orderDetail
     */
    @Override
    public int update(ReagentOrderDetail orderDetail) {

        return orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    /**
     * 级联删除订单详细信息
     *
     * @param orderNos
     */

    @Override
    public int delete(List<String> orderNos) {
        ReagentOrderDetailExample example = new ReagentOrderDetailExample();
        example.createCriteria().andOrderNoIn(orderNos);
        int count = orderDetailMapper.deleteByExample(example);
        return count;
    }

    /**
     * 删除指定订单详情
     */

    @Override
    public int delete(Long id) {
        return orderDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页获取订单详细信息
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentOrderDetail> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderdetailDao.selectByOrderNo(keyword);
    }

    /**
     * 分页获取订单详细信息
     *
     * @param keyword
     */
    @Override
    public List<ReagentInfo> listPre(String keyword) {
        return orderdetailDao.selectByOrderNo2(keyword);
    }

    /**
     * 根据订单号获取订单详细信息
     *
     * @param orderNo
     */
    @Override
    public List<ReagentOrderDetail> getItem(String orderNo) {

        return orderdetailDao.selectByOrderNo(orderNo);
    }

    @Override
    public ReagentOrderDetail getItem(Long id) {

        return orderDetailMapper.selectByPrimaryKey(id);
    }

}
