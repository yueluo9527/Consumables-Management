package jp.co.nss.hrm.backend.api.enums;

public enum BillStatus {
    draft(false),
    real(true);
    private boolean id;

    // コンストラクタの定義
    private BillStatus(boolean id) {
        this.id = id;
    }

    public boolean getValue() {
        return id;
    }
}
