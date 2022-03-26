package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReagentCollectPDAReq {

    // 预入库单号
    private String preInBillCode;

    // 如果操作的是草稿，则必传，用于更新状态
    private String tempInBillCode;

    // 入库单种类
    // 1 一级中心入库单； 2 二级中心入库单；3 科室入库单
    private String billType;

    // 库存种类
    // 1 一级中心库汇总单， 2 二级库科室汇总单，3二级库中心库库存
    private String stockType;

    // 添加种类：1 一级建码入库，2 二级建码入库 3 一级扫码入库，4 二级扫码入库
    private String createType;

    // 单据类型
    // 0-草稿；1-入库
    private String billStatus;

    private String billCreator;

    private String remark;

    //判断是从web草稿进来的，qrIndexFlag=true
    private Boolean qrIndexFlag;

    private List<ReagentCollectMess> collectMessList = new ArrayList<>();

    //申请人
    private String applyMan;

    //申请科室
    private String applyBranch;

    // 科室id
    private String branchCode;
}
