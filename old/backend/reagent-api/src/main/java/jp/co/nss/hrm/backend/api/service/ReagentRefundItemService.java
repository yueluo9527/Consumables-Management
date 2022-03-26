package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentRefundDetailItem;

import java.util.List;

public interface ReagentRefundItemService {

    List<ReagentRefundDetailItem> getItemByRDI(String refundDetailId);

    List<ReagentRefundDetailItem> getItemByRC(String refundCode);

    /**
     * 组合查询
     */
    List<ReagentRefundDetailItem> search(String refundCode, String refundDetailId, Integer pageSize, Integer pageNum);

    /**
     * 删除指定订单详细信息
     */
    int delete(List<String> refundCodes);

    List<ReagentRefundDetailItem> list(String keyword, Integer pageSize, Integer pageNum);
}


