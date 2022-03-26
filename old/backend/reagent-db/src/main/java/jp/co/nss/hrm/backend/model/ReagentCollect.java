package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ReagentCollect implements Serializable {
    private Long id;

    @ApiModelProperty(value = "申请编号")
    private String collectNo;

    @ApiModelProperty(value = "申请单种类：1 二级领用申请单， 2 移库申请单，3一级领用申请单")
    private String applyType;

    @ApiModelProperty(value = "申请日")
    private Date collectDay;

    @ApiModelProperty(value = "申请状态 0 ：草稿，1：已提交，2：中心已出库，3：科室已入库")
    private String collectStatus;

    @ApiModelProperty(value = "移库科室名")
    private String branch;

    @ApiModelProperty(value = "描述")
    private String collectDescribe;

    @ApiModelProperty(value = "申请人")
    private String createName;

    private Date createTime;

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

    public String getCollectNo() {
        return collectNo;
    }

    public void setCollectNo(String collectNo) {
        this.collectNo = collectNo;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public Date getCollectDay() {
        return collectDay;
    }

    public void setCollectDay(Date collectDay) {
        this.collectDay = collectDay;
    }

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCollectDescribe() {
        return collectDescribe;
    }

    public void setCollectDescribe(String collectDescribe) {
        this.collectDescribe = collectDescribe;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        sb.append(", collectNo=").append(collectNo);
        sb.append(", applyType=").append(applyType);
        sb.append(", collectDay=").append(collectDay);
        sb.append(", collectStatus=").append(collectStatus);
        sb.append(", branch=").append(branch);
        sb.append(", collectDescribe=").append(collectDescribe);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
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