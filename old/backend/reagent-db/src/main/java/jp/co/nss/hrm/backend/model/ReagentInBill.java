package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ReagentInBill implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "入库单编号")
    private String billCode;

    @ApiModelProperty(value = "预入库单号-非必填")
    private String preInbillCode;

    @ApiModelProperty(value = "入库单种类：1 一级中心入库单， 2 二级中心入库单，3 科室入库单")
    private String billType;

    @ApiModelProperty(value = "添加种类：1 一级建码入库，2 二级建码入库 3 一级扫码入库，4 二级扫码入库，5 移库 ，6 一级领用，7 二级领用")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getPreInbillCode() {
        return preInbillCode;
    }

    public void setPreInbillCode(String preInbillCode) {
        this.preInbillCode = preInbillCode;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierShortName() {
        return supplierShortName;
    }

    public void setSupplierShortName(String supplierShortName) {
        this.supplierShortName = supplierShortName;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBillCreator() {
        return billCreator;
    }

    public void setBillCreator(String billCreator) {
        this.billCreator = billCreator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", billCode=").append(billCode);
        sb.append(", preInbillCode=").append(preInbillCode);
        sb.append(", billType=").append(billType);
        sb.append(", createType=").append(createType);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierShortName=").append(supplierShortName);
        sb.append(", billDate=").append(billDate);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", branch=").append(branch);
        sb.append(", billCreator=").append(billCreator);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deleteBy=").append(deleteBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}