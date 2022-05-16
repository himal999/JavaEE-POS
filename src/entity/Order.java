package entity;/*
author :Himal
version : 0.0.1
*/

public class Order {
    private String oid;
    private String custid;
    private int onoofitem;
    private String odate;
    private double oamount;
    private double odiscountamount;

    public Order() {
    }

    public Order(String oid, String custid, int onoofitem, String odate, double oamount, double odiscountamount) {
        this.oid = oid;
        this.custid = custid;
        this.onoofitem = onoofitem;
        this.odate = odate;
        this.oamount = oamount;
        this.odiscountamount = odiscountamount;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public int getOnoofitem() {
        return onoofitem;
    }

    public void setOnoofitem(int onoofitem) {
        this.onoofitem = onoofitem;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public double getOamount() {
        return oamount;
    }

    public void setOamount(double oamount) {
        this.oamount = oamount;
    }

    public double getOdiscountamount() {
        return odiscountamount;
    }

    public void setOdiscountamount(double odiscountamount) {
        this.odiscountamount = odiscountamount;
    }
}
