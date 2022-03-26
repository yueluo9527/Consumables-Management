package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.model.ReagentPreInBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentPreInBillDao {

    ReagentPreInBill selectByBillCode(@Param("billCode") String billCode);

    List<ReagentPreInBill> selectBySupplier(@Param("keyword") String keyword, @Param("supplierCode") String supplierCode);

    List<ReagentPreInBill> select(@Param("keyword") String keyword);

    int updateStatus(@Param("billCode") String billCode, @Param("billStatus") String billStatus);

    String orderCount(@Param("supplier") String supplier);

    List<ReagentPreInBillMess> getPrintData(@Param("keyword") String keyword);
}
