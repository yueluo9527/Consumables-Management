package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.WxUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxUserDao {
    WxUser getWxUserByOpenid(String openid);

    List<WxUser> getWxUsersBySuppliersId(List<Long> suppliersId);

    List<WxUser> getWxUsersBySuppliersCode(List<String> suppliersCode);

    int insertWxUserBySupplierId(@Param("wxUser") WxUser wxUser);

    int insertWxUserBySupplierCode(@Param("wxUser") WxUser wxUser);
}
