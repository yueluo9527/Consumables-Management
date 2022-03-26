package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReagentInBillMess {
    private String code;

    private String reagentName;

    private String reagentUnit;

    private String supplierId;

    private String supplierShortName;

    private String reagentSpecification;

    private String factory;

    private Integer quantity;

    private Double price;

    private String batchNo;

    private Date expireDate;


}
