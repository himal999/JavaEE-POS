package dao.custom.impl;/*
author :Himal
version : 0.0.1
*/


import dao.CrudDAO;
import dao.CrudUtil;
import entity.Item;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements CrudDAO<Item, String> {
    @Override
    public JsonArray getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `item`");
        Item item;
        JsonArrayBuilder itemArray = Json.createArrayBuilder();
        JsonObjectBuilder itemJSON = Json.createObjectBuilder();
        while (rst.next()) {
            item = new Item(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getInt(4));
            itemJSON.add("itemCode", item.getItemcode());
            itemJSON.add("itemName", item.getItemname());
            itemJSON.add("itemUnitPrice", item.getUnitprice());
            itemJSON.add("itemStock", item.getItemstock());
            itemArray.add(itemJSON.build());
        }
        return itemArray.build();
    }

    @Override
    public boolean add(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO `item` VALUES (?,?,?,?)", item.getItemcode(), item.getItemname(), item.getUnitprice(), item.getItemstock());
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE `item` SET `itemname`=?,`unitprice`=?,`itemstock`=? WHERE itemcode=?", item.getItemname(), item.getUnitprice(), item.getItemstock(), item.getItemcode());
    }

    @Override
    public boolean delete(String itemId) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM `item` WHERE itemCode=?", itemId);
    }
}
