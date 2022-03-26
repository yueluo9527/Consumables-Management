package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReagentInBillMessPDA implements Serializable {
    private String billCode;

    private String code;

    private String reagentCode;

    private String reagentName;

    private String reagentUnit;

    private String createBy;

    private String supplierId;

    private String supplierShortName;

    private String reagentSpecification;

    private String factory;

    private Integer quantity;

    private Double price;

    private String batchNo;

    private Date expireDate;

    private String qrCode;

    private String codeValue;

    private Integer inBillNumber;

    private List<String> qrList = new ArrayList<>();

    private List<String> qrCodeValueList = new ArrayList<>();

    private List<String> reagentCodeList = new ArrayList<>();

}
