package dev.katanoesis.paymenttest;

import lombok.Getter;

@Getter
public enum PayMethod {

    CARD("card"),
    ACCOUNT("account");

    private final String method;

    PayMethod(String method) {
        this.method = method;
    }

}
