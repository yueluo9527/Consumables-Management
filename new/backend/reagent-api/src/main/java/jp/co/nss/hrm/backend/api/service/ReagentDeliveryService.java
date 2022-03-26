package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentOutBill;

import java.util.List;

public interface ReagentDeliveryService {


    ReagentOutBill getItem(Long id);


    /**
     * 获取所有库存信息列表
     */

    List<ReagentOutBill> list();

    /**
     * 添加库存信息
     */
    int create(ReagentOutBill delivery);

    /**
     * 修改库存信息
     */
    int update(Long id, ReagentOutBill delivery);

    /**
     * 删除指定库存
     */
    int delete(Long id);

    /**
     * 分页获取库存列表
     */
    List<ReagentOutBill> list(String keyword, Integer pageSize, Integer pageNum);

    //List<ReagentDelivery> search(Integer reagentId, String reagentName, String supplierName, String factory, String reagentStatus, String reagentTemp);

}



