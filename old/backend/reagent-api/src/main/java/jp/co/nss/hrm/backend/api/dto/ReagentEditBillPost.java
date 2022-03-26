package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReagentEditBillPost {

    private String status;

    private String billCode;

    private List<ReagentEditBillMess> editBillMessList;

    private List<ReagentEditBillMess> subBillMessList;

}
