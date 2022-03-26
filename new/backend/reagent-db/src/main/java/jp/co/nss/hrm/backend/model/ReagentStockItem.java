package jp.co.nss.hrm.backend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReagentStockItem implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "库存ID")
    private Long stockId;

    @ApiModelProperty(value = "二维码")
    private String qrCode;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "开瓶日")
    private Date useDate;

    @ApiModelProperty(value = "开瓶有效期")
    private Date useExpire;

    private Date createTime;

    @ApiModelProperty(value = "科室ID ")
    private Long branchId;

    @ApiModelProperty(value = "使用者ID")
    private Long consumerId;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    @ApiModelProperty(value = "软删除标志: 0, 未删除, 1: 已删除")
    private Byte deleteFlag;

    private Date deleteTime;

    private String deleteBy;

    // 出库人
    private String outMan;

    private Date outTime;

    // 终结人
    private String applyMan;

    private static final long serialVersionUID = 1L;

}