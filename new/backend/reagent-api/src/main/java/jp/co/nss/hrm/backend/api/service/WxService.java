package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.WxUser;

import java.util.List;

public interface WxService {
    WxUser getWxUserByOpenid(String openid);

    List<WxUser> getWxUsersBySuppliersId(List<Long> suppliersId);

    List<WxUser> getWxUsersBySuppliersCode(List<String> suppliersCode);

    int insertWxUserBySupplierId(String openid, Long supplierId);

    int insertWxUserBySupplierCode(String openid, String supplierCode);
}
