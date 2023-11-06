package dev.katanoesis.paymenttest;

public enum PayMethod {

    CARD("card"),
    ACCOUNT("account");

    private String method;

    PayMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

}
