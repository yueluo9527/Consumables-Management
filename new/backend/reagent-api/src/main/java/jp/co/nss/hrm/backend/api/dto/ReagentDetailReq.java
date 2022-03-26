package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ReagentDetailReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "入库单ID")
    private Long inBillId;

    @ApiModelProperty(value = "试剂ID")
    private Long reagentId;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "规格型号")
    private String reagentSpecification;

    @ApiModelProperty(value = "生产厂家")
    private String factory;

    @ApiModelProperty(value = "注册证号")
    private String registrationNo;

    @ApiModelProperty(value = "供货商名")
    private String supplierShortName;

    @ApiModelProperty(value = "单位")
    private String reagentUnit;

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

    @ApiModelProperty(value = "使用时间")
    private Date useTime;

    @ApiModelProperty(value = "试剂编号")
    private String reagentCode;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    @ApiModelProperty(value = "软删除标志: 0, 未删除, 1: 已删除")
    private Byte deleteFlag;

    private Date deleteTime;

    private String deleteBy;

    private List<String> qrList;

    private List<Long> qrIdList;

    private List<String> qrCodeValueList;

    private List<String> reagentCodeList;

}
