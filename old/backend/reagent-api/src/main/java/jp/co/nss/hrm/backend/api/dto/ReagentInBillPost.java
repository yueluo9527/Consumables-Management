package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReagentInBillPost {

    private String billStatus;

    private String billType;

    private String stockType;

    private String createType;

    private List<ReagentInBillMess> inBillMessList;

    private String remark;

    private String billCreator;

    private String billCode;

}
