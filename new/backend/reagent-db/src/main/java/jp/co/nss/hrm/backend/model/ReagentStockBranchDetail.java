package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReagentStockBranchDetail implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    private String stockNo;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "试剂耗材ID")
    private Long reagentId;

    @ApiModelProperty(value = "产品批号")
    private String reagentNo;

    @ApiModelProperty(value = "库存有效期")
    private String expireDate;

    @ApiModelProperty(value = "库存数量")
    private BigDecimal quantity;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    @ApiModelProperty(value = "软删除标志: 0, 未删除, 1: 已删除")
    private Byte deleteFlag;

    @ApiModelProperty(value = "过期预警")
    private Long overdue;

    @ApiModelProperty(value = "入库时间")
    private Date enterTime;

    @ApiModelProperty(value = "入库单号")
    private Long enterNo;

    @ApiModelProperty(value = "入库人")
    private String enterMan;

    @ApiModelProperty(value = "出库时间")
    private Date outTime;

    @ApiModelProperty(value = "出库单号")
    private Long outNo;

    @ApiModelProperty(value = "出库人")
    private String outMan;

    @ApiModelProperty(value = "申领人")
    private String applyMan;

    @ApiModelProperty(value = "开启有效期")
    private String openPeriod;

    @ApiModelProperty(value = "单价")
    private BigDecimal reagentPrice;

    private Date deleteTime;

    private String deleteBy;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public String getReagentName() {
        return reagentName;
    }

    public void setReagentName(String reagentName) {
        this.reagentName = reagentName;
    }

    public Long getReagentId() {
        return reagentId;
    }

    public void setReagentId(Long reagentId) {
        this.reagentId = reagentId;
    }

    public String getReagentNo() {
        return reagentNo;
    }

    public void setReagentNo(String reagentNo) {
        this.reagentNo = reagentNo;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    public Long getOverdue() {
        return overdue;
    }

    public void setOverdue(Long overdue) {
        this.overdue = overdue;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Long getEnterNo() {
        return enterNo;
    }

    public void setEnterNo(Long enterNo) {
        this.enterNo = enterNo;
    }

    public String getEnterMan() {
        return enterMan;
    }

    public void setEnterMan(String enterMan) {
        this.enterMan = enterMan;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Long getOutNo() {
        return outNo;
    }

    public void setOutNo(Long outNo) {
        this.outNo = outNo;
    }

    public String getOutMan() {
        return outMan;
    }

    public void setOutMan(String outMan) {
        this.outMan = outMan;
    }

    public String getApplyMan() {
        return applyMan;
    }

    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
    }

    public String getOpenPeriod() {
        return openPeriod;
    }

    public void setOpenPeriod(String openPeriod) {
        this.openPeriod = openPeriod;
    }

    public BigDecimal getReagentPrice() {
        return reagentPrice;
    }

    public void setReagentPrice(BigDecimal reagentPrice) {
        this.reagentPrice = reagentPrice;
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
        sb.append(", stockNo=").append(stockNo);
        sb.append(", reagentName=").append(reagentName);
        sb.append(", reagentId=").append(reagentId);
        sb.append(", reagentNo=").append(reagentNo);
        sb.append(", expireDate=").append(expireDate);
        sb.append(", quantity=").append(quantity);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", overdue=").append(overdue);
        sb.append(", enterTime=").append(enterTime);
        sb.append(", enterNo=").append(enterNo);
        sb.append(", enterMan=").append(enterMan);
        sb.append(", outTime=").append(outTime);
        sb.append(", outNo=").append(outNo);
        sb.append(", outMan=").append(outMan);
        sb.append(", applyMan=").append(applyMan);
        sb.append(", openPeriod=").append(openPeriod);
        sb.append(", reagentPrice=").append(reagentPrice);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deleteBy=").append(deleteBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}