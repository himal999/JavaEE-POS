class  Order {
    constructor(orderId,orderCustomerId,orderNoOfItems,orderDate,orderAmount,orderDiscountAmount) {
        this.orderId = orderId;
        this.orderCustomerId= orderCustomerId;
        this.orderNoOfItems = orderNoOfItems;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderDiscountAmount = orderDiscountAmount;
    }

    setOrderId =  function (orderId) {
        this.orderId = orderId;
    }

    getOrderId = function () {
        return this.orderId;
    }
    setOrderCustomerId = function (orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }
    getOrderCustomerId = function () {
       return  this.orderCustomerId;
    }

    setOrderNoOfItems = function (orderNoOfItems) {
        this.orderNoOfItems = orderNoOfItems;
    }
    getOrderNoOfItems = function () {
        return this.orderNoOfItems;
    }

    setOrderDate = function (orderDate) {
        this.orderDate = orderDate;
    }
    getOrderDate = function () {
        return this.orderDate ;
    }

    setOrderAmount = function (orderAmount) {
        this.orderAmount = orderAmount;
    }
    getOrderAmount = function () {
        return this.orderAmount;
    }
    setOrderDiscountAmount = function (orderDiscountAmount) {
       this.orderDiscountAmount = orderDiscountAmount;
    }
    getOrderDiscountAmount = function () {
       return  this.orderDiscountAmount ;
    }
}