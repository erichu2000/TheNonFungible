package com.example.thenonfungible.Model;

public class Avatar {
    public Good clothing;
    public Good pants;
    public Good shoes;

    public Avatar() {}

    public Avatar(Good clothing, Good pants, Good shoes) {
        this.clothing = clothing;
        this.pants = pants;
        this.shoes = shoes;
    }

    public Good getClothing() {
        return clothing;
    }

    public Good getPants() {
        return pants;
    }

    public Good getShoes() {
        return shoes;
    }
}