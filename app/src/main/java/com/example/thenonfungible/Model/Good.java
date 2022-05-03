package com.example.thenonfungible.Model;

public class Good {

    public String goodId;
    public String name;
    public String description;
    public String itemImageID;
    public String price;
    public String itemType; // {clothing, pants, shoes}
    public boolean onSale;
    public String ownerId; // same as "userId" in User class
    public String onSale_name;

    public Good() {

    }

    public Good(String goodId, String name, String description, String itemImageID, String price, String itemType, boolean onSale, String ownerId, String onSale_name) {
        this.goodId = goodId;
        this.name = name;
        this.description = description;
        this.itemImageID = itemImageID;
        this.price = price;
        this.itemType = itemType;
        this.onSale = onSale;
        this.ownerId = ownerId;
        this.onSale_name = onSale_name;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemImageID() {
        return itemImageID;
    }

    public void setItemImageID(String itemImageID) {
        this.itemImageID = itemImageID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOnSale_name() {
        return onSale_name;
    }

    public void setOnSale_name(String onSale_name) {
        this.onSale_name = onSale_name;
    }
}
