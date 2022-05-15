package model;/*
author :Himal
version : 0.0.1
*/

import javax.json.JsonArray;

public class OrderDTO {
    private String orderId;
    private String orderCustomerId;
    private int orderNoOfItems;
    private String orderDate;
    private Double orderAmount;
    private Double orderDiscountAmount;
    private JsonArray orderItems;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String orderCustomerId, int orderNoOfItems, String orderDate, Double orderAmount, Double orderDiscountAmount, JsonArray orderItems) {
        this.orderId = orderId;
        this.orderCustomerId = orderCustomerId;
        this.orderNoOfItems = orderNoOfItems;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderDiscountAmount = orderDiscountAmount;
        this.orderItems = orderItems;
    }

    public OrderDTO(String orderId, String orderCustomerId, int orderNoOfItems, String orderDate, Double orderAmount, Double orderDiscountAmount) {
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
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

    public JsonArray getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(JsonArray orderItems) {
        this.orderItems = orderItems;
    }
}
