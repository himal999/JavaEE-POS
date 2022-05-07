

$("#view-customer").click(()=>{
    $.ajax({
        url:"customer",
        method:"GET",

        success:function (resp) {
            loadAllCustomers(resp);

        }
    })
});

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
})