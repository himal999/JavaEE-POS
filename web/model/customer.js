function Customer() {
   var __id ;
   var __name ;
   var __address ;
   var __tel ;

   this.setId = function (id) {
      __id = id;
   }

   this.getId = function () {
       return __id;
   }

   this.setName = function (name) {
        __name = name;
   }

   this.getName = function () {
        return __name;
   }

   this.setAddress = function (address) {
     __address = address;
   }

   this.getAddress = function () {
        return __address;
   }

   this.setTel = function (tel) {
      __tel = tel;
   }
   this.getTel = function () {
        return __tel;
   }
}