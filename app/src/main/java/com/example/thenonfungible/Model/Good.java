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

    public String getGoodId() {
        return goodId;
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

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItemImageID(String itemImageID) {
        this.itemImageID = itemImageID;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
