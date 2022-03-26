package jp.co.nss.hrm.backend.api.enums;

public enum BillType {
    in_pre("1"),
    in_act("2"),

    out_branch("3"),
    out_user("4"),
    ;

    private String id;

    // コンストラクタの定義
    private BillType(String id) {
        this.id = id;
    }

    public String getValue() {
        return id;
    }
}
