package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ReagentCopQualification implements Serializable {
    private Long id;

    @ApiModelProperty(value = "供货商ID")
    private String supplierId;

    @ApiModelProperty(value = "供货商正式名")
    private String supplierShortName;

    @ApiModelProperty(value = "公司营业执照")
    private String businessLicense;

    @ApiModelProperty(value = "二三类医疗器械备案、经营许可证")
    private String medicalEquipmentBusinessLicense;

    @ApiModelProperty(value = "法人委托书")
    private String legalPersonPowerOfAttorney;

    @ApiModelProperty(value = "被委托人身份证复印件")
    private String clientIdCard;

    @ApiModelProperty(value = "质量保证协议书")
    private String qualityAssuranceGreement;

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

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getMedicalEquipmentBusinessLicense() {
        return medicalEquipmentBusinessLicense;
    }

    public void setMedicalEquipmentBusinessLicense(String medicalEquipmentBusinessLicense) {
        this.medicalEquipmentBusinessLicense = medicalEquipmentBusinessLicense;
    }

    public String getLegalPersonPowerOfAttorney() {
        return legalPersonPowerOfAttorney;
    }

    public void setLegalPersonPowerOfAttorney(String legalPersonPowerOfAttorney) {
        this.legalPersonPowerOfAttorney = legalPersonPowerOfAttorney;
    }

    public String getClientIdCard() {
        return clientIdCard;
    }

    public void setClientIdCard(String clientIdCard) {
        this.clientIdCard = clientIdCard;
    }

    public String getQualityAssuranceGreement() {
        return qualityAssuranceGreement;
    }

    public void setQualityAssuranceGreement(String qualityAssuranceGreement) {
        this.qualityAssuranceGreement = qualityAssuranceGreement;
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
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", medicalEquipmentBusinessLicense=").append(medicalEquipmentBusinessLicense);
        sb.append(", legalPersonPowerOfAttorney=").append(legalPersonPowerOfAttorney);
        sb.append(", clientIdCard=").append(clientIdCard);
        sb.append(", qualityAssuranceGreement=").append(qualityAssuranceGreement);
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