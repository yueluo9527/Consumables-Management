package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentInBillDetail;
import jp.co.nss.hrm.backend.api.dto.ReagentInBillMessPDA;
import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentInDetailDao {


    List<ReagentInBillDetail> inSummary(@Param("branch") String branch, @Param("reagentName") String reagentName, @Param("startTime") String startTime, @Param("endTime") String endTime);


    /**
     * 根据订单编号获取预入库详细信息
     */
    List<ReagentInBillDetail> selectByBillCode(@Param("keyword") String keyword);

    /**
     * 编辑状态根据订单编号获取预入库详细信息
     */
    List<ReagentInfo> selectByBillCode2(@Param("keyword") String keyword);

    /**
     * 批量插入
     */
    int insertInDetail(List<ReagentInBillDetail> reagentInDetailList);

    int deleteByInBillCode(@Param("inBillCode") String inBillCode);

    /**
     * 批量删除
     * @param inBillCodeList inBillCodeList
     * @return int
     */
    int deleteByInBillCodeList(List<String> inBillCodeList);
}
