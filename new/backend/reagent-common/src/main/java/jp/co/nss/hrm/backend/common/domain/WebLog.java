package jp.co.nss.hrm.backend.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Controller层的日志封装类
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WebLog {
    /**
     * 操作描述
     */
    private String description;

    /**
     * 消耗时间
     */
    private Integer spendTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private Object parameter;

    /**
     * 返回结果
     */
    private Object result;

    /**
     * 操作内容
     */
    private String operaLog;

    /**
     * 操作用户ID
     */
    private String userId;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 操作功能
     */
    private String module;

    /**
     * 操作类型
     */
    private String model;

    /**
     * 操作功能
     */
    private String type;
}
