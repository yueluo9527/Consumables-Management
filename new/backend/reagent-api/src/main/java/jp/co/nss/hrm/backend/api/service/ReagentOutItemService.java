package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.ReagentOutDetailItem;

import java.util.List;

public interface ReagentOutItemService {

    List<ReagentOutDetailItem> getItem(String outDetailId);

    /**
     * 删除指定订单详细信息
     */
    int delete(List<String> billCodes);

    List<ReagentOutDetailItem> list(String keyword, Integer pageSize, Integer pageNum);

}


