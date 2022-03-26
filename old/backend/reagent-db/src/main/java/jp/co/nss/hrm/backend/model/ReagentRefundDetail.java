package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ReagentRefundDetail implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "退货单详情编号")
    private String refundCode;

    @ApiModelProperty(value = "退货单详细ID")
    private String refundDetailId;

    @ApiModelProperty(value = "试剂ID")
    private String reagentId;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "规格型号")
    private String reagentSpecification;

    @ApiModelProperty(value = "批号")
    private String batchNo;

    @ApiModelProperty(value = "生产厂家")
    private String factory;

    @ApiModelProperty(value = "注册证号")
    private String registrationNo;

    @ApiModelProperty(value = "供货商名")
    private String supplierShortName;

    @ApiModelProperty(value = "单位")
    private String reagentUnit;

    @ApiModelProperty(value = "单价")
    private Double reagentPrice;

    @ApiModelProperty(value = "数量")
    private Long quantity;

    @ApiModelProperty(value = "金额")
    private Double total;

    @ApiModelProperty(value = "退货时间")
    private Date createTime;

    @ApiModelProperty(value = "退货人")
    private String createBy;

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

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public String getRefundDetailId() {
        return refundDetailId;
    }

    public void setRefundDetailId(String refundDetailId) {
        this.refundDetailId = refundDetailId;
    }

    public String getReagentId() {
        return reagentId;
    }

    public void setReagentId(String reagentId) {
        this.reagentId = reagentId;
    }

    public String getReagentName() {
        return reagentName;
    }

    public void setReagentName(String reagentName) {
        this.reagentName = reagentName;
    }

    public String getReagentSpecification() {
        return reagentSpecification;
    }

    public void setReagentSpecification(String reagentSpecification) {
        this.reagentSpecification = reagentSpecification;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getSupplierShortName() {
        return supplierShortName;
    }

    public void setSupplierShortName(String supplierShortName) {
        this.supplierShortName = supplierShortName;
    }

    public String getReagentUnit() {
        return reagentUnit;
    }

    public void setReagentUnit(String reagentUnit) {
        this.reagentUnit = reagentUnit;
    }

    public Double getReagentPrice() {
        return reagentPrice;
    }

    public void setReagentPrice(Double reagentPrice) {
        this.reagentPrice = reagentPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        sb.append(", refundCode=").append(refundCode);
        sb.append(", refundDetailId=").append(refundDetailId);
        sb.append(", reagentId=").append(reagentId);
        sb.append(", reagentName=").append(reagentName);
        sb.append(", reagentSpecification=").append(reagentSpecification);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", factory=").append(factory);
        sb.append(", registrationNo=").append(registrationNo);
        sb.append(", supplierShortName=").append(supplierShortName);
        sb.append(", reagentUnit=").append(reagentUnit);
        sb.append(", reagentPrice=").append(reagentPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", total=").append(total);
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