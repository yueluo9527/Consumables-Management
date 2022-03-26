package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dto.ReagentEditBillPost;
import jp.co.nss.hrm.backend.api.dto.ReagentInBillDetail;
import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.model.ReagentInDetail;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;

import java.util.List;

public interface ReagentInBillDetailService {

    /**
     * 试剂出库报表
     */
    PageInfo<ReagentInBillDetail> inSummary(String username, String reagentName, String startTime, String endTime, Integer pageSize, Integer pageNum);


    List<ReagentInBillDetail> getInBillDetail(String billCode);

    /**
     * 修改订单详细信息
     */
    int update(ReagentInDetail inDetail);

    /**
     * 删除指定订单详细信息
     */
    int delete(List<String> billCodes);

    /**
     * 删除指定订单详细信息
     */
    int delete(Long id);

    /**
     * 分页获取详细信息列表
     */
    List<ReagentInBillDetail> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 编辑状态分页获取详细信息列表
     */
    List<ReagentInfo> listInBill(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 编辑入库单
     */
    int editInBill(ReagentEditBillPost editBill);

    /**
     * 提交入库单
     */
    int subInBill(ReagentEditBillPost subBill);
}


