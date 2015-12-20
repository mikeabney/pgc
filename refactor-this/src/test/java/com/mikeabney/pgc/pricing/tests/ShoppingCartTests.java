package com.mikeabney.pgc.pricing.tests;

import com.mikeabney.pgc.pricing.Item;
import com.mikeabney.pgc.pricing.Money;
import com.mikeabney.pgc.pricing.ShoppingCart;
import com.mikeabney.pgc.pricing.discounts.BogoDiscount;
import com.mikeabney.pgc.pricing.discounts.PercentageDiscount;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bud on 12/20/2015.
 */
public class ShoppingCartTests {
    @Test
    public void totalWithNormalItemsCalculatesCorrectly(){
        ShoppingCart target = new ShoppingCart();

        Item tickets = new Item("tickets", Money.amount(BigDecimal.valueOf(25.00)));
        target.addItem(tickets, 2);

        Money result = target.calculateTotal();
        Money expected = Money.amount(BigDecimal.valueOf(50.00));
        assertEquals(expected, result);
    }

    @Test
    public void totalWithBogoItemsCalculatesCorrectly(){
        ShoppingCart target = new ShoppingCart();

        Item hotdogs = new Item("Footlong hotdogs", Money.amount(BigDecimal.valueOf(6.00)));
        target.addItem(hotdogs, 4);
        target.addDiscount(new BogoDiscount(hotdogs));

        Money result = target.calculateTotal();
        Money expected = Money.amount(BigDecimal.valueOf(12.00));
        assertEquals(expected, result);
    }

    @Test
    public void totalWithDiscountItemsCalculatesCorrectly(){
        ShoppingCart target = new ShoppingCart();

        Item beer = new Item("Tasty beer", Money.amount(BigDecimal.valueOf(2.00)));
        target.addItem(beer, 10);
        target.addDiscount(new PercentageDiscount(beer, BigDecimal.valueOf(50)));

        Money result = target.calculateTotal();
        Money expected = Money.amount(BigDecimal.valueOf(10.00));
        assertEquals(expected, result);
    }

    @Test
    public void totalWithMixedItemsCalculatesCorrectly(){
        ShoppingCart target = new ShoppingCart();

        Item tickets = new Item("tickets", Money.amount(BigDecimal.valueOf(25.00)));
        target.addItem(tickets, 2);

        Item hotdogs = new Item("Footlong hotdogs", Money.amount(BigDecimal.valueOf(6.00)));
        target.addItem(hotdogs, 4);
        target.addDiscount(new BogoDiscount(hotdogs));

        Item beer = new Item("Tasty beer", Money.amount(BigDecimal.valueOf(2.00)));
        target.addItem(beer, 10);
        target.addDiscount(new PercentageDiscount(beer, BigDecimal.valueOf(50)));

        Money result = target.calculateTotal();
        Money expected = Money.amount(BigDecimal.valueOf(72.00));
        assertEquals(expected, result);
    }
}
