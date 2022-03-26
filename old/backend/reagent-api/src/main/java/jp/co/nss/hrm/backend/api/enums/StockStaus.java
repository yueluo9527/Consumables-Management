package jp.co.nss.hrm.backend.api.enums;

public enum StockStaus {
    in("01"),
    exp("02"),
    loss("03"),
    refund("04"),
    using("05"),
    used("06"),
    ;
    private String id;

    // コンストラクタの定義
    private StockStaus(String id) {
        this.id = id;
    }

    public String getValue() {
        return id;
    }
}
