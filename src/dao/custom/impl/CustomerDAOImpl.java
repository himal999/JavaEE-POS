package dao.custom.impl;/*
author :Himal
version : 0.0.1
*/


import dao.CrudDAO;
import dao.CrudUtil;

import entity.Customer;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CrudDAO<Customer,String> {

    @Override
    public JsonArray getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `customer`");
        Customer customer = null;
        JsonArrayBuilder customerArray = Json.createArrayBuilder();
        JsonObjectBuilder customerJSON = Json.createObjectBuilder();
        while (rst.next()) {
            customer = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
            customerJSON.add("id", customer.getNic());
            customerJSON.add("name", customer.getName());
            customerJSON.add("address", customer.getAddress());
            customerJSON.add("tel", customer.getTel());
            customerArray.add(customerJSON.build());
        }
        return customerArray.build();
    }

    @Override
    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
        System.out.println("hhhhh");
        return CrudUtil.executeUpdate("INSERT INTO `customer` VALUES(?,?,?,?)", customer.getNic(), customer.getName(), customer.getAddress(), customer.getTel());
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE `customer` SET name=?,address=?,tel=? WHERE nic=?", customer.getName(), customer.getAddress(), customer.getTel(), customer.getNic());
    }


    @Override
    public boolean delete(String customerId) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM `customer` WHERE nic=?", customerId);
    }

}
