package com.mikeabney.pgc.pricing;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShoppingCart_calculateTotal {

    private ShoppingCart shoppingCart = new ShoppingCart();
    private Money itemPrice = Money.amount(BigDecimal.valueOf(12.4));
    private Item item = new Item("item", itemPrice);

    private int itemCount = 2;

    @Test
    public void calculateTotalOnEmptyCart() {
        assertCartTotalForTaxRate(Money.ZERO, 0.0);
    }

    @Test
    public void calculateTotalOnCartWithOneItem() {
        shoppingCart.addItem(item);
        assertCartTotalForTaxRate(itemPrice, 0.0);
    }

    @Test
    public void calculateTotalOnCartWithTwoItems() {
        shoppingCart.addItem(item, itemCount);
        assertCartTotalForTaxRate(itemPrice.multiply(BigDecimal.valueOf(2l)), 0.0);
    }

    @Test
    public void calculateTotalWithNoTax() {
        shoppingCart.addItem(item, itemCount);
        assertEquals(itemPrice.multiply(BigDecimal.valueOf(itemCount)), shoppingCart.calculateTotal());
        assertEquals(shoppingCart.calculateSubtotal(), shoppingCart.calculateTotal());
    }

    @Test
    public void calculateTaxableTotal() {
        shoppingCart.addItem(item, itemCount);
        assertCartTotalForTaxRate(itemPrice.multiply(BigDecimal.valueOf(itemCount)), 0.2);
    }

    @Test
    public void calculateTotalOnCartWithTax() {
        double cartTaxRate = 0.4;
        shoppingCart = new ShoppingCart(cartTaxRate);
        shoppingCart.addItem(item, itemCount);

        assertEquals(itemPrice.multiply(BigDecimal.valueOf(itemCount * (1.0 + cartTaxRate))), shoppingCart.calculateTotal());
    }

    private void assertCartTotalForTaxRate(Money expectedSubtotal, double taxRate) {
        assertEquals(expectedSubtotal, shoppingCart.calculateSubtotal());
        assertEquals(expectedSubtotal.multiply(BigDecimal.valueOf(1.0 + taxRate)), shoppingCart.calculateTotal(taxRate));
    }
}
