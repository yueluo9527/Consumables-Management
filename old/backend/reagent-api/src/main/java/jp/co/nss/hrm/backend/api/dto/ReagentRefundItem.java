package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ReagentRefundItem {

    private String refundCode;

    private String refundDetailId;

    private String reagentCode;

    private String qrCode;

    private String codeValue;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Date deleteTime;

    private String deleteBy;

    private String status;

    @ApiModelProperty(value = "软删除标志: 0, 未删除, 1: 已删除")
    private Byte deleteFlag;

}
