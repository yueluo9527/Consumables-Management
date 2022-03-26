package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.ReagentRefundPost;
import jp.co.nss.hrm.backend.api.dto.ReagentStockReqPost;
import jp.co.nss.hrm.backend.model.ReagentRefund;
import jp.co.nss.hrm.backend.model.ReagentRefundDetail;

import java.util.List;

public interface ReagentRefundService {

    ReagentRefund getItem(Long id);

    /**
     * 获取所有领用信息列表
     */
    List<ReagentRefund> list();

    /**
     * 添加领用
     */
    int create(ReagentRefundPost refund);

    /**
     * PDA添加领用
     */
    int createBill(ReagentStockReqPost refund);

    /**
     * 根据申请单类型查询申请单
     */
    List<ReagentRefund> getAllByRefundType(String refundType);

    /**
     * 修改领用信息
     */
    int update(Long id, ReagentRefund refund);

    /**
     * 删除指定领用
     */
    int delete(List<Long> ids);

    /**
     * 分页获取领用列表
     */
    List<ReagentRefund> list(String refundType,String keyword, String username,Integer pageSize, Integer pageNum);

    /**
     * 根据申请编号删除
     */
    int deleteByRefundCode(String refundCode);

    /**
     * 分页获取领用详细信息
     */
    List<ReagentRefund> searchByDate(String startTime, String endTime, String refundType, Integer pageSize, Integer pageNum);



    List<ReagentRefundDetail> countRefund(String refundType, String username, Integer pageSize, Integer pageNum);



}


