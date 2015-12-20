package com.mikeabney.pgc.pricing.discounts;

import com.mikeabney.pgc.pricing.Item;
import com.mikeabney.pgc.pricing.Money;

import java.math.BigDecimal;

/**
 * Created by Bud on 12/20/2015.
 */
public class PercentageDiscount implements Discount {
    private final Item item;
    private BigDecimal percent;

    public PercentageDiscount(Item item, BigDecimal percent){
        this.item = item;
        this.percent = percent.multiply(BigDecimal.valueOf(0.01)); // Convert %-age to multiplier.
    }

    @Override
    public Item getCoveredItem() {
        return this.item;
    }

    @Override
    public Money getDiscount(int quantity) {
        Money perItemSavings = this.item.getPrice().multiply(this.percent);
        Money savings = perItemSavings.multiply(BigDecimal.valueOf(quantity));
        return savings;
    }
}
