const loadAllItemDetails  = function (items) {
    $("#item-list").empty();
    $("#item-list>li").off();

    for (const temp of items){

        let li = `<li style="cursor: pointer;margin-left: .5rem;margin-bottom: .5rem;" class="listId">${temp.itemName}</li>`;
        $("#item-list").append(li);
    }
    $('.listId').click(function () {
        var item  = new Item();
        for(const temp of items){
            item.setItemCode(temp.itemCode);
            item.setItemName(temp.itemName);
            item.setItemUnitPrice(temp.itemUnitPrice);
            item.setItemStock(temp.itemStock);
            if(temp.itemName == $(this).text()){
                $("#placeItemName").val(item.getItemName());
              $('#placeItemUnitPrice').val(item.getItemUnitPrice());
              $('#placeItemStock').val(item.getItemStock())
            }
        }
    })
}