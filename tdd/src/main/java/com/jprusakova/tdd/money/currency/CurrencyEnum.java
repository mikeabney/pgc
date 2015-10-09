package com.jprusakova.tdd.money.currency;

public enum CurrencyEnum {
    INVALID("invalid"),
    USD("USD"),
    CAN("CAN");

    private String name;


    CurrencyEnum(String name) {
        this.name = name;
    }
}
