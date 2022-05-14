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