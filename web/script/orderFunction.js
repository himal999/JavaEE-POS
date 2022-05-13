var count=1;

const loadAllItemDetails  = function (items) {
    $("#item-list").empty();
    $("#item-list>li").off();

    for (const temp of items){

        let li = `<li style="cursor: pointer;margin-left: .5rem;margin-bottom: .5rem;" class="listId">${temp.itemName}</li>`;
        $("#item-list").append(li);
    }
    $('.listId').click(function () {
        var item  = new Item();
        for(const temp of items) {
            item.setItemCode(temp.itemCode);
            item.setItemName(temp.itemName);
            item.setItemUnitPrice(temp.itemUnitPrice);
            item.setItemStock(temp.itemStock);
            if (temp.itemName == $(this).text()) {
                $("#placeItemName").val(item.getItemName());
                $('#placeItemUnitPrice').val(item.getItemUnitPrice());
                $('#placeItemStock').val(item.getItemStock())
            }
        }
    })
}

const addTable = function () {
    $("#placeTbl").off();


    let qty = `<div style="display: flex;position: relative;justify-content: center;font-size: 1.2rem;"><i class='bx bx-minus-circle  placeQtyDecremet' style="cursor: pointer" ></i><lable class="placeQty" style="margin-left: 1rem;margin-right: 1rem;">${$('#placeItemQty').val()}</lable><i class='bx bx-plus-circle placeQtyIncrement'style="cursor: pointer;"></i></div>`

    let row = `<tr><td>${count++}</td><td>${$("#placeItemName").val()}</td><td>${$('#placeItemUnitPrice').val()}</td><td>${qty}</td></tr>`;

    $('#placeTbl').append(row);




           $(this).remove();



    $("#placeTbl").on('click', '.placeQtyDecremet', function () {

        var currentQty = $(this).closest("tr").find("td:eq(3)").text();


        if (currentQty >= 1) {
            $(this).closest("tr").find(".placeQty").text(--currentQty);
        } else {
            $(this).closest("tr").find(".placeQty").text(currentQty);
        }

        if(currentQty==0){
            $(this).parent().parent().parent().remove();
        }

    });

    $("#placeTbl").on('click', '.placeQtyIncrement', function () {

        var currentQty = $(this).closest("tr").find("td:eq(3)").text();
        $(this).closest("tr").find(".placeQty").text(++currentQty);


    })
}
