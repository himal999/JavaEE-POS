function Item() {
    var __itemCode;
    var __itemName;
    var __itemUnitPrice;
    var __itemStock;

    this.setItemCode = function (itemCode) {
        __itemCode = itemCode;
    }

    this.getItemCode =function () {
        return __itemCode;
    }

    this.setItemName = function (itemName) {
       __itemName = itemName;
    }

    this.getItemName = function () {
        return __itemName;
    }

    this.setItemUnitPrice =function (itemUnitPrice) {
         __itemUnitPrice = itemUnitPrice;
    }
    this.getItemUnitPrice = function () {
            return __itemUnitPrice
    }

    this.setItemStock = function (itemStock) {
        __itemStock = itemStock;
    }

    this.getItemStock = function () {
        return __itemStock;
    }
}