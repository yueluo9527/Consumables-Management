package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentInBillMessPDA;
import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.model.ReagentInDetailItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentInDetailItemDao {

    /**
     * 根据角订单编号获取预入库订单详细信息
     */
    List<ReagentInDetailItem> selectByInDetailId(@Param("inDetailId") String inDetailId);

    /**
     * 批量插入
     */
    int insertBillItem(List<ReagentInDetailItem> reagentInDetailItemList);

    int deleteByInBillCode(@Param("inBillCode") String inBillCode);

    /**
     * 批量删除
     */
    int deleteByInBillCodeList(List<String> inBillCodeList);

    List<ReagentItem> searchCodeByBC(@Param("billCode") String billCode, @Param("status") String status);

    List<ReagentInBillMessPDA> searchThreeValue(@Param("inBillCode") String inBillCode, @Param("reagentId") String reagentId, @Param("batchNo") String batchNo);
}
