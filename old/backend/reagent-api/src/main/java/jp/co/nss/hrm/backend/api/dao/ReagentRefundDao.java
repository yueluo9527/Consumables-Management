package jp.co.nss.hrm.backend.api.dao;

import cn.hutool.core.date.DateTime;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.api.dto.ReagentStatus;
import jp.co.nss.hrm.backend.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentRefundDao {

    /**
     * 根据入库单类型获取预入库列表
     */
    List<ReagentRefund> getAllByRefundType(@Param("refundType") String refundType);


    List<ReagentStockDetail> getAlterStockList(@Param("reagentId") String reagentId, @Param("number") Integer number);

    /**
     * 根据退货编号获取退货详细信息
     */
    List<ReagentRefund> searchByDate(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("refundType") String refundType);


    List<ReagentRefund> searchList(@Param("refundType") String refundType, @Param("keyword") String keyword);

    List<ReagentRefund>  selectByBranch(@Param("refundType") String refundType, @Param("keyword") String keyword, @Param("branch") String branch,@Param("supplier") String supplier);

    List<ReagentRefundDetail> countRefund(@Param("refundType") String refundType);

    List<ReagentRefund>  select(@Param("refundType") String refundType,@Param("keyword") String keyword);

    ReagentStatus countOutIn(@Param("stockType") String stockType,@Param("branch") String branch, @Param("supplier") String supplier,@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReagentPreInBillMess> getPrintData(@Param("keyword") String keyword);
}
