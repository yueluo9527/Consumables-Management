package jp.co.nss.hrm.backend.api.service.impl;

import jp.co.nss.hrm.backend.api.dao.WxUserDao;
import jp.co.nss.hrm.backend.api.dto.WxUser;
import jp.co.nss.hrm.backend.api.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WxServiceImpl implements WxService {
    @Autowired
    private WxUserDao wxUserDao;

    // 根据 openid 获取用户信息
    public WxUser getWxUserByOpenid(String openid) {
        return wxUserDao.getWxUserByOpenid(openid);
    }

    // 根据供货商 id 查询绑定的微信用户 list
    public List<WxUser> getWxUsersBySuppliersId(List<Long> suppliersId) {
        return wxUserDao.getWxUsersBySuppliersId(suppliersId);
    }

    // 根据 suppliersCode 查询绑定的微信用户 list
    public List<WxUser> getWxUsersBySuppliersCode(List<String> suppliersCode) {
        return wxUserDao.getWxUsersBySuppliersCode(suppliersCode);
    }

    // 根据 supplierId 新关联供货商联系人微信
    public int insertWxUserBySupplierId(String openid, Long supplierId) {
        WxUser wxUser = new WxUser();

        wxUser.setOpenid(openid);
        wxUser.setSupplierId(supplierId);
        return wxUserDao.insertWxUserBySupplierId(wxUser);
    }

    // 根据 supplierCode 新关联供货商联系人微信
    public int insertWxUserBySupplierCode(String openid, String supplierCode) {
        WxUser wxUser = new WxUser();

        wxUser.setOpenid(openid);
        wxUser.setSupplierCode(supplierCode);
        return wxUserDao.insertWxUserBySupplierCode(wxUser);
    }
}
