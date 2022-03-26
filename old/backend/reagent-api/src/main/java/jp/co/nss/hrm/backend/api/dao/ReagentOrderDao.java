package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentEcharts;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.model.ReagentOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentOrderDao {

    List<ReagentEcharts> chartLine(@Param("supplier") String supplier);

    String orderCount(@Param("supplier") String supplier);

    String placeOrderCount(@Param("supplier") String supplier);

    String completedCount(@Param("supplier") String supplier);

    String pendingCount(@Param("supplier") String supplier);

    /**
     * 根据入库单号修改入库单状态
     */
    int updateByON(@Param("orderNo") String orderNo, @Param("orderStatus") String orderStatus);

    /**
     * 根据订单号修改订单价格
     */
    int updateOrderPrice(@Param("orderNo") String orderNo, @Param("reagentPrice") Double reagentPrice);


    List<ReagentOrder> selectBySupplier(@Param("keyword") String keyword, @Param("supplierCode") String supplierCode);

    List<ReagentOrder> select(@Param("keyword") String keyword);

    List<ReagentPreInBillMess> getPrintData(@Param("keyword") String keyword);
}
