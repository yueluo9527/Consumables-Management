package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 出入库项目
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class ReagentItem {
    private Long billId;

    private Long detailId;

    private Long qrId;

    @ApiModelProperty(value = "试剂耗材ID")
    private Long reagentId;

    @ApiModelProperty(value = "系统批号")
    private String batchNo;

    @ApiModelProperty(value = "到期日期")
    private Date expireDate;

    @ApiModelProperty(value = "开启有效期")
    private int openPeriod;

    @ApiModelProperty(value = "二维码")
    private String qrCode;

    @ApiModelProperty(value = "二维码内容")
    private String qrCodeValue;

    @ApiModelProperty(value = "试剂耗材编号")
    private String code;

    @ApiModelProperty(value = "试剂code")
    private String reagentCode;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "供货商名")
    private String supplierShortName;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturerName;

    @ApiModelProperty(value = "单位")
    private String reagentUnit;

    @ApiModelProperty(value = "规格型号")
    private String reagentSpecification;

    @ApiModelProperty(value = "注册证号")
    private String registrationNo;

    @ApiModelProperty(value = "单价")
    private Double reagentPrice;

    @ApiModelProperty(value = "同批号类型在库数量")
    private long reagentCount;

    @ApiModelProperty(value = "同科室同类试剂数量")
    private long reagentNumber;

    @ApiModelProperty(value = "金额")
    private Double total;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "科室名")
    private String branch;

    @ApiModelProperty(value = "试剂状态")
    // 0-丢失；1-破损；2-过期；3-用尽；4-其它原因库损；5-退货
    private String reagentStatus;

    @ApiModelProperty(value = "出库人")
    private String outMan;

    @ApiModelProperty(value = "领用人")
    private String applyMan;

    @ApiModelProperty(value = "出库时间")
    private Date outTime;

    @ApiModelProperty(value = "更早过期的试剂数量")
    private Integer earlierNum;

    @ApiModelProperty(value = "随货详细中试剂状态")
    // 0-未入库；1-已入库
    private String billStatus;

    @ApiModelProperty(value = "上机的设备名")
    private String deviceName;

    @ApiModelProperty(value = "上机的设备编号（非设备id）")
    private String deviceCode;

}
