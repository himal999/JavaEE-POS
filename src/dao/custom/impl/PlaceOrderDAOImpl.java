package dao.custom.impl;/*
author :Himal
version : 0.0.1
*/

import dao.CrudDAO;
import dao.CrudUtil;
import entity.Order;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderDAOImpl implements CrudDAO<Order, String> {

    @Override
    public JsonArray getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `order`");
        JsonArrayBuilder orderArray = Json.createArrayBuilder();
        JsonObjectBuilder orderJSON = Json.createObjectBuilder();
        while (rst.next()) {
            Order order = new Order(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getDouble(5), rst.getDouble(6));
            orderJSON.add("orderId", order.getOid());
            orderJSON.add("orderCustomerId", order.getCustid());
            orderJSON.add("orderNoOfItems", order.getOnoofitem());
            orderJSON.add("orderDate", order.getOdate());
            orderJSON.add("orderAmount", order.getOamount());
            orderJSON.add("orderDiscountAmount", order.getOdiscountamount());
            orderArray.add(orderJSON.build());
        }
        return orderArray.build();
    }

    @Override
    public boolean add(Order order) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
