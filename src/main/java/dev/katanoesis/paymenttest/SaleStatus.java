package dev.katanoesis.paymenttest;

public enum SaleStatus {

    NONE("none"),
    SALE("sale"),
    FINISHED("finished");

    private String statusCode;

    SaleStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
