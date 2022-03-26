package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentSupplier;

import java.util.List;

public interface ReagentSupplierService {
    ReagentSupplier getItem(Long id);


    /**
     * 获取所有供应商列表
     */

    List<ReagentSupplier> list();

    /**
     * 添加供应商
     */
    int create(ReagentSupplier supplier);

    /**
     * 修改供应商信息
     */
    int update(Long id, ReagentSupplier supplier);
    /**
     * 修改供应商状态
     */
    int updateStatus(Long id, ReagentSupplier supplier);
    /**
     * 删除供应商
     */
    int delete(Long id);

    /**
     * 分页获取供应商列表
     */
    List<ReagentSupplier> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据id获取供货商手机号
     * @param suppliersId Array SupplierID
     * @return Array 手机号
     */
    String[] getPhonesNumBySuppliersID(List<String> suppliersId);

    /**
     * 根据手机号获取供货商 id
     */
    Long getSupplierIdByPhoneNumber(String phoneNumber);

    /**
     * 根据手机号获取供货商 code
     */
    String getSupplierCodeByPhoneNumber(String phoneNumber);

}

