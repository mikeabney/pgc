package com.mikeabney.pgc.pricing;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShoppingCart_addItemTest {

    ShoppingCart shoppingCart = new ShoppingCart();
    Money itemPrice = Money.amount(BigDecimal.valueOf(12.4));
    Item item = new Item("item", itemPrice);

    @Test
    public void newCartEmpty() {
        assertEquals(Money.ZERO, shoppingCart.calculateTotal());
        assertEquals(0, shoppingCart.calculateItemCount());
    }

    @Test
    public void addSingleItemAtPrice() {
        shoppingCart.addItem(item);

        assertEquals(itemPrice, shoppingCart.calculateTotal());
        assertEquals(1, shoppingCart.calculateItemCount());
    }

    @Test
    public void addBoGoItem() {
        shoppingCart.addBuyOneGetOne(item);

        assertEquals(itemPrice, shoppingCart.calculateTotal());
        assertEquals(2, shoppingCart.calculateItemCount());
    }
}
