package com.example.thenonfungible.Model;

public class Order {
    private int orderID;
    private String date;
    private int customerID;
    private int sellerID;
    private int goodsID;
    private int goodsCount;
    private double totalPrice;

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getDate() {
        return date;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
