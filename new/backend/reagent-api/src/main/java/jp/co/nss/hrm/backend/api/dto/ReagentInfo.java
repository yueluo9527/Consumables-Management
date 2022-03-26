package jp.co.nss.hrm.backend.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 试剂情报
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class ReagentInfo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "科室ID ")
    private Long branchId;

    @ApiModelProperty(value = "试剂耗材ID")
    private Long reagentId;

    @ApiModelProperty(value = "试剂名称 ")
    private String reagentName;

    @ApiModelProperty(value = "系统批号")
    private String batchNo;

    @ApiModelProperty(value = "到期日期")
    private Date expireDate;

    @ApiModelProperty(value = "库存数量")
    private BigDecimal quantity;

    //下单时展示的在库数量
    @ApiModelProperty(value = "在库数量")
    private int stockNumber;

    @ApiModelProperty(value = "id")
    private Long itemId;

    @ApiModelProperty(value = "库存ID")
    private Long stockId;

    @ApiModelProperty(value = "二维码")
    private String qrCode;

    @ApiModelProperty(value = "状态 1:在库，2:出库，9:损失")
    private String status;

    @ApiModelProperty(value = "试剂耗材编号")
    private String code;

    @ApiModelProperty(value = "试剂名称")
    private String name;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "规格型号")
    private String specification;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturerName;

    @ApiModelProperty(value = "注册证号")
    private String registrationNo;

    @ApiModelProperty(value = "供货商ID")
    private Long supplierId;

    @ApiModelProperty(value = "供货商名")
    private String supplierShortName;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "储存温度: 常温，冷藏，冷冻")
    private String stockType;

    @ApiModelProperty(value = "过期预警时间阈值")
    private Integer expirationLimit;

    @ApiModelProperty(value = "低库存预警阈值")
    private Integer stockLimit;

    @ApiModelProperty(value = "开启有效期限")
    private Integer useDayLimit;

    @ApiModelProperty(value = "入库单号")
    private String billCode;

    @ApiModelProperty(value = "已发货数量")
    private BigDecimal sendNum;

    @ApiModelProperty(value = "未发货数量")
    private BigDecimal unsendNum;
}
