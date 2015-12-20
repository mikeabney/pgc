package com.mikeabney.pgc.pricing;

import com.mikeabney.pgc.pricing.discounts.BogoDiscount;
import com.mikeabney.pgc.pricing.discounts.Discount;
import com.mikeabney.pgc.pricing.discounts.PercentageDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    // TODO: A single, constant tax rate is a terrible idea.
    private static final double TAX_RATE = 0.0;

    private Map<Item, Integer> items;
    private Set<Discount> discounts;

    public ShoppingCart() {
        items = new HashMap<>();
        discounts = new HashSet<>();
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int quantity) {
        int existingQuantity = items.containsKey(item) ? items.get(item) : 0;
        items.put(item, quantity + existingQuantity);
    }

    public void addDiscount(Discount discount){
        discounts.add(discount);
    }

    public Money calculateTotal() {
        Money subtotal = Money.ZERO;
        for (Item item : items.keySet()) {
            subtotal = subtotal.add(item.getPrice().multiply(new BigDecimal(items.get(item))));
        }
        Money savings = Money.ZERO;
        for (Item item : items.keySet()) {
            for (Discount discount: this.discounts){
                if (discount.getCoveredItem() == item){
                    savings = savings.add(discount.getDiscount(items.get(item)));
                }
            }
        }

        subtotal = subtotal.subtract(savings);
        return subtotal.add(subtotal.multiply(BigDecimal.valueOf(TAX_RATE)));
    }
}
