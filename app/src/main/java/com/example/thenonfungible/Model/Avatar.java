package com.example.thenonfungible.Model;

import com.google.firebase.database.PropertyName;

public class Avatar {
    public Good clothing;
    public Good pants;
    public Good shoes;

    public Avatar() {

    }

    public Avatar(Good clothing, Good pants, Good shoes) {
        this.clothing = clothing;
        this.pants = pants;
        this.shoes = shoes;
    }

    @PropertyName("clothing")
    public Good getClothing() {
        return clothing;
    }

    @PropertyName("clothing")
    public void setClothing(Good clothing) {
        this.clothing = clothing;
    }

    @PropertyName("pants")
    public Good getPants() {
        return pants;
    }

    @PropertyName("pants")
    public void setPants(Good pants) {
        this.pants = pants;
    }

    @PropertyName("shoes")
    public Good getShoes() {
        return shoes;
    }

    @PropertyName("shoes")
    public void setShoes(Good shoes) {
        this.shoes = shoes;
    }

}
