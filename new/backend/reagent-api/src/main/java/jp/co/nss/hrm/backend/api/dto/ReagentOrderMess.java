package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

@Data
public class ReagentOrderMess {
    private String reagentCode;

    private String supplierId;

    private String supplierName;

    private Integer number;

    private String specification;

    private String manufacturerName;
}
