package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReagentStockDetailReq {

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "试剂ID")
    private String reagentId;

    @ApiModelProperty(value = "在库数量")
    private int stockNumber;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturerName;

    @ApiModelProperty(value = "供货商名")
    private String supplierShortName;

    @ApiModelProperty(value = "状态: 0：丢失，1：破损，2：过期，3：用尽，4.其他 ")
    private String reagentStatus;

    @ApiModelProperty(value = "储存温度: 常温，冷藏，冷冻")
    private String reagentTemp;

    @ApiModelProperty(value = "库存编号")
    private String keyword;

    @ApiModelProperty(value = "试剂编号")
    private String reagentCode;

    @ApiModelProperty(value = "产品批号")
    private String batchNo;

    @ApiModelProperty(value = "库存有效期")
    private String expireDate;

    @ApiModelProperty(value = "入库时间")
    private String enterTime;

    @ApiModelProperty(value = "入库单号")
    private String enterNo;

    @ApiModelProperty(value = "入库人")
    private String enterMan;

    @ApiModelProperty(value = "出库时间")
    private String outTime;

    @ApiModelProperty(value = "出库单号")
    private String outNo;

    @ApiModelProperty(value = "出库人")
    private String outMan;

    @ApiModelProperty(value = "申领人")
    private String applyMan;

    @ApiModelProperty(value = "用户名")
    private String username;

    private Integer pageSize;

    private Integer pageNum;

}
