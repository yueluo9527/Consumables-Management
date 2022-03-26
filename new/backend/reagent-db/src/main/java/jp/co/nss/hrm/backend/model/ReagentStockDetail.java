package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ReagentStockDetail implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "库存编号")
    private String stockNo;

    @ApiModelProperty(value = "库存种类：1 中心库汇总单， 2 二级库汇总单")
    private String stockType;

    @ApiModelProperty(value = "试剂耗材ID")
    private String reagentId;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "规格型号")
    private String specification;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturerName;

    @ApiModelProperty(value = "注册证号")
    private String registrationNo;

    @ApiModelProperty(value = "供货商名")
    private String supplierShortName;

    @ApiModelProperty(value = "科室库名")
    private String branch;

    @ApiModelProperty(value = "单位")
    private String reagentUnit;

    @ApiModelProperty(value = "状态: 0：丢失，1：破损，2：过期，3：用尽，4.其他 5: 已退货, 1997: 中心已出库,1998: 在库，1999：科室已出库")
    private String reagentStatus;

    @ApiModelProperty(value = "储存温度: 常温，冷藏，冷冻")
    private String reagentTemp;

    @ApiModelProperty(value = "试剂编号")
    private String reagentCode;

    @ApiModelProperty(value = "二维码")
    private String qrCode;

    @ApiModelProperty(value = "二维码数据")
    private String codeValue;

    @ApiModelProperty(value = "产品批号")
    private String batchNo;

    @ApiModelProperty(value = "库存有效期")
    private Date expireDate;

    @ApiModelProperty(value = "开启有效期")
    private Integer openPeriod;

    @ApiModelProperty(value = "单价")
    private Double reagentPrice;

    @ApiModelProperty(value = "过期预警")
    private Integer overdue;

    @ApiModelProperty(value = "过期剩余天数")
    private Integer remainDay;

    @ApiModelProperty(value = "移库单号")
    private String collectNo;

    @ApiModelProperty(value = "入库时间")
    private Date enterTime;

    @ApiModelProperty(value = "入库单号")
    private String enterNo;

    @ApiModelProperty(value = "入库人")
    private String enterMan;

    @ApiModelProperty(value = "出库时间")
    private Date outTime;

    @ApiModelProperty(value = "出库单号")
    private String outNo;

    @ApiModelProperty(value = "出库人")
    private String outMan;

    @ApiModelProperty(value = "申领人")
    private String applyMan;

    @ApiModelProperty(value = "使用时间")
    private Date useTime;

    @ApiModelProperty(value = "设备id")
    private String deviceId;

    @ApiModelProperty(value = "上机人员")
    private Long deviceRegMan;

    private String updateBy;

    private Date createTime;

    private String createBy;

    private Date updateTime;

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

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReagentUnit() {
        return reagentUnit;
    }

    public void setReagentUnit(String reagentUnit) {
        this.reagentUnit = reagentUnit;
    }

    public String getReagentStatus() {
        return reagentStatus;
    }

    public void setReagentStatus(String reagentStatus) {
        this.reagentStatus = reagentStatus;
    }

    public String getReagentTemp() {
        return reagentTemp;
    }

    public void setReagentTemp(String reagentTemp) {
        this.reagentTemp = reagentTemp;
    }

    public String getReagentCode() {
        return reagentCode;
    }

    public void setReagentCode(String reagentCode) {
        this.reagentCode = reagentCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getOpenPeriod() {
        return openPeriod;
    }

    public void setOpenPeriod(Integer openPeriod) {
        this.openPeriod = openPeriod;
    }

    public Double getReagentPrice() {
        return reagentPrice;
    }

    public void setReagentPrice(Double reagentPrice) {
        this.reagentPrice = reagentPrice;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(Integer remainDay) {
        this.remainDay = remainDay;
    }

    public String getCollectNo() {
        return collectNo;
    }

    public void setCollectNo(String collectNo) {
        this.collectNo = collectNo;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public String getEnterNo() {
        return enterNo;
    }

    public void setEnterNo(String enterNo) {
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

    public String getOutNo() {
        return outNo;
    }

    public void setOutNo(String outNo) {
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

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getDeviceRegMan() {
        return deviceRegMan;
    }

    public void setDeviceRegMan(Long deviceRegMan) {
        this.deviceRegMan = deviceRegMan;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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
        sb.append(", stockNo=").append(stockNo);
        sb.append(", stockType=").append(stockType);
        sb.append(", reagentId=").append(reagentId);
        sb.append(", reagentName=").append(reagentName);
        sb.append(", specification=").append(specification);
        sb.append(", manufacturerName=").append(manufacturerName);
        sb.append(", registrationNo=").append(registrationNo);
        sb.append(", supplierShortName=").append(supplierShortName);
        sb.append(", branch=").append(branch);
        sb.append(", reagentUnit=").append(reagentUnit);
        sb.append(", reagentStatus=").append(reagentStatus);
        sb.append(", reagentTemp=").append(reagentTemp);
        sb.append(", reagentCode=").append(reagentCode);
        sb.append(", qrCode=").append(qrCode);
        sb.append(", codeValue=").append(codeValue);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", expireDate=").append(expireDate);
        sb.append(", openPeriod=").append(openPeriod);
        sb.append(", reagentPrice=").append(reagentPrice);
        sb.append(", overdue=").append(overdue);
        sb.append(", remainDay=").append(remainDay);
        sb.append(", collectNo=").append(collectNo);
        sb.append(", enterTime=").append(enterTime);
        sb.append(", enterNo=").append(enterNo);
        sb.append(", enterMan=").append(enterMan);
        sb.append(", outTime=").append(outTime);
        sb.append(", outNo=").append(outNo);
        sb.append(", outMan=").append(outMan);
        sb.append(", applyMan=").append(applyMan);
        sb.append(", useTime=").append(useTime);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", deviceRegMan=").append(deviceRegMan);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deleteBy=").append(deleteBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}