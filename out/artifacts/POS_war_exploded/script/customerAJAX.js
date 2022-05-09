

$("#view-customer").click(()=>{
    $('.customer').removeClass('body-blue');
    $.ajax({
        url:"customer",
        method:"GET",

        success:function (resp) {
            loadAllCustomers(resp);

        }
    })
});

$('#addCustomerBtn').click(function () {
    $('.customer').removeClass('body-blue');
   var data =  $('#customerAddForm').serialize();
    $.ajax({
        url:"customer",
        method:"POST",
        data:data,
        success:function (resp) {
            clearAllFields();
            $.ajax({
                url:"customer",
                method:"GET",
                success:function (resp) {
                    loadAllCustomers(resp)

                }
            });
        }
    })
})

$('#customerUpdateConfirmBtn').click(()=>{
    var customer  = {
        "id":$("#txtCustomerUpdateId").val(),
        "name":$("#txtCustomerUpdateName").val(),
        "address":$("#txtCustomerUpdateAddress").val(),
        "tel":$("#txtCustomerUpdateTel").val()
    }

    $.ajax({
        url: "customer",
        method: "PUT",
        contentType:"application/json",
        data:JSON.stringify(customer),
        success:function (resp) {
            $('.customer').removeClass('body-blue');
            $('.customer__update-delete').css('display','none')
            $.ajax({
                url:"customer",
                method:"GET",
                success:function (resp) {
                      loadAllCustomers(resp)

                }
            });

        }
    })
});

function deleteCustomer(customerId) {

 $.ajax({
    url:"customer?customerId="+customerId,
    method:"DELETE",

    success:function (resp) {
         $.ajax({
             url:"customer",
             method:"GET",
             success:function (resp) {
                 loadAllCustomers(resp)

             }
         })
    }
 })
}