var count=1;
var itemsArray ;


const placePageInit = function () {
    $('#placeAddBtn').attr('disabled','disabled')
    $('#placeResetBtn').attr('disabled','disabled');
    $('#place-order-btn-cancel').attr('disabled','disabled');
    $('#place-order-btn-ok').attr('disabled','disabled');

    $('#placeItemUnitPrice').attr("readonly", "readonly");
    $('#placeItemStock').attr("readonly", "readonly");

    $('#placeItemQtyValidation').css('display','none');

    clearPlaceFields();


}
function clearPlacesFields() {
    $("#placeItemName").val("");
    $("#placeItemUnitPrice").val("");
    $("#placeItemStock").val("");
    $("#placeItemQty").val("");
}
function clearPlaceFields() {
    clearPlacesFields();
    $("#placeNoOfItems").text("");
    $("#placeTotalBalance").text("");
    $("#placeDisscount").val("");
    $("#placeSubTotal").text("");
    $("#placePayIn").val("");
    $("#placePayBalance").text("");

}

const loadAllItemDetails  = function (items) {
    $("#item-list").empty();
    $("#item-list>li").off();
    itemsArray = items;

    if( $("#placeTbl>tr").length == 0){
        for (const temp of items){
            let li = `<li style="cursor: pointer;margin-left: .5rem;margin-bottom: .5rem;" class="listId">${temp.itemName}</li>`;
            $("#item-list").append(li);
        }
    }else{
        const alreadyItems = new Array();
     $("#placeTbl>tr").each(function () {
         alreadyItems.push($(this).find(":eq(1)").text());

     });
        for (const temp of items){
            let li = `<li style="cursor: pointer;margin-left: .5rem;margin-bottom: .5rem;" class="listId">${temp.itemName}</li>`;
            $("#item-list").append(li);
        }

        $("#placeTbl>tr").each(function () {
            for (const temp of items){
               var  tempName = temp.itemName;
               var  alreadyName = $(this).find(":eq(1)").text();
                if(tempName == alreadyName){
                    $("#item-list>li").each(function () {
                        var tempListName = $(this).text();
                       if(tempName == tempListName ){
                           $(this).remove();
                       }
                    });
                }
            }
        });
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
                $("#placeItemQty").attr("max",item.getItemStock());
            }
        }
        $('#item-list').toggle();
    });

}

const addTable = function () {
    $("#placeTbl").off();


    let qty = `<div style="display: flex;position: relative;justify-content: center;font-size: 1.2rem;"><i class='bx bx-minus-circle  placeQtyDecremet' style="cursor: pointer" ></i><lable class="placeQty" style="margin-left: 1rem;margin-right: 1rem;width: 42px;display: flex;justify-content: center;">${$('#placeItemQty').val()}</lable><i class='bx bx-plus-circle placeQtyIncrement'style="cursor: pointer;"></i></div>`

    let row = `<tr><td>${count++}</td><td>${$("#placeItemName").val()}</td><td>${$('#placeItemUnitPrice').val()}</td><td>${qty}</td></tr>`;

    $('#placeTbl').append(row);







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

    $("#placeTbl").on('click','.placeQtyIncrement', function () {

        var itemName = $(this).closest("tr").find("td:eq(1)").text();
        var availableQty= undefined;

        for(const temp of itemsArray){
            if(temp.itemName == itemName){
               availableQty =  temp.itemStock;
            }
        }
        var currentQty = $(this).closest("tr").find("td:eq(3)").text();
        currentQty++;

        if(currentQty<=availableQty){
            $(this).closest("tr").find(".placeQty").text(currentQty);
        }else{
            $(this).closest("tr").find(".placeQty").text(--currentQty);
        }
    });

    $('#placeAddBtn').attr('disabled','disabled');
}

function checkValidQty() {

    var inputQty = $("#placeItemQty").val();
    var availableQty  = $("#placeItemStock").val();

    if(+availableQty >= +inputQty){
        $('#placeAddBtn').removeAttr('disabled')
        $('#placeResetBtn').removeAttr('disabled');
        $('#placeItemQtyValidation').css('display','none');
    }else{
        $('#placeAddBtn').attr('disabled','disabled')
        $('#placeResetBtn').removeAttr('disabled');
        $('#placeItemQtyValidation').css('display','block');
    }
}
