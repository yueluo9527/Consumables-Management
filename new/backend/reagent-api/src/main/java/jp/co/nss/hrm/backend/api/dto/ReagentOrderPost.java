package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class ReagentOrderPost {
    private String orderState;

    private List<ReagentOrderMess> orderMessList;

    private String orderDescribe;

    private String createBy;

}
