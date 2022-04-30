package com.example.thenonfungible.Model;

import android.media.Image;

public class Good {
    private int id;
    private String name;
    private String description;
    private Image itemImage;
    private int price;
    private String itemType; // {clothing, pants, shoes}
    private boolean isOnSale;
    private int ownerId; // same as "userId" in User class

    public Good() {

    }

    public Good(int id, String name, String description, Image itemImage, int price, String itemType, boolean isOnSale, int ownerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemImage = itemImage;
        this.price = price;
        this.itemType = itemType;
        this.isOnSale = isOnSale;
        this.ownerId = ownerId;
    }
}
