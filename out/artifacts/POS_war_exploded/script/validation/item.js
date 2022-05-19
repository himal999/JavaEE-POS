$("#txtItemId").keyup(()=>{
      if(checkId($("#txtItemId").val())){
          $("#itemCode").css("display",'none');
          checkAddItemBtn();
      }else{
          $("#itemCode").css("display",'block');
          checkAddItemBtn();
      }
})
$("#txtItemName").keyup(()=>{
    if(itemNameReg($("#txtItemName").val())){
        $("#itemName").css("display",'none')
        checkAddItemBtn();
    }else{
        $("#itemName").css("display",'block');
        checkAddItemBtn();
    }
})
$("#txtItemUnitPrice").keyup(()=>{
    if(itemPrice($("#txtItemUnitPrice").val())){
        $("#itemUnitPrice").css("display",'none')
        checkAddItemBtn();
    }else{
        $("#itemUnitPrice").css("display",'block');
        checkAddItemBtn();
    }
})
$("#txtItemStock").keyup(()=>{
    if(itemQty($("#txtItemStock").val())){
        $("#itemStock").css("display",'none');
        checkAddItemBtn();
    }else{
        $("#itemStock").css("display",'block');
        checkAddItemBtn();
    }
});

function checkAddItemBtn() {
    if(checkId($("#txtItemId").val())){
        $("#itemCode").css("display",'none')
        if(itemNameReg($("#txtItemName").val())){
            $("#itemName").css("display",'none');
            if(itemPrice($("#txtItemUnitPrice").val())){
                $("#itemUnitPrice").css("display",'none');
                if(itemQty($("#txtItemStock").val())){
                    $("#itemStock").css("display",'none');
                    $("#itemAddBtn").removeAttr('disabled');
                }else{
                    $("#itemStock").css("display",'block');
                    $("#itemAddBtn").attr('disabled','disabled');
                }
            }else{
                $("#itemUnitPrice").css("display",'block');
                $("#itemAddBtn").attr('disabled','disabled');
            }
        }else{
            $("#itemName").css("display",'block');
            $("#itemAddBtn").attr('disabled','disabled');
        }
    }else{
        $("#itemCode").css("display",'block');
        $("#itemAddBtn").attr('disabled','disabled');
    }
}






 function checkId(id){
     var regItemCode = /^(I-)[0-9]{3,4}$/;
     return  regItemCode.test(id)
 }
 function itemNameReg(name) {
     var regItemName = /^[A-z,0-9,-]{4,100}$/;
     return regItemName.test(name);
 }
function itemQty(qty) {
    var regItemQty = /^[1-9]{1,}$/
    return regItemQty.test(qty);
}
function itemPrice(price) {
    var regItemPrice = /^[0-9]{1,}(.)[0-9]{1,2}$/
    return regItemPrice.test(price);
}


//update


$("#txtItemUpdateName").keyup(()=>{
    if(itemNameReg($("#txtItemUpdateName").val())){
        $("#itemNameUpdate").css("display",'none')
        checkUpdateItemBtn();
    }else{
        $("#itemNameUpdate").css("display",'block');
        checkUpdateItemBtn();
    }
})
$("#txtItemUpdateUnitPrice").keyup(()=>{
    if(itemPrice($("#txtItemUpdateUnitPrice").val())){
        $("#itemPriceUpdate").css("display",'none');
        checkUpdateItemBtn();
    }else{
        $("#itemPriceUpdate").css("display",'block');
        checkUpdateItemBtn();
    }
})
$("#txtItemUpdateStock").keyup(()=>{
    if(itemQty($("#txtItemUpdateStock").val())){
        $("#itemUpdateQty").css("display",'none');
        checkUpdateItemBtn();
    }else{
        $("#itemUpdateQty").css("display",'block');
        checkUpdateItemBtn();
    }
});

function checkUpdateItemBtn() {

        if(itemNameReg($("#txtItemUpdateName").val())){
            $("#itemNameUpdate").css("display",'none');
            if(itemPrice($("#txtItemUpdateUnitPrice").val())){
                $("#itemPriceUpdate").css("display",'none');
                if(itemQty($("#txtItemUpdateStock").val())){
                    $("#itemUpdateQty").css("display",'none');
                    $("#updateItemBtn").removeAttr('disabled');
                }else{
                    $("#itemUpdateQty").css("display",'block');
                    $("#updateItemBtn").attr('disabled','disabled');
                }
            }else{
                $("#itemPriceUpdate").css("display",'block');
                $("#updateItemBtn").attr('disabled','disabled');
            }
        }else{
            $("#itemNameUpdate").css("display",'block');
            $("#updateItemBtn").attr('disabled','disabled');
        }

}