package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import jp.co.nss.hrm.backend.model.ReagentInDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReagentInBillReq {

    private Long id;

    @ApiModelProperty(value = "进货单", required = true)
    private String billCode;

    @ApiModelProperty(value = "进货日期", required = true)
    private String billDate;

    @ApiModelProperty(value = "供货商ID", required = true)
    private Long  supplierId;

    @ApiModelProperty(value = "供货商名", required = true)
    private String supplierName;

    @ApiModelProperty(value = "备注", required = true)
    private String remark;

    private  String billCreator;

    private List<ReagentDetailReq> details;

}
