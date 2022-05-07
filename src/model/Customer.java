package model;
/*
author :Himal
version : 0.0.1
*/

public class Customer {
   private String nic;
   private String name;
   private String address;
   private int tel;

    public Customer() {
    }

    public Customer(String nic, String name, String address, int tel) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }



    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
