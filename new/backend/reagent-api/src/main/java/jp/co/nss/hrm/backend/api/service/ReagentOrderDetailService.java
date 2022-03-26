package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.model.ReagentOrderDetail;

import java.util.List;

public interface ReagentOrderDetailService {

    List<ReagentOrderDetail> getItem(String orderNo);

    ReagentOrderDetail getItem(Long id);

    /**
     * 获取所有订单详细信息列表
     */

    List<ReagentOrderDetail> list();

    /**
     * 添加订单详细信息
     */
    int create(ReagentOrderDetail orderDetail);

    /**
     * 修改订单详细信息
     */
    int update(ReagentOrderDetail orderDetail);

    /**
     * 删除指定订单详细信息
     */
    int delete(List<String> orderNos);

    /**
     * 删除指定订单详细信息
     */
    int delete(Long id);

    /**
     * 分页获取订单详细信息
     */
    List<ReagentOrderDetail> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 分页获取订单详细信息
     */
    List<ReagentInfo> listPre(String keyword);
}


