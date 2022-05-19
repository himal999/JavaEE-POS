const loadAllItems = function (resp) {

    $('#itemTbl').empty();
    $("#itemTbl>tr").off();
    var item = new Item();
    var count = 1 ;
    const action = `<div style="display: flex;justify-content: center; align-items: center;font-size: 1.5rem;">
                                <i class='bx bx-pencil itemUpdateBtn' style="margin-right: 1.5rem;" ></i>
                                <i class='bx bx-trash itemDeleteBtn' style="margin-left: 1.5rem;"></i>
                           </div>`
    for (const temp of resp){
        item.setItemCode(temp.itemCode);
        item.setItemName(temp.itemName);
        item.setItemUnitPrice(temp.itemUnitPrice);
        item.setItemStock(temp.itemStock);

        let row  = `<tr><td>${count++}</td><td>${item.getItemCode()}</td><td>${item.getItemName()}</td><td>${item.getItemUnitPrice()}</td><td>${item.getItemStock()}</td><td>${action}</td></tr>`

        $('#itemTbl').append(row);

        $("#itemTbl>tr").hover(function () {
               $(this).addClass('hover')
        },function () {
            $(this).removeClass('hover')
        });

        $('.itemUpdateBtn').hover(function () {
            $(this).addClass('iconUpdate');
        },function () {
            $(this).removeClass('iconUpdate');
        })
        $('.itemDeleteBtn').hover(function () {
            $(this).addClass('iconDelete');
        },function () {
            $(this).removeClass('iconDelete');
        });

        $("#itemTbl").on('click','.itemUpdateBtn',function () {
                $("#updateItemBtn").attr('disabled','disabled');
                $('#txtItemUpdateId').attr("readonly", "readonly");
                $("#itemNameUpdate").css("display",'none');
                $("#itemPriceUpdate").css("display",'none');
                $("#itemUpdateQty").css("display",'none');
                itemUpdate($(this).closest('tr'));
        });

        $('#itemTbl').on('click','.itemDeleteBtn',function () {
               itemDelete($(this).closest('tr'))
        });
    }
}

function itemUpdate(currentRow) {
    $('#item-update-delete-title').text("Update Item Details")
    $('.item').addClass('body-blue');
    $('.item').css('display','block');
    $('.item__update-delete').css('display','block')

    $('#txtItemUpdateId').val(currentRow.find("td:eq(1)").text())
    $('#txtItemUpdateName').val(currentRow.find("td:eq(2)").text())
    $('#txtItemUpdateUnitPrice').val(currentRow.find("td:eq(3)").text())
    $('#txtItemUpdateStock').val(currentRow.find("td:eq(4)").text())
}

const itemDelete = function (currentRow) {
    var selected =  confirm(`Are you sure drop ${currentRow.find("td:eq(1)").text()} ${currentRow.find("td:eq(2)").text()} Item ?`);

    if(selected){
        deleteItem(currentRow.find("td:eq(1)").text());
        return;
    }
}

function clearAllItemField(){
    $("#txtItemId").val("");
    $("#txtItemName").val("");
    $("#txtItemUnitPrice").val("");
    $("#txtItemStock").val("");


}