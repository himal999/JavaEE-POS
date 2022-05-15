var count=0;
var itemsArray ;
var customerArray;
var total= 0 ;

const placePageInit = function () {



    $('#placeAddBtn').attr('disabled','disabled')
    $('#placeResetBtn').attr('disabled','disabled');
    $('#place-order-btn-cancel').attr('disabled','disabled');
    $('#place-order-btn-ok').attr('disabled','disabled');

    $('#placeItemUnitPrice').attr("readonly", "readonly");
    $('#placeItemStock').attr("readonly", "readonly");

    $('#placeItemQtyValidation').css('display','none');
    $("#payInValidation").css('display','none');
    clearPlaceFields();

    //customer select box load data
    loadAllCustomersName();
    //invoice number generated
    loadAllOrders();
    //set Date
    setDate();
    //set Time
    setInterval("setTime()",1000);



}
function getInvoiceNumber(order){
    const orderId = new Array();
    for (const temp of order){
        orderId.push(temp.orderId);

    }
    if(orderId.length > 0) {
        let temp = orderId[orderId.length - 1];
        temp = +temp + 1;
        if(+temp<=9){
            $("#invoiceNo").text(`I-00${temp}`);
        }else if(+temp<=99){
            $("#invoiceNo").text(`I-0${temp}`);
        }else{
            $("#invoiceNo").text(`I-${temp}`);
        }

    }else{
        $("#invoiceNo").text("I-001");

    }
}
function setDate() {
    $("#date").text(new Date().toLocaleDateString());

}


function setTime(){
      $("#time").text(new Date().toLocaleTimeString());
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

    let row = `<tr><td>${++count}</td><td>${$("#placeItemName").val()}</td><td>${$('#placeItemUnitPrice').val()}</td><td>${qty}</td></tr>`;

    $('#placeTbl').append(row);


    setNoOfItems();
    setTotal();
    setSubTotal();

    $('#place-order-btn-cancel').removeAttr('disabled');

    $("#placeTbl").on('click', '.placeQtyDecremet', function () {

        var currentQty = $(this).closest("tr").find("td:eq(3)").text();


        if (currentQty >= 1) {
            $(this).closest("tr").find(".placeQty").text(--currentQty);
        } else {
            $(this).closest("tr").find(".placeQty").text(currentQty);
        }

        if(currentQty==0){
            $(this).parent().parent().parent().remove();
            count = 0;
            $("#placeTbl>tr").each(function () {
                $(this).find("td:eq(0)").text(++count);
            });

        }
        setNoOfItems();
        setTotal();
        setSubTotal();
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
        setNoOfItems();
        setTotal();
        setSubTotal();
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
function setNoOfItems(){

    $("#placeNoOfItems").text($('#placeTbl>tr').length);
}

function setTotal() {
    var tempTotal = 0.00;

       $("#placeTbl>tr").each(function () {
           var unPrice = parseFloat($(this).find('td:eq(2)').text());
           var qty = parseFloat($(this).find(".placeQty").text());
           tempTotal += +unPrice * +qty;
       });



    $("#placeTotalBalance").text(tempTotal);
    total = tempTotal;
}

function setSubTotal() {
    var discount = $("#placeDisscount").val();
    var subTotal = total - (total*discount/100);

    if(subTotal>0){
        $("#placeSubTotal").text(subTotal);
    }else{
        $("#placeSubTotal").text(0.00);
    }
}

function setPayBalance() {
   var cash =  $("#placePayIn").val();
   var subTotal = $("#placeSubTotal").text();

   if(+cash >= +subTotal){
       var balance = +cash - +subTotal;
       $("#payInValidation").css('display','none');
       $("#placePayBalance").text(balance);
       $('#place-order-btn-ok').removeAttr('disabled');
   }else{
       $("#placePayBalance").text("");
       $("#payInValidation").css('display','block');

       $('#place-order-btn-ok').attr('disabled','disabled');
   }
}

function loadAllCustomerDetails(customers) {
    $("#customerList>option").remove();
     customerArray = customers;
    let option = `<option>Select Customer</option>`
    $("#customerList").append(option);
    for (const tempCustomer of customers){
         option = `<option>${tempCustomer.name}</option>`
         $("#customerList").append(option);
    }
}
function findItemId(name) {
    for (const temp of itemsArray){
        if(temp.itemName == name){
            return temp.itemCode;
        }
    }
    return ;
}
function placingOrder() {
    var orderDetail ;
    const orderItem = new Array();

    $("#placeTbl>tr").each(function () {

      orderDetail = new OrderDetail(findItemId($(this).find("td:eq(1)").text()),$(this).find("td:eq(1)").text(),$(this).find(".placeQty").text());

      var tempOrderDetail = {
          "itemId":orderDetail.getItemId(),
          "itemName":orderDetail.getItemName(),
          "qty":orderDetail.getItemQty()
      }
      orderItem.push(tempOrderDetail);
    })
    const order  = new Order($("#invoiceNo").text(),getCustomerId(),$("#placeNoOfItems").text(),$("#date").text(),$("#placeTotalBalance").text(),$("#placeSubTotal").text(),orderItem);




    var orderJSON = {
        "invoiceNo":order.getOrderId(),
        "customerId":order.getOrderCustomerId(),
        "noOfItems":order.getOrderNoOfItems(),
        "date":order.getOrderDate(),
        "amount":order.getOrderAmount(),
        "subAmount":order.getOrderDiscountAmount(),
        "orderDetails":order.getOrderItem()
    }

    placeOrder(orderJSON);
}

function getCustomerId() {

    for(const temp of customerArray){
        if(temp.name ==  $("#customerList option:selected").text()){
             return temp.id
        }
    }
}