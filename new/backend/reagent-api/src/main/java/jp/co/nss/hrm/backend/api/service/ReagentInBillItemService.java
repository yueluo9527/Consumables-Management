package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentInDetailItem;

import java.util.List;

public interface ReagentInBillItemService {

    List<ReagentInDetailItem> getInBillItem(String inDetailId);

    /**
     * 删除指定订单详细信息
     */
    int delete(List<String> billCodes);

    /**
     * 分页获取订单详细信息
     */
    List<ReagentInDetailItem> list(String keyword, Integer pageSize, Integer pageNum);


}


