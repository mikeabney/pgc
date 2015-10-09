package com.jprusakova.tdd.money.currency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrencyTable {

    private List<TableEntry> rateTable = new ArrayList<>();

    public void setRate(CurrencyEnum convertFrom, CurrencyEnum convertTo, double rate) {
        TableEntry entry = new TableEntry(convertFrom, convertTo, rate);
        rateTable.add(0, entry);
    }

    private Iterator<TableEntry> getRateIterator(CurrencyEnum convertFrom, CurrencyEnum convertTo) {
        Iterator<TableEntry> found = rateTable.stream().filter(r -> r.getFrom().equals(convertFrom) && r.getTo().equals(convertTo)).iterator();
        if (!found.hasNext()) {
            throw new NoRateAvailableException();
        }
        return found;
    }

    public double getRate(CurrencyEnum currencyFrom, CurrencyEnum currencyTo, long timestamp) {
        Iterator<TableEntry> rateIterator = getRateIterator(currencyFrom, currencyTo);

        while (rateIterator.hasNext()) {
            TableEntry current = rateIterator.next();
            if (current.getTimestamp() <= timestamp) {
                return current.getRate();
            }
        }
        throw new NoRateAvailableException(timestamp);
    }

    private class TableEntry {
        private CurrencyEnum convertFrom;
        private CurrencyEnum convertTo;
        double rate;
        long timestamp;

        public TableEntry(CurrencyEnum convertFrom, CurrencyEnum convertTo, double rate) {
            this.convertFrom = convertFrom;
            this.convertTo = convertTo;
            this.rate = rate;
            this.timestamp = System.currentTimeMillis();
        }

        public CurrencyEnum getFrom() {
            return convertFrom;
        }

        public CurrencyEnum getTo() {
            return convertTo;
        }

        public double getRate() {
            return rate;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}
