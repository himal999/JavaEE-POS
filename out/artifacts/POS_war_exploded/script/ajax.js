$("#view-customer").click(()=>{
    $.ajax({
        url:"customer",
        method:"GET",

        success:function (resp) {
            $("#customerTbl").empty();
            var customer = new Customer();
            var count = 0;
            for (const temp of resp){
                count++;
                customer.setId(temp.id)
                customer.setName(temp.name)
                customer.setAddress(temp.address)
                customer.setTel(temp.tel);
              let row = `<tr><td>${count}</td><td>${customer.getId()}</td><td>${customer.getName()}</td><td>${customer.getAddress()}</td><td>${customer.getTel()}</td><td>"update"</td></tr>`
              $("#customerTbl").append(row);
          }
        }
    })
})