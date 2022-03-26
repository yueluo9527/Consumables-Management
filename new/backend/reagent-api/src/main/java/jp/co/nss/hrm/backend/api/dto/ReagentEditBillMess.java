package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReagentEditBillMess {

    private String inDetailId;

    private String reagentName;

    private String factory;

    private String batchNo;

    private Date expireDate;

    private Integer quantity;

}
