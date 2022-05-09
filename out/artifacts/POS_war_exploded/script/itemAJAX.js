$('#view-item').click(function () {
    $('.item').removeClass('body-blue');
   $.ajax({
       url:"item",
       method:"GET",
       success:function (resp) {
            loadAllItems(resp)
       }
   });
});

$('#updateItemBtn').click(function () {

    var item = {
        "itemCode":$('#txtItemUpdateId').val(),
        "itemName":$('#txtItemUpdateName').val(),
        "itemUnitPrice":$('#txtItemUpdateUnitPrice').val(),
        "itemStock":$('#txtItemUpdateStock').val()
    }

    $.ajax({
        url: "item",
        method:"PUT",
        contentType:"JSON",
        data:JSON.stringify(item),
        success:function (resp) {
            $('.item').removeClass('body-blue');
            $('.item__update-delete').css('display','none')

            $.ajax({
                url:"item",
                method:"GET",
                success:function (resp) {
                    loadAllItems(resp)
                }
            });
        }
    });
});