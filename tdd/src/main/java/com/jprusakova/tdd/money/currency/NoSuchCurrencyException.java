package com.jprusakova.tdd.money.currency;

public class NoSuchCurrencyException extends RuntimeException {
    private CurrencyEnum currency;
    public NoSuchCurrencyException(CurrencyEnum cur) {
    }
}
