package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ReagentInBillVm {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "入库单编号")
    private String billCode;

    @ApiModelProperty(value = "预入库单号")
    private String preInBillCode;

    @ApiModelProperty(value = "入库单种类：1 一级中心入库单， 2 二级中心入库单，3 科室入库单")
    private String billType;

    @ApiModelProperty(value = "添加种类：1 一级建码入库，2 二级建码入库 3 一级扫码入库，4 二级扫码入库")
    private String createType;

    @ApiModelProperty(value = "供货商ID")
    private String supplierId;

    @ApiModelProperty(value = "供货商名")
    private String supplierShortName;

    @ApiModelProperty(value = "单据日期（业务发生的日期，不一定等于单据创建时间，根据单据不同，在此单为入库日期）")
    private Date billDate;

    @ApiModelProperty(value = "单据状态：0-草稿，1-已入库 ")
    private String billStatus;

    @ApiModelProperty(value = "科室库名")
    private String branch;

    @ApiModelProperty(value = "制单人")
    private String billCreator;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private String createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private String updateBy;

    @ApiModelProperty(value = "软删除标志: 0, 未删除, 1: 已删除")
    private Byte deleteFlag;

    private Date deleteTime;

    private String deleteBy;

    private static final long serialVersionUID = 1L;

}
