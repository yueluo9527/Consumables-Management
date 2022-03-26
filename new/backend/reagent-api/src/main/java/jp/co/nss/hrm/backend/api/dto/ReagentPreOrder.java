package jp.co.nss.hrm.backend.api.dto;

import jp.co.nss.hrm.backend.model.ReagentBaseInfo;
import lombok.Data;

@Data
public class ReagentPreOrder {

    private ReagentBaseInfo info;

    private Integer infoNumber;

}
