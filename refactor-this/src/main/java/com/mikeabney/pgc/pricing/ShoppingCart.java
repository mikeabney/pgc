package com.mikeabney.pgc.pricing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    // TODO: A single, constant tax rate is a terrible idea.
    private static final double TAX_RATE = 0.0;

    private Map<Item, Integer> items;
    private Set<Item> bogos;
    private Map<Item, BigDecimal> percentageDiscounts;

    public ShoppingCart() {
        items = new HashMap<>();
        bogos = new HashSet<>();
        percentageDiscounts = new HashMap<>();
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int quantity) {
        int existingQuantity = items.containsKey(item) ? items.get(item) : 0;
        items.put(item, quantity + existingQuantity);
    }

    public Money calculateTotal() {
        Money subtotal = Money.ZERO;
        for (Item item : items.keySet()) {
            subtotal = subtotal.add(item.getPrice().multiply(new BigDecimal(items.get(item))));
        }
        Money savings = Money.ZERO;
        for (Item item : items.keySet()) {
            if (bogos.contains(item)) {
                int quantity = items.get(item);
                quantity = quantity % 2 == 0 ? quantity : quantity - 1;
                savings = savings.add(item.getPrice().multiply(new BigDecimal(quantity/2)));
            }
        }
        for (Item item : items.keySet()) {
            if (percentageDiscounts.containsKey(item)) {
                Money perItemSavings = item.getPrice().multiply(percentageDiscounts.get(item));
                savings = savings.add(perItemSavings.multiply(BigDecimal.valueOf(items.get(item))));
            }
        }
        subtotal = subtotal.subtract(savings);
        return subtotal.add(subtotal.multiply(BigDecimal.valueOf(TAX_RATE)));
    }

    public void addBuyOneGetOne(Item item) {
        bogos.add(item);
    }

    public void addPercentageDiscount(Item item, BigDecimal percentage) {
        percentageDiscounts.put(item, percentage.multiply(BigDecimal.valueOf(0.01))); // Convert %-age to multiplier.
    }
}
