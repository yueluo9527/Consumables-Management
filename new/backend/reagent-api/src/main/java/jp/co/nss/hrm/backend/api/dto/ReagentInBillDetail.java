package jp.co.nss.hrm.backend.api.dto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReagentInBillDetail implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "入库单编号")
    private String billCode;

    @ApiModelProperty(value = "入库单详细ID")
    private String inDetailId;

    @ApiModelProperty(value = "试剂ID")
    private String reagentId;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "单位")
    private String reagentUnit;

    @ApiModelProperty(value = "规格型号")
    private String reagentSpecification;

    @ApiModelProperty(value = "生产厂家")
    private String factory;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "数量")
    private Long quantity;

    @ApiModelProperty(value = "金额")
    private Double total;

    @ApiModelProperty(value = "批号")
    private String batchNo;

    @ApiModelProperty(value = "保质期")
    private Date expireDate;

    @ApiModelProperty(value = "备注")
    private String remark;

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
