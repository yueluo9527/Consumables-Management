package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.api.dto.ReagentStatus;
import jp.co.nss.hrm.backend.model.ReagentInBill;
import jp.co.nss.hrm.backend.model.ReagentOutBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentOutBillDao {

    /**
     * 根据出库类型获取出库列表
     */
    List<ReagentOutBill> getAllByBillType(@Param("billType") String billType);

    /**
     * 根据科室名称获取列表
     */
    List<ReagentOutBill> selectByBranch(@Param("billType") String billType, @Param("keyword") String keyword, @Param("branch") String branch);

    List<ReagentOutBill> select(@Param("billType") String billType, @Param("keyword") String keyword);

    ReagentStatus countOut(@Param("stockType") String stockType, @Param("branch") String branch, @Param("supplier") String supplier, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReagentPreInBillMess> getPrintData(@Param("keyword") String keyword);
}
