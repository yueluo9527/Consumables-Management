package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ReagentOperationLog implements Serializable {
    private Long id;

    @ApiModelProperty(value = "功能区分")
    private String module;

    @ApiModelProperty(value = "操作内容")
    private String operaLog;

    @ApiModelProperty(value = "操作用户ID")
    private Long userId;

    @ApiModelProperty(value = "操作用户名")
    private String userName;

    @ApiModelProperty(value = "操作时间")
    private Date createTime;

    @ApiModelProperty(value = "操作结果")
    private String result;

    @ApiModelProperty(value = "操作路径")
    private String url;

    @ApiModelProperty(value = "操作方法")
    private String method;

    @ApiModelProperty(value = "操作IP")
    private String ip;

    @ApiModelProperty(value = "修改对象id")
    private String operaId;

    @ApiModelProperty(value = "请求参数")
    private String operaParams;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getOperaLog() {
        return operaLog;
    }

    public void setOperaLog(String operaLog) {
        this.operaLog = operaLog;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperaId() {
        return operaId;
    }

    public void setOperaId(String operaId) {
        this.operaId = operaId;
    }

    public String getOperaParams() {
        return operaParams;
    }

    public void setOperaParams(String operaParams) {
        this.operaParams = operaParams;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", module=").append(module);
        sb.append(", operaLog=").append(operaLog);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", createTime=").append(createTime);
        sb.append(", result=").append(result);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", ip=").append(ip);
        sb.append(", operaId=").append(operaId);
        sb.append(", operaParams=").append(operaParams);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}