package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReagentItemsReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "使用者")
    private String userId;

    @ApiModelProperty(value = "备注")
    private String remark;

    private List<Long> qrId;

}
