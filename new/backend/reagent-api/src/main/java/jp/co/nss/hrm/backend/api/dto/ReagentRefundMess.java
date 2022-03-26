package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReagentRefundMess {

    private String stockNo;

    private String reagentId;

    private String supplierShortName;

    private Integer quantity;

    private Double reagentPrice;

    private String qrCode;

    private List<String> reagentCodeList = new ArrayList<>();

    private List<String> qrList = new ArrayList<>();

    private List<String> qrCodeValueList = new ArrayList<>();

}
