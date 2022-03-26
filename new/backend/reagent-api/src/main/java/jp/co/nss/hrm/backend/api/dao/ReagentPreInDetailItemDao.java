package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentCollectMess;
import jp.co.nss.hrm.backend.api.dto.ReagentInBillMessPDA;
import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInItem;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentPreInDetailItemDao {

    /**
     * 根据二维码查询试剂详细信息
     */
    ReagentPreInItem selectByInDetailQrcode(@Param("qrCode") String qrCode);
    
    /**
     * 根据预入库详情号获取订单详细信息
     */
    List<ReagentPreInDetailItem> selectByInDetailId(@Param("keyword") String keyword);

    /**
     * 据预入库单号获取订单详细信息
     */
    List<ReagentPreInDetailItem> selectByBillCode(@Param("billCode") String billCode);

    /**
     * 批量插入
     */
    int insertItem(List<ReagentPreInDetailItem> preInDetailItemList);

    /**
     * 组合查询
     */
    List<ReagentPreInDetailItem> searchByDouble(String billCode, String inDetailId);

    /**
     * 根据二维码查询预入库单编号
     */
    String getPreCode(@Param("qrCode") String qrCode);

    int updateStatus(@Param("billCode") String billCode, @Param("billStatus") String billStatus);

    /**
     * 根据随货单号，试剂名称，批号查询试剂二维码，二维码值，试剂编号
     */
    List<ReagentInBillMessPDA> searchThreeValue(@Param("preInBillCode") String preInBillCode, @Param("reagentName") String reagentName, @Param("batchNo") String batchNo);


    List<ReagentItem> searchCodeByBC(@Param("billCode") String billCode);
}
