package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ReagentOutBillReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "出库单编号")
    private String code;

    @ApiModelProperty(value = "出库单种类：1.科室库-单级领用出库单， 2.科室库-二级领用出库单")
    private String billType;

    @ApiModelProperty(value = "单据日期（业务发生的日期，不一定等于单据创建时间，根据单据不同，在此单为做成日期）")
    private String  billDate;

    @ApiModelProperty(value = "单据状态：0-草稿，1-已完结 ")
    private Boolean billStatus;

    @ApiModelProperty(value = "制单人")
    private String billCreator;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "申请科室ID")
    private Long branchId;

    @ApiModelProperty(value = "申请科室名")
    private String branchName;

    @ApiModelProperty(value = "出库预定日")
    private String stockDay;

    @ApiModelProperty(value = "申请日")
    private String applicationDate;

    @ApiModelProperty(value = "申请人")
    private String applicationUser;

    private Long consumerId;

    private String createBy;

    private String updateBy;

    private List<ReagentDetailReq> details;

}
