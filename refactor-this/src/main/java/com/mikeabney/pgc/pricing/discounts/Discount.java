package com.mikeabney.pgc.pricing.discounts;

import com.mikeabney.pgc.pricing.Item;
import com.mikeabney.pgc.pricing.Money;

/**
 * Created by Bud on 12/20/2015.
 */
public interface Discount {
    Item getCoveredItem();

    Money getDiscount(int quantity);
}
