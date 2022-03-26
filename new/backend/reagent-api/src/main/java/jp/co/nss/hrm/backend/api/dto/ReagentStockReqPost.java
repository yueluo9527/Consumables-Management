package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

@Data
public class ReagentStockReqPost {
    private List<String> qrList;

    private String reagentStatus;

    private String createBy;

    private String remark;

    //低库存预警时查询到的所有试剂名称，在countService中被使用
    @ApiModelProperty(value = "试剂名称")
    private String reagentName;

    //低库存预警时查询到的所有试剂名称对应的库存数量，在countService中被使用
    @ApiModelProperty(value = "试剂库存数量")
    private String reagentNumber;

}
