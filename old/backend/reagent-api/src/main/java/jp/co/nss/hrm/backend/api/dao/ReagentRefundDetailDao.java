package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentRefundDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentRefundDetailDao {

    /**
     * 根据退货编号获取退货详细信息
     */
    List<ReagentRefundDetail> selectByRefundCode(@Param("keyword") String keyword);

    /**
     * 批量插入
     */
    int insertRefundDetail(List<ReagentRefundDetail> refundDetailList);
}
