package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReagentPreInBillMess {
    private String code;

    private String supplierId;

    private String supplierShortName;

    private String factory;

    private Integer quantity;

    private Double price;

    private String batchNo;

    private Date expireDate;

    private String supplierName;

    private String supplierContacts;

    private String billCode;

    private Date createTime;

    private String trueName;

    private String billCreator;

    private String billBranch;

    private String applicationUser;

    private String applicationBranch;
}
