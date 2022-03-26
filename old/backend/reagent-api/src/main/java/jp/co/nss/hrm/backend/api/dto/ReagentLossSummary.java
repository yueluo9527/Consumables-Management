
package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

@Data
public class ReagentLossSummary {

    private String reagentId;

    private String reagentName;

    private String reagentStatus;

    private int statusCount;


}
