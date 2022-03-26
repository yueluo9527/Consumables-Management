package jp.co.nss.hrm.backend.api.dao;

import java.util.List;

import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.model.ReagentOrderDetail;
import org.apache.ibatis.annotations.Param;

/**
 * 订单详细信息管理Dao
 * Created by macro on 2020/2/2.
 */
public interface ReagentOrderDetailDao {

    /**
     * 根据角订单编号获取订单详细信息
     */
    List<ReagentOrderDetail> selectByOrderNo(@Param("keyword") String keyword);

    /**
     * 根据角订单编号获取订单详细信息
     */
    List<ReagentInfo> selectByOrderNo2(@Param("keyword") String keyword);

    /**
     * 根据角订单编号获取订单详细信息
     */
    List<ReagentOrderDetail> selectUnSendDetail(@Param("keyword") String keyword);
}
