package dto;
/*
author :Himal
version : 0.0.1
*/



public class OrderDetailDTO {
    private String orderId;
    private String itemId;
    private String itemName;
    private int itemQty;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderId, String itemId, String itemName, int itemQty) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQty = itemQty;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }
}
