package com.jprusakova.tdd.money.currency;


import org.junit.Test;
import org.junit.Assert;

public class CurrencyConversionRateTest {
    private CurrencyConverter converter = new CurrencyConverter();
    private double assertDelta = 0.0001;

    @Test(expected = NoRateAvailableException.class)
    public void getRateShouldThrowWhenRateNotSet() {
        converter.getRate(CurrencyEnum.USD, CurrencyEnum.CAN);
    }

    @Test
    public void setAndThenGetShouldReturnRate() {
        double rate = 1.5;
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, rate);
        Assert.assertEquals(rate, converter.getRate(CurrencyEnum.USD, CurrencyEnum.CAN), assertDelta);
    }

    @Test(expected = NoSuchCurrencyException.class)
    public void setRateToInvalidCurrencyShouldThrow() {
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.INVALID, 2.0);
    }

    @Test(expected = NoSuchCurrencyException.class)
    public void setRateFromInvalidCurrencyShouldThrow() {
        converter.setRate(CurrencyEnum.INVALID, CurrencyEnum.USD, 2.0);
    }

    @Test
    public void setRateAgainShouldResetRate() {
        double originalRate = 1.1;
        double resetRate = 1.7;
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, originalRate);
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, resetRate);
        Assert.assertEquals(resetRate, converter.getRate(CurrencyEnum.USD, CurrencyEnum.CAN), assertDelta);
    }
}
