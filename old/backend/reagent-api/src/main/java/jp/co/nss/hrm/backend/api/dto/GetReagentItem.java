package jp.co.nss.hrm.backend.api.dto;

import lombok.Data;

@Data
public class GetReagentItem {
    // 0-查询失败，有msg
    // 1-已找到，有data
    private int code;

    private String msg;

    private ReagentItem data;
}
