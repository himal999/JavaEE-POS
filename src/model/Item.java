package model;/*
author :Himal
version : 0.0.1
*/

public class Item {
    private String itemCode;
    private String itemName;
    private double itemUnitPrice;
    private int itemStock;

    public Item(String itemCode, String itemName, double itemUnitPrice, int itemStock) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemUnitPrice = itemUnitPrice;
        this.itemStock = itemStock;
    }

    public Item() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(double itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }
}
