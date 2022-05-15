class OrderDetail {
    constructor(itemId,itemNa,qty) {

        this.itemId = itemId;
        this.itemNa = itemNa;
        this.qty = qty;
    }

    setItemId = function (itemId) {
        this.itemId = itemId;
    }
    getItemId = function () {
        return this.itemId;
    }

    setItemName = function (itemNa) {
        this.itemNa = itemNa;
    }
    getItemName = function () {
        return this.itemNa;
    }

    setItemQty = function (qty) {
        this.qty = qty;
    }
    getItemQty = function () {
        return this.qty;
    }
}