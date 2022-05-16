package entity;/*
author :Himal
version : 0.0.1
*/

public class Order_details {
    String oid;
    String itemid;
    String itemname;
    int qty;

    public Order_details() {
    }

    public Order_details(String oid, String itemid, String itemname, int qty) {
        this.oid = oid;
        this.itemid = itemid;
        this.itemname = itemname;
        this.qty = qty;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
