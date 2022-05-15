package dao;/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.CustomerDTO;
import model.ItemDTO;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl {
    public JsonArray getAllItems() throws SQLException, ClassNotFoundException {
        ItemDTO item ;
        JsonArrayBuilder itemArray = Json.createArrayBuilder();
        JsonObjectBuilder itemJSON = Json.createObjectBuilder();

        ResultSet  rst = Db.db().getConnection().prepareStatement("SELECT * FROM `item`").executeQuery();
        while (rst.next()){
            item = new ItemDTO(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getInt(4));
            itemJSON.add("itemCode",item.getItemCode());
            itemJSON.add("itemName",item.getItemName());
            itemJSON.add("itemUnitPrice",item.getItemUnitPrice());
            itemJSON.add("itemStock",item.getItemStock());
            itemArray.add(itemJSON.build());

        }
        return itemArray.build();
    }

    public  boolean addItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = Db.db().getConnection().prepareStatement("INSERT INTO `item` VALUES (?,?,?,?)");
        pst.setString(1,item.getItemCode());
        pst.setString(2,item.getItemName());
        pst.setDouble(3,item.getItemUnitPrice());
        pst.setInt(4,item.getItemStock());
        return pst.executeUpdate()>0;
    }

    public  boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = Db.db().getConnection().prepareStatement("UPDATE `item` SET `itemname`=?,`unitprice`=?,`itemstock`=? WHERE itemcode=?");
        pst.setString(1,item.getItemName());
        pst.setDouble(2,item.getItemUnitPrice());
        pst.setInt(3,item.getItemStock());
        pst.setString(4,item.getItemCode());
        return pst.executeUpdate()>0;
    }

    public boolean deleteItem(String itemId) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = Db.db().getConnection().prepareStatement("DELETE FROM `item` WHERE itemCode=?");
        pst.setString(1,itemId);
        return pst.executeUpdate()>0;
    }
}
