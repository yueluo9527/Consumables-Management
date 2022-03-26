package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReagentOutDetailItem implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "出库单编号")
    private String billCode;

    @ApiModelProperty(value = "出库单详细ID")
    private String outDetailId;

    @ApiModelProperty(value = "试剂编号")
    private String reagentCode;

    @ApiModelProperty(value = "试剂ID")
    private String reagentId;

    @ApiModelProperty(value = "二维码")
    private String qrCode;

    @ApiModelProperty(value = "二维码数据")
    private String codeValue;

    @ApiModelProperty(value = "状态")
    private String status;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    @ApiModelProperty(value = "软删除标志: 0, 未删除, 1: 已删除")
    private Byte deleteFlag;

    private Date deleteTime;

    private String deleteBy;

    private static final long serialVersionUID = 1L;
}
