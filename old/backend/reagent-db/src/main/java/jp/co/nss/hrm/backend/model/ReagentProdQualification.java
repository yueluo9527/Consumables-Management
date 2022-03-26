package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ReagentProdQualification implements Serializable {
    private Long id;

    @ApiModelProperty(value = "供货商ID")
    private String supplierId;

    @ApiModelProperty(value = "供货商正式名")
    private String supplierShortName;

    @ApiModelProperty(value = "试剂耗材编号")
    private String reagentId;

    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    @ApiModelProperty(value = "生产厂家营业执照")
    private String manufacturerBusinessLicense;

    @ApiModelProperty(value = "医疗器械生产许可证")
    private String deviceProdLicense;

    @ApiModelProperty(value = "医疗器械经营许可证")
    private String equipmentBusinessLicense;

    @ApiModelProperty(value = "医疗器械生产产品登记表")
    private String productRegistrationForm;

    @ApiModelProperty(value = "医疗器械生产备案凭证")
    private String productionRecordCertificate;

    @ApiModelProperty(value = "医疗器械注册证")
    private String deviceRegistrationCertificate;

    @ApiModelProperty(value = "其他")
    private String other;

    private Date createTime;

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

    public String getManufacturerBusinessLicense() {
        return manufacturerBusinessLicense;
    }

    public void setManufacturerBusinessLicense(String manufacturerBusinessLicense) {
        this.manufacturerBusinessLicense = manufacturerBusinessLicense;
    }

    public String getDeviceProdLicense() {
        return deviceProdLicense;
    }

    public void setDeviceProdLicense(String deviceProdLicense) {
        this.deviceProdLicense = deviceProdLicense;
    }

    public String getEquipmentBusinessLicense() {
        return equipmentBusinessLicense;
    }

    public void setEquipmentBusinessLicense(String equipmentBusinessLicense) {
        this.equipmentBusinessLicense = equipmentBusinessLicense;
    }

    public String getProductRegistrationForm() {
        return productRegistrationForm;
    }

    public void setProductRegistrationForm(String productRegistrationForm) {
        this.productRegistrationForm = productRegistrationForm;
    }

    public String getProductionRecordCertificate() {
        return productionRecordCertificate;
    }

    public void setProductionRecordCertificate(String productionRecordCertificate) {
        this.productionRecordCertificate = productionRecordCertificate;
    }

    public String getDeviceRegistrationCertificate() {
        return deviceRegistrationCertificate;
    }

    public void setDeviceRegistrationCertificate(String deviceRegistrationCertificate) {
        this.deviceRegistrationCertificate = deviceRegistrationCertificate;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierShortName=").append(supplierShortName);
        sb.append(", reagentId=").append(reagentId);
        sb.append(", reagentName=").append(reagentName);
        sb.append(", manufacturerBusinessLicense=").append(manufacturerBusinessLicense);
        sb.append(", deviceProdLicense=").append(deviceProdLicense);
        sb.append(", equipmentBusinessLicense=").append(equipmentBusinessLicense);
        sb.append(", productRegistrationForm=").append(productRegistrationForm);
        sb.append(", productionRecordCertificate=").append(productionRecordCertificate);
        sb.append(", deviceRegistrationCertificate=").append(deviceRegistrationCertificate);
        sb.append(", other=").append(other);
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