package com.mikeabney.pgc.pricing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

public final class Money {
    public static final Money ZERO = amount(BigDecimal.ZERO);
    private BigDecimal amount;
    private Currency currency;

    /**
     * Create an amount of money in the default currency, USD.
     * TODO: Default currencies are not recommended.
     * TODO: Keep more than 2 digits after the decimal around. Tricky to make sure totals look right, though.
     */
    public static Money amount(BigDecimal amount) {
        return new Money(amount.setScale(2, RoundingMode.HALF_EVEN), Currency.getInstance(Locale.US));
    }

    private Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money other) {
        return Money.amount(this.amount.add(other.amount));
    }

    public Money subtract(Money other) {
        return Money.amount(this.amount.subtract(other.amount));
    }

    public Money multiply(BigDecimal multiplier) {
        return Money.amount(this.amount.multiply(multiplier));
    }

    public Money divide(BigDecimal divisor) {
        return Money.amount(this.amount.divide(divisor, BigDecimal.ROUND_HALF_EVEN));
    }

    public String formatAmount() {
        return String.format("%.2f", amount);
    }

    public String currencySymbol() {
        return currency.getSymbol();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Money) {
            Money other = (Money) obj;
            if (other.currency.equals(this.currency)) {
                if (other.amount.equals(this.amount)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 37 * amount.hashCode() + 13 * currency.hashCode();
    }
}
