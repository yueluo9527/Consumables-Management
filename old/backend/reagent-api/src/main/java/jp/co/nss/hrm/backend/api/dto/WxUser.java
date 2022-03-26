package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WxUser implements Serializable {
    private Long id;

    private Long userid;

    private Long supplierId;

    private String supplierCode;

    private String openid;

    private String unionId;

    private String nickname;

    private String avatar;

    private String city;

    private String language;

    private String province;

    private String country;

    private int subscribe;

    private Date subscribeTime;

    private String remark;

    private Date createTime;

    private Date updateTime;

}
