package com.jprusakova.tdd.money.currency;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CurrencyConversionTest {
    private CurrencyConverter converter = new CurrencyConverter();

    @Test
    public void convertShouldUseRate() {
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, 2.0);
        long convertedAmount = converter.convert(CurrencyEnum.USD, 100, CurrencyEnum.CAN);
        Assert.assertEquals(200, convertedAmount);
    }

    @Test
    public void convertShouldUseLatestRate() {
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, 2.0);
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, 3.0);
        long convertedAmount = converter.convert(CurrencyEnum.USD, 100, CurrencyEnum.CAN);
        Assert.assertEquals(300, convertedAmount);
    }

    @Test
    public void convertShouldUseActiveRateAtTheTimestamp() throws InterruptedException {
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, 2.0);
        long millis = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(2);
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, 3.0);
        Assert.assertEquals(200, converter.convert(CurrencyEnum.USD, 100, CurrencyEnum.CAN, millis));
    }

    @Test(expected = NoRateAvailableException.class)
    public void convertShouldThrowForTimestampBeforeRateIsSet() {
        long millis = System.currentTimeMillis();
        converter.setRate(CurrencyEnum.USD, CurrencyEnum.CAN, 2.0);
        converter.convert(CurrencyEnum.USD, 100, CurrencyEnum.CAN, millis - 1);
    }

}
