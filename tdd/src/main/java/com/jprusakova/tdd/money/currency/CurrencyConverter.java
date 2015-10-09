package com.jprusakova.tdd.money.currency;

public class CurrencyConverter {
    private CurrencyTable rateTable = new CurrencyTable();

    public double getRate(CurrencyEnum convertFrom, CurrencyEnum convertTo) {
        return rateTable.getRate(convertFrom, convertTo, System.currentTimeMillis());
    }

    public double getRate(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, long timestamp) {
        return rateTable.getRate(currencyFrom, currencyTo, timestamp);
    }

    public void setRate(CurrencyEnum convertFrom, CurrencyEnum convertTo, double rate) {
        if (null == convertFrom || null == convertTo) {
            throw new NoSuchCurrencyException(CurrencyEnum.INVALID);
        }
        if (CurrencyEnum.INVALID.equals(convertFrom) || CurrencyEnum.INVALID.equals(convertTo)) {
            throw new NoSuchCurrencyException(CurrencyEnum.INVALID);
        }

        rateTable.setRate(convertFrom, convertTo, rate);
    }

    public long convert(CurrencyEnum currencyFrom, long amount, CurrencyEnum currencyTo) {
        double rate = getRate(currencyFrom, currencyTo);
        return Math.round((double)amount * rate);
    }

    public long convert(CurrencyEnum currencyFrom, int amount, CurrencyEnum currencyTo, long timestamp) {
        double rate = getRate(currencyFrom, currencyTo, timestamp);
        return Math.round((double)amount * rate);
    }

}
