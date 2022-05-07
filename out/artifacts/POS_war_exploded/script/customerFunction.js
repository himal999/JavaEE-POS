   loadAllCustomers = function (resp) {
       console.log(resp)
    $("#customerTbl").empty();
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

        $(".customerUpdateBtn").click(()=>{
            customerUpdate();
        });
        $(".customerDeleteBtn").click(()=>{
            customerDelete();
        });
    }
}

const customerUpdate = function () {
    $('#customer-update-delete-title').text("Update Customer Details")
    $('.customer').addClass('body-blue');
    $('.customer').css('display','block');
    $('.customer__update-delete').css('display','block')
}
const customerDelete = function () {
    $('#customer-update-delete-title').text("Delete Customer Details")
    $('.customer').addClass('body-blue');
    $('.customer').css('display','block');
    $('.customer__update-delete').css('display','block')
}