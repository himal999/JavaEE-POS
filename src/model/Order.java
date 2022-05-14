package model;/*
author :Himal
version : 0.0.1
*/

import java.util.Date;

public class Order {
    private String orderId;
    private String orderCustomerId;
    private int orderNoOfItems;
    private Date orderDate;
    private Double orderAmount;
    private Double orderDiscountAmount;

    public Order() {
    }

    public Order(String orderId, String orderCustomerId, int orderNoOfItems, Date orderDate, Double orderAmount, Double orderDiscountAmount) {
        this.orderId = orderId;
        this.orderCustomerId = orderCustomerId;
        this.orderNoOfItems = orderNoOfItems;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderDiscountAmount = orderDiscountAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(String orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }

    public int getOrderNoOfItems() {
        return orderNoOfItems;
    }

    public void setOrderNoOfItems(int orderNoOfItems) {
        this.orderNoOfItems = orderNoOfItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getOrderDiscountAmount() {
        return orderDiscountAmount;
    }

    public void setOrderDiscountAmount(Double orderDiscountAmount) {
        this.orderDiscountAmount = orderDiscountAmount;
    }
}
