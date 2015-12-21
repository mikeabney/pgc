package com.mikeabney.pgc.pricing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {

    private final double defaultTaxRate;

    private Map<Item, Integer> items = new HashMap<>();
    private Set<Item> bogos = new HashSet<>();
    private Map<Item, BigDecimal> percentageDiscounts = new HashMap<>();

    public ShoppingCart(double taxRate) {
        defaultTaxRate = taxRate;
    }

    public ShoppingCart() {
        this(0.0);
    }

    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int quantity) {
        int existingQuantity = items.containsKey(item) ? items.get(item) : 0;
        items.put(item, quantity + existingQuantity);
    }

    public int calculateItemCount() {
        int count = bogos.size();
        for (Item uniqItem : items.keySet()) {
            count += items.get(uniqItem);
        }

        return count;
    }

    public Money calculateTotal() {
        return calculateTotal(defaultTaxRate);
    }

    public Money calculateTotal(double taxRate) {
        Money subtotal = calculateSubtotal();
        return subtotal.add(subtotal.multiply(BigDecimal.valueOf(taxRate)));
    }

    public Money calculateSubtotal() {
        Money subtotal = calculateTotalPrice();

        Money bogoSavings = calculateBOGOsaving();
        subtotal = subtotal.subtract(bogoSavings);

        Money percentageDiscount = calculatePercentageDiscount();
        subtotal = subtotal.subtract(percentageDiscount);

        return subtotal;
    }

    private Money calculatePercentageDiscount() {
        Money savings = Money.ZERO;
        for (Item item : items.keySet()) {
            if (percentageDiscounts.containsKey(item)) {
                Money perItemSavings = item.getPrice().multiply(percentageDiscounts.get(item));
                savings = savings.add(perItemSavings.multiply(BigDecimal.valueOf(items.get(item))));
            }
        }
        return savings;
    }

    private Money calculateBOGOsaving() {
        Money savings = Money.ZERO;
        for (Item item : items.keySet()) {
            if (bogos.contains(item)) {
                int quantity = items.get(item);
                quantity = quantity % 2 == 0 ? quantity : quantity - 1;
                savings = savings.add(item.getPrice().multiply(new BigDecimal(quantity/2)));
            }
        }
        return savings;
    }

    private Money calculateTotalPrice() {
        Money subtotal = Money.ZERO;
        for (Item item : items.keySet()) {
            subtotal = subtotal.add(item.getPrice().multiply(new BigDecimal(items.get(item))));
        }
        return subtotal;
    }

    public void addBuyOneGetOne(Item item) {
        addItem(item);

        Item oneFree = new Item(item.getDescription(), item.getPrice());
        bogos.add(oneFree);
    }

    public void addPercentageDiscount(Item item, BigDecimal percentage) {
        percentageDiscounts.put(item, percentage.multiply(BigDecimal.valueOf(0.01))); // Convert %-age to multiplier.
    }
}
