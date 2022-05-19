$('body').ready(()=>{
    $("#customer-nic").css('display','none');
    $("#customer-name").css('display','none');
    $("#customer-Address").css('display','none');
    $("#customer-tel").css('display','none');
    $("#addCustomerBtn").attr('disabled','disabled');
});

$("#txtCustomerId").keyup(function(){


   if(checkNic($("#txtCustomerId").val())){
        $("#customer-nic").css('display','none');
        checkAddBtn();
    }else{
        $("#customer-nic").css('display','block');
        checkAddBtn();
    }
});

$("#txtCustomerName").keyup(function(){
    if(checkName($("#txtCustomerName").val())){
        $("#customer-name").css('display','none');
        checkAddBtn();
    }else{
        $("#customer-name").css('display','block');
        checkAddBtn();
    }
});


$("#txtCustomerAddress").keyup(function(){
    if(checkAddress($("#txtCustomerAddress").val())){
        $("#customer-Address").css('display','none');
         checkAddBtn();
    }else{
        $("#customer-Address").css('display','block');
        checkAddBtn();
    }
});
$("#txtCustomerTel").keyup(function(){
    if(checkTel($("#txtCustomerTel").val())){
        $("#customer-tel").css('display','none');
        checkAddBtn();
    }else{
        $("#customer-tel").css('display','block');
        checkAddBtn();
    }
});

function checkAddBtn() {
    if(checkNic($("#txtCustomerId").val())){
        $("#customer-nic").css('display','none');
        if(checkName($("#txtCustomerName").val())){
            $("#customer-name").css('display','none');
            if(checkAddress($("#txtCustomerAddress").val())){
                $("#customer-Address").css('display','none');
                if(checkTel($("#txtCustomerTel").val())){
                    $("#addCustomerBtn").removeAttr('disabled');
                    $("#customer-tel").css('display','none');
                }else{
                    $("#customer-tel").css('display','block');
                    $("#addCustomerBtn").attr('disabled','disabled');
                }
            }else{
                $("#customer-Address").css('display','block');
                $("#addCustomerBtn").attr('disabled','disabled');
            }
        }else{
            $("#customer-name").css('display','block');
            $("#addCustomerBtn").attr('disabled','disabled');
        }
    }else{
        $("#customer-nic").css('display','block');
        $("#addCustomerBtn").attr('disabled','disabled');
    }
}


function checkNic(nic){
    var regNIc = /^[0-9]{9,9}(v)$/;
    return regNIc.test(nic);
}
function checkName(name){
    var regName = /^[A-z,0-9]{3,}$/
    return regName.test(name);
}

function checkAddress(address) {
    var regAddress = /^[A-z,0-9]{3,}$/
    return regAddress.test(address);
}

function checkTel(tel) {
    var regTel = /^[0-9]{10}$/;
    return regTel.test(tel);
}

//update



$("#txtCustomerUpdateName").keyup(function(){
    if(checkName($("#txtCustomerUpdateName").val())){
        $("#customer-name-update").css('display','none');
        checkAddBtnUpdate();
    }else{
        $("#customer-name-update").css('display','block');
        checkAddBtnUpdate();
    }
});


$("#txtCustomerUpdateAddress").keyup(function(){
    if(checkAddress($("#txtCustomerUpdateAddress").val())){
        $("#customer-Address-update").css('display','none');
        checkAddBtnUpdate();
    }else{
        $("#customer-Address-update").css('display','block');
        checkAddBtnUpdate();
    }
});
$("#txtCustomerUpdateTel").keyup(function(){
    if(checkTel($("#txtCustomerUpdateTel").val())){
        $("#customer-tel-update").css('display','none');
        checkAddBtnUpdate();
    }else{
        $("#customer-tel-update").css('display','block');
        checkAddBtnUpdate();
    }
});

function checkAddBtnUpdate() {
    if(checkName($("#txtCustomerUpdateName").val())){
        $("#customer-name-update").css('display','none');
        if(checkAddress($("#txtCustomerUpdateAddress").val())){
            $("#customer-Address-update").css('display','none');
            if(checkTel($("#txtCustomerUpdateTel").val())){
                $("#customerUpdateConfirmBtn").removeAttr('disabled');
                $("#customer-tel-update").css('display','none');
            }else{
                $("#customer-tel-update").css('display','block');
                $("#customerUpdateConfirmBtn").attr('disabled','disabled');
            }
        }else{
            $("#customer-Address-update").css('display','block');
            $("#customerUpdateConfirmBtn").attr('disabled','disabled');
        }
    }else{
        $("#customer-name-update").css('display','block');
        $("#customerUpdateConfirmBtn").attr('disabled','disabled');
    }
}