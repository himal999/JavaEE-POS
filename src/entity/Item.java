package entity;/*
author :Himal
version : 0.0.1
*/

public class Item {
    private String itemcode;
    private String itemname;
    private double unitprice;
    private int itemstock;

    public Item() {
    }

    public Item(String itemcode, String itemname, double unitprice, int itemstock) {
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.unitprice = unitprice;
        this.itemstock = itemstock;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getItemstock() {
        return itemstock;
    }

    public void setItemstock(int itemstock) {
        this.itemstock = itemstock;
    }
}
