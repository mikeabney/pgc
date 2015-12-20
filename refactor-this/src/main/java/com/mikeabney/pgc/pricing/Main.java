package com.mikeabney.pgc.pricing;

import java.math.BigDecimal;

public class Main {
    public static void main(String... args) {
        Item item1 = new Item("item 1", Money.amount(BigDecimal.valueOf(10.00)));
        Item item2 = new Item("item 2", Money.amount(BigDecimal.valueOf(20.00)));

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(item1, 10); // $100
        cart.addItem(item2, 5); // $100

        Money total = cart.calculateTotal();
        System.out.format("%s%s%n", total.currencySymbol(), total.formatAmount());

        // cart.addBuyOneGetOne(item1); // Item 1 total now $50
        total = cart.calculateTotal();
        System.out.format("%s%s%n", total.currencySymbol(), total.formatAmount());

        // cart.addPercentageDiscount(item2, BigDecimal.TEN); // Item 2 total now $90
        total = cart.calculateTotal();
        System.out.format("%s%s%n", total.currencySymbol(), total.formatAmount());
    }
}
