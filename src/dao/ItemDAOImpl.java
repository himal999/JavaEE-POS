package dao;/*
author :Himal
version : 0.0.1
*/


import model.ItemDTO;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {
    public JsonArray getAllItems() throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `item`");
        ItemDTO item;
        JsonArrayBuilder itemArray = Json.createArrayBuilder();
        JsonObjectBuilder itemJSON = Json.createObjectBuilder();
        while (rst.next()) {
            item = new ItemDTO(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getInt(4));
            itemJSON.add("itemCode", item.getItemCode());
            itemJSON.add("itemName", item.getItemName());
            itemJSON.add("itemUnitPrice", item.getItemUnitPrice());
            itemJSON.add("itemStock", item.getItemStock());
            itemArray.add(itemJSON.build());
        }
        return itemArray.build();
    }

    public boolean addItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO `item` VALUES (?,?,?,?)", item.getItemCode(), item.getItemName(), item.getItemUnitPrice(), item.getItemStock());
    }

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE `item` SET `itemname`=?,`unitprice`=?,`itemstock`=? WHERE itemcode=?", item.getItemName(), item.getItemUnitPrice(), item.getItemStock(), item.getItemCode());
    }

    public boolean deleteItem(String itemId) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM `item` WHERE itemCode=?", itemId);
    }
}
