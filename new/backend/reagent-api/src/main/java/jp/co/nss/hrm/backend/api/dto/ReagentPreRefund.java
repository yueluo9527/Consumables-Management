package jp.co.nss.hrm.backend.api.dto;

import jp.co.nss.hrm.backend.model.ReagentStock;
import lombok.Data;

@Data
public class ReagentPreRefund {

    private ReagentStock info;

    private Integer infoNumber;

}
