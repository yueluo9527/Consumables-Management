
package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReagentStatus {

    private String reagentStatus;

    private int statusCount;

    private double sumPrice;

}
