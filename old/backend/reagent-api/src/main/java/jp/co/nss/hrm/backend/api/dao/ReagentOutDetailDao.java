package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentOutIn;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentOutDetailDao {

    /**
     * 根据出库编号获取出库详细信息
     */
    List<ReagentOutDetail> selectByBillCode(@Param("keyword") String keyword);


    /**
     * 批量插入
     */
    int insertOutDetail(List<ReagentOutDetail> outDetailList);

    List<ReagentOutDetail> outSummary(@Param("branch") String branch, @Param("reagentName") String reagentName, @Param("startTime") String startTime, @Param("endTime") String endTime);


}
