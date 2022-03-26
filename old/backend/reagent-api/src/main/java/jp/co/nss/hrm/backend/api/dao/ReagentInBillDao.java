package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.model.ReagentInBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentInBillDao {

    int insert(ReagentInBillVm record);

    /**
     * 根据入库单类型获取预入库列表
     */
    List<ReagentInBill> getAllByBillType(@Param("billType") String billType);

    /**
     * 根据入库单号修改入库单状态
     */
    int updateByBC(@Param("billCode") String billCode, @Param("billStatus") String billStatus);

    List<ReagentInBill> searchList(@Param("billType") String billType, @Param("keyword") String keyword);

    ReagentItem findReagentItem(@Param("qrCode") String qrCode);

    List<ReagentInBillVm> selectByBranch(@Param("billType") String billType, @Param("keyword") String keyword, @Param("branch") String branch);

    List<ReagentInBillVm> select(@Param("billType") String billType, @Param("keyword") String keyword);

    /**
     * 根据订单详细编号获取供货商名
     */
    String selectSupplier(@Param("billCode") String billCode);

    ReagentStatus countIn(@Param("stockType") String stockType, @Param("branch") String branch, @Param("supplier") String supplier, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int deleteByInBillCode(@Param("inBillCode") String inBillCode);

    /**
     * 批量删除
     */
    int deleteByInBillCodeList(List<String> inBillCodeList);

    List<ReagentOutIn> reagentOutIn(@Param("branch") String branch, @Param("supplier") String supplier, @Param("reagentName") String reagentName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 随货同行单已入库，需要清除该同行单名下的所有草稿单
     * 根据预入库单，返回所有仍为草稿的入库单
     *
     * @param preInBillCode String 预入库单号
     * @return inBillCode List<> 入库单号
     */
    List<String> getInCodeListByPreInCode(@Param("preInBillCode") String preInBillCode);

    List<ReagentPreInBillMess> getPrintData(@Param("keyword") String keyword);

    List<ReagentPreInBillMess> getBranchPrintData(@Param("keyword") String keyword);

}
