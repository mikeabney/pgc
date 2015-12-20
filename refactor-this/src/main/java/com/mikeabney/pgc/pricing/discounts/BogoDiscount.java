package com.mikeabney.pgc.pricing.discounts;

import com.mikeabney.pgc.pricing.Item;
import com.mikeabney.pgc.pricing.Money;

import java.math.BigDecimal;

/**
 * Created by Bud on 12/20/2015.
 */
public class BogoDiscount implements Discount {
    private final Item item;

    public BogoDiscount(Item item){
        this.item = item;
    }

    @Override
    public Item getCoveredItem() {
        return this.item;
    }

    @Override
    public Money getDiscount(int quantity) {
        quantity = quantity % 2 == 0 ? quantity : quantity - 1;
        Money savings = this.item.getPrice().multiply(new BigDecimal(quantity/2));
        return savings;
    }
}
