package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReagentPreInItem implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "入库单编号")
    private String billCode;

    @ApiModelProperty(value = "详细ID")
    private String inDetailId;

    @ApiModelProperty(value = "试剂编号")
    private String reagentCode;

    @ApiModelProperty(value = "试剂在 base_info 中的编码")
    private String code;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "批号")
    private String batchNo;

    @ApiModelProperty(value = "二维码")
    private String qrCode;

    @ApiModelProperty(value = "二维码数据")
    private String codeValue;

    @ApiModelProperty(value = "试剂单位")
    private String reagentUnit;

    @ApiModelProperty(value = "供货商ID")
    private String supplierId;

    @ApiModelProperty(value = "供货商简称")
    private String supplierShortName;

    @ApiModelProperty(value = "试剂规格")
    private String reagentSpecification;

    @ApiModelProperty(value = "生产厂商")
    private String factory;

    @ApiModelProperty(value = "售价")
    private String price;

    @ApiModelProperty(value = "过期时间")
    private Date expireDate;

    @ApiModelProperty(value = "状态")
    private String status;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    @ApiModelProperty(value = "软删除标志: 0, 未删除, 1: 已删除")
    private Byte deleteFlag;

    private Date deleteTime;

    private String deleteBy;

    private static final long serialVersionUID = 1L;
}
