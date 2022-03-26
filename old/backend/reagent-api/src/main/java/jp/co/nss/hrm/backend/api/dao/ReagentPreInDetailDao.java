package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.model.ReagentPreInDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 预入库详细信息管理Dao
 * Created by macro on 2021/3/11.
 */
public interface ReagentPreInDetailDao {

    /**
     * 根据订单编号获取预入库订单详细信息
     */
    List<ReagentPreInDetail> selectByBillCode(@Param("keyword") String keyword);

    List<ReagentItem> searchByBillCode(@Param("keyword") String keyword);

    /**
     * 批量插入
     */
    int insertBach(List<ReagentPreInDetail> preInDetailList);

    String countBatchNo(@Param("reagentId") String reagentId, @Param("batchNo") String batchNo);

    List<ReagentPreInBillMess> countCodeAndNum(@Param("orderNo") String orderNo);

    int updateStatus(@Param("billCode") String billCode, @Param("billStatus") String billStatus);
}
