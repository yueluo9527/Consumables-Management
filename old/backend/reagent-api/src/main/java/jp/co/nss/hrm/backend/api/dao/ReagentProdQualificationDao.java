package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentProdQualification;

import java.util.List;

public interface ReagentProdQualificationDao {

    List<ReagentProdQualification> prodList(String supplier,String supplierName, String reagentName);
}
