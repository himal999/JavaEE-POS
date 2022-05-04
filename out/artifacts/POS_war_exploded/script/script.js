
//navigation show hide
$("#header-show").click(()=>{
    $('#nav').removeClass('sliderOut')
    $('#nav').addClass('sliderIn')
    $("#header-show").hide();
    $('#header-hide').show();
    $("#nav").toggle()
})
$('#header-hide').click(()=>{
    $('#nav').removeClass('sliderIn')
    $('#nav').addClass('sliderOut')
    $('#header-hide').hide();
    $("#header-show").show();
    $("#nav").toggle()
})

//navigation sub menu show hide

$('#nav_customer').click(()=>{
    $('#navCustomer').toggle();
   
})

$('#nav_item').click(()=>{
    $('#navItem').toggle();
})

$('#nav_purchase').click(()=>{
    $('#navPurchase').toggle();
})

//customer add text field select css

$('#txtCustomerId').click(()=>{
    $('#txtCustomerId').addClass('select-field');
    $('#txtCustomerName').removeClass('select-field')
    $('#txtCustomerAddress').removeClass('select-field')
    $('#txtCustomerTel').removeClass('select-field')

})
$('#txtCustomerName').click(()=>{
    $('#txtCustomerId').removeClass('select-field');
    $('#txtCustomerName').addClass('select-field')
    $('#txtCustomerAddress').removeClass('select-field')
    $('#txtCustomerTel').removeClass('select-field')

})
$('#txtCustomerAddress').click(()=>{
    $('#txtCustomerId').removeClass('select-field');
    $('#txtCustomerName').removeClass('select-field')
    $('#txtCustomerAddress').addClass('select-field')
    $('#txtCustomerTel').removeClass('select-field')

})
$('#txtCustomerTel').click(()=>{
    $('#txtCustomerId').removeClass('select-field');
    $('#txtCustomerName').removeClass('select-field')
    $('#txtCustomerAddress').removeClass('select-field')
    $('#txtCustomerTel').addClass('select-field')

})


// CUSTOMER FLOW

$('body').ready(function(){

    // hide all content
   $('.customer').css('display','none');
   $('.customer__update-delete').css('display','none')
   $('.item').css('display','none')
   $('.place-order').css('display','none')

   //add customer click
   $('#add-customer').click(()=>{
    $('#process-title').text("Add New Customer");
    $('#process-title-nav').text("customer/addnewcustomer");
    clearAllFields();   
    $('.customer_view').css('display','none')
    $('.customer__update-delete').css('display','none')
    $('.customer').css('display','block');
    $('.cutomer__add').css('display','block')

    $('.customer').removeClass('body-blue');
   });

   //view custimer click

   $('#view-customer').click(()=>{
       $('#process-title').text("View All Customers");
       $('#process-title-nav').text("customer/viewallcustomers");
       $('.cutomer__add').css('display','none')
       $('.customer__update-delete').css('display','none')
       $('.customer').css('display','block');
       $('.customer_view').css('display','block')

       $('.customer').removeClass('body-blue');
   });

   //update customer click



   //delete customer click
  
 

});

//clear field

function clearAllFields(){
    console.log("hh")
    $('#txtCustomerId').val(" ");
    $('#txtCustomerName').val(" ");
    $('#txtCustomerAddress').val(" ");
    $('#txtCustomerTel').val(" ");
}

//popup window close 

$('#customer-update-delete-close').click(()=>{
    $('.customer').removeClass('body-blue');
    $('.customer__update-delete').css('display','none')
})
