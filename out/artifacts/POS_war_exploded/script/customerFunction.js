 const  loadAllCustomers = function (resp) {

    $("#customerTbl").empty();
    $("#customerTbl>tr").off();

    var customer = new Customer();
    var count = 0;

    const action  = `<div style="display: flex;justify-content: center; align-items: center;font-size: 1.5rem;">
                                <i class='bx bx-pencil customerUpdateBtn' style="margin-right: 1.5rem;" ></i>
                                <i class='bx bx-trash customerDeleteBtn' style="margin-left: 1.5rem;"></i>
                           </div>`

    for (const temp of resp){

        count++;

        customer.setId(temp.id)
        customer.setName(temp.name)
        customer.setAddress(temp.address)
        customer.setTel(temp.tel);
        let row = `<tr><td>${count}</td><td>${customer.getId()}</td><td>${customer.getName()}</td><td>${customer.getAddress()}</td><td>${customer.getTel()}</td><td>${action}</td></tr>`
        $("#customerTbl").append(row);


        //tr hover
        $('#customerTbl tr').hover(function()
        {
            $(this).find('td').addClass('hover');
        }, function()
        {
            $(this).find('td').removeClass('hover');
        });

        //update icon hover

        $('.customerUpdateBtn').hover(function () {
                 $(this).addClass('iconUpdate')
        },function () {
                 $(this).removeClass('iconUpdate')
        });

        //delete icon hover
        $('.customerDeleteBtn').hover(function () {
            $(this).addClass('iconDelete');
        },function () {
            $(this).removeClass('iconDelete');
        });


        $("#customerTbl").on('click','.customerUpdateBtn',function(){
                clearAllUpdateFields();
                customerUpdate($(this).closest("tr"))

            });

            $("#customerTbl").on('click','.customerDeleteBtn',function(){
               customerDelete($(this).closest("tr"))
           });
    }
}

const customerUpdate = function (currentRow) {

    $('#customer-update-delete-title').text("Update Customer Details")
    $('.customer').addClass('body-blue');
    $('.customer').css('display','block');
    $('.customer__update-delete').css('display','block')


    $('#txtCustomerUpdateId').val(currentRow.find("td:eq(1)").text())
    $('#txtCustomerUpdateName').val(currentRow.find("td:eq(2)").text())
    $('#txtCustomerUpdateAddress').val(currentRow.find("td:eq(3)").text())
    $('#txtCustomerUpdateTel').val(currentRow.find("td:eq(4)").text())



}
const customerDelete = function (currentRow) {

   var selected =  confirm(`Are you sure drop ${currentRow.find("td:eq(1)").text()} ${currentRow.find("td:eq(2)").text()} Customer ?`);

 if(selected){
     deleteCustomer(currentRow.find("td:eq(1)").text());
     return;
 }


}

function  clearAllUpdateFields(){
    $('#txtCustomerUpdateId').val("");
    $('#txtCustomerUpdateName').val("");
    $('#txtCustomerUpdateAddress').val("");
    $('#txtCustomerUpdateTel').val("");
}