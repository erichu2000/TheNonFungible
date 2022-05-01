package com.example.thenonfungible.Model;

import android.media.Image;

public class Good {
    public String goodId;
    public String name;
    public String description;
    public String itemImageID;
    public String price;
    public String itemType; // {clothing, pants, shoes}
    public boolean isOnSale;
    public String ownerId; // same as "userId" in User class

    public Good() {

    }

    public Good(String goodId, String name, String description, String itemImageID, String price, String itemType, boolean isOnSale, String ownerId) {
        this.goodId = goodId;
        this.name = name;
        this.description = description;
        this.itemImageID = itemImageID;
        this.price = price;
        this.itemType = itemType;
        this.isOnSale = isOnSale;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getItemImageID() {
        return itemImageID;
    }

    public String getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
