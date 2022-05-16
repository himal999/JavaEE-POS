function loadAllItemFromOrders(){
     $.ajax({
        url:"item",
        method:"GET",
        success:function (resp) {
            loadAllItemDetails(resp);
        }
    })
}

function loadAllCustomersName() {
    $.ajax({
        url:"customer",
        method:"GET",
        success:function (resp) {
            loadAllCustomerDetails(resp);
        }
    })
}

function loadAllOrders() {
    $.ajax({
        url:"place_order",
        method:"GET",
        success:function (resp) {
            getInvoiceNumber(resp)
        }
    })
}

function placeOrder(orderDetail) {
    $.ajax({
        url:"place_order",
        method:"POST",
        contentType:"application/json",
        data:JSON.stringify(orderDetail),
        success:function (resp) {

        }
    })
}