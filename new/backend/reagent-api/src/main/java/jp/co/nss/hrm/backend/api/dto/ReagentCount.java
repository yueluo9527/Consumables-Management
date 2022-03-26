package jp.co.nss.hrm.backend.api.dto;

public class ReagentCount {

    private String orderCount;

    private String stockCount;

    private String moneyCount;

    private String placeOrder;

    private String completed;

    private String pending;

    private String lowStockCount;

    private String overdueCount;

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) {
        this.placeOrder = placeOrder;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(String orderCount) {
        this.orderCount = orderCount;
    }

    public String getStockCount() {
        return stockCount;
    }

    public void setStockCount(String stockCount) {
        this.stockCount = stockCount;
    }

    public String getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(String moneyCount) {
        this.moneyCount = moneyCount;
    }

    public String getLowStockCount() {
        return lowStockCount;
    }

    public void setLowStockCount(String lowStockCount) {
        this.lowStockCount = lowStockCount;
    }


    public String getOverdueCount() {
        return overdueCount;
    }

    public void setOverdueCount(String overdueCount) {
        this.overdueCount = overdueCount;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stockCount=").append(stockCount);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", lowStockCount=").append(lowStockCount);
        sb.append(", overdueCount=").append(overdueCount);
        sb.append("]");
        return sb.toString();
    }

}
