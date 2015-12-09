package com.mikeabney.pgc.pricing;

public class Item {
    private String description;
    private Money price;

    public Item(String description, Money price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Item) {
            Item other = (Item)obj;
            if (this.description.equals(other.description) && this.price.equals(other.price)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return description.hashCode() * 17 + price.hashCode() * 11;
    }
}