package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.ReagentOutBillReq;
import jp.co.nss.hrm.backend.model.ReagentOutBill;

import java.util.List;

public interface ReagentOutBillService {

    List<ReagentOutBill> list(String billType, String keyword, String username, Integer pageSize, Integer pageNum);

    /**
     * 删除指定订单
     */
    List<ReagentOutBill> getAllByBillType(String billType);

    List<ReagentOutBill> list(String billType, Integer pageSize, Integer pageNum);

    /**
     * 创建pda出库单信息
     */
    int createOutBill(ReagentOutBillReq req);

    /**
     * 创建pda出库单信息
     */
    int createOutDoc(ReagentOutBillReq req);

    /**
     * 删除指定订单
     */
    int delete(List<Long> ids);
}
