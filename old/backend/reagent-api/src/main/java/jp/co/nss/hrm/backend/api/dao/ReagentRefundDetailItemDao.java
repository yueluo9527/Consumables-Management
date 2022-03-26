package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentRefundItem;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentRefundDetailItemDao {

    /**
     * 根据预入库详情号获取订单详细信息
     */
    List<ReagentRefundDetailItem> selectByRefundDetailId(@Param("keyword") String keyword);

    /**
     * 据预入库单号获取订单详细信息
     */
    List<ReagentRefundDetailItem> selectByRefundCode(@Param("refundCode") String refundCode);

    /**
     * 批量插入
     */
    int insertItem(List<ReagentRefundItem> refundDetailItemList);

    /**
     * 组合查询
     */
    List<ReagentRefundDetailItem> searchByDouble(String refundCode, String refundDetailId);
}
