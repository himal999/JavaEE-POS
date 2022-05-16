package dao;/*
author :Himal
version : 0.0.1
*/

import model.ItemDTO;

import javax.json.JsonArray;
import java.sql.SQLException;

public interface ItemDAO {
    JsonArray getAllItems() throws SQLException, ClassNotFoundException;
    boolean addItem(ItemDTO item) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String itemId) throws SQLException, ClassNotFoundException;
}
