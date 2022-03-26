package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReagentOutIn {

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "供货商")
    private String supplierName;

    @ApiModelProperty(value = "入库数量")
    private Long inQuantity;

    @ApiModelProperty(value = "入库金额")
    private double inTotal;

    @ApiModelProperty(value = "退货数量")
    private Long refundQuantity;

    @ApiModelProperty(value = "退货金额")
    private double refundTotal;

    @ApiModelProperty(value = "出库数量")
    private Long outQuantity;

    @ApiModelProperty(value = "出库金额")
    private double outTotal;

    @ApiModelProperty(value = "净入库数量")
    private Long cleanQuantity;

    @ApiModelProperty(value = "净入库金额")
    private double cleanTotal;
}
