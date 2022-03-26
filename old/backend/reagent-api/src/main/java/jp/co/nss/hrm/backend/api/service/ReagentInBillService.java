package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.model.ReagentInBill;

import java.util.List;

public interface ReagentInBillService {

    /**
     * 试剂查询
     */
    ReagentItem findReagentItem(String qrCode);

    /**
     * 入库单做成
     */
    int createInBill(ReagentInBillReq req);

    String createInBillPda(ReagentInBillPDAReq req);

    Integer createInBillPdaByOneKey(ReagentInBillPDAReq req, String username);

    /**
     * 添加入库单
     */
    int create(ReagentInBillPost inBill);

    /**
     * 根据入库单类型查询入库单
     */
    List<ReagentInBill> getAllByBillType(String billType);

    /**
     * 修改订单信息
     */
    int update(Long id, ReagentInBill inBill);

    /**
     * 根据入库单号修改入库单状态
     */
    int updateByBC(String billCode, ReagentInBill inBill);

    /**
     * 删除指定订单
     */
    int delete(List<Long> ids);

    /**
     * 删除指定订单
     */
    int deleteByBillCode(String billCode);

    /**
     * 获取入库单列表
     */
    List<ReagentInBill> list(String billType, Integer pageSize, Integer pageNum);

    List<ReagentInBillVm> searchList(String billType, String username, String keyword, Integer pageSize, Integer pageNum);

    List<ReagentItem> searchCodeList(String billCode, String createType);

}
