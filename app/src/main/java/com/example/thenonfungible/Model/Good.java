package com.example.thenonfungible.Model;

import android.media.Image;

public class Good {
    public String name;
    public String description;
    public String itemImageID;
    public double price;
    public String itemType; // {clothing, pants, shoes}
    public boolean isOnSale;
    public String ownerId; // same as "userId" in User class

    public Good() {

    }

    public Good(String name, String description, String itemImageID, double price, String itemType, boolean isOnSale, String ownerId) {
        this.name = name;
        this.description = description;
        this.itemImageID = itemImageID;
        this.price = price;
        this.itemType = itemType;
        this.isOnSale = isOnSale;
        this.ownerId = ownerId;
    }
}
