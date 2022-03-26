package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dto.ReagentOutIn;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;

import java.util.List;

public interface ReagentOutDetailService {

    List<ReagentOutDetail> getItem(String outBillId);

    /**
     * 删除指定订单详细信息
     */
    int delete(List<String> billCodes);

    List<ReagentOutDetail> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 试剂出库报表
     */
    PageInfo<ReagentOutDetail> outSummary(String username, String reagentName, String startTime, String endTime, Integer pageSize, Integer pageNum);

}


