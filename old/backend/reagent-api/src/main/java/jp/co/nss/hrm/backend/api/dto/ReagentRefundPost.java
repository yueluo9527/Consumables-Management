package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReagentRefundPost {

    private Integer id;

    private String stockType;

    private String stockCInType;

    private String refundType;

    private String billType;

    private String inType;

    private String refundStatus;

    private List<ReagentRefundMess> refundMessList;

    private String remark;

    private String createBy;

}
