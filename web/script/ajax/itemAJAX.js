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

function deleteItem(itemCode) {
    $.ajax({
        url:"item?itemCode="+itemCode,
        method:"DELETE",
        success:function (resp) {
            $.ajax({
                url:"item",
                method:"GET",
                success:function (resp) {
                    loadAllItems(resp);

                }
            });
        }

    })
}

$('#itemAddBtn').click(function () {
    $.ajax({
        url:"item",
        method:"POST",
        data:$("#item-add").serialize(),
        success:function () {
            clearAllItemField();
            $.ajax({
                url:"item",
                method:"GET",
                success:function (resp) {
                    loadAllItems(resp);

                }
            });
        }
    })
})