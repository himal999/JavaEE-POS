function loadAllItemFromOrders(){
     $.ajax({
        url:"item",
        method:"GET",
        success:function (resp) {
            loadAllItemDetails(resp);
        }
    })
}