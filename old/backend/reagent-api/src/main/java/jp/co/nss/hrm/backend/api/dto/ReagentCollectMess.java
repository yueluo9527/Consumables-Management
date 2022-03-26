package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ReagentCollectMess implements Serializable {

    private String stockNo;

    private String reagentId;

    private String reagentCode;

    private String reagentName;

    private String supplierId;

    private String supplierShortName;

    private Integer reagentNumber;

    private Double reagentPrice;

    private String qrCode;

    private String codeValue;

    private String reagentSpecification;

    private String batchNo;

    private String manufacturerName;

    private String registrationNo;

    private String reagentUnit;

    private String reagentType;

    private String factory;

    private Long quantity;

    private Date expireDate;

    private List<String> qrList;

    private List<String> qrCodeValueList;

    private List<String> reagentCodeList;

    // 移库 必填，用于更新入库申请单状态
    private String collectNo;

    // 出库单种类：1.科室库-单级领用/移库/退货出库单, 2.科室库领用/退货出库,3.中心库移库/退货出库
    private String outType;

    // 入库单种类：1 科室库-单级入库单， 2 中心入库单，3 科室库-两级入库单
    private String inType;

    // 添加种类：1 一级建码入库，2 二级建码入库 3 一级扫码入库，4 二级扫码入库，5 移库 ，6 一级领用，7 二级领用
    private String createType;

}
