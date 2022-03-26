package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReagentPreInBillPost {
    private String billType;

    private String billStatus;

    private List<ReagentPreInBillMess> preInBillMessList;

    private String remark;

    private String billCreator;

    private String orderNo;

}
