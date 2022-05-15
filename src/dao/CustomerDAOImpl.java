package dao;/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.CustomerDTO;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl {

    public JsonArray getAllCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = Db.db().getConnection();
        ResultSet rst = connection.prepareStatement("SELECT * FROM `customer`").executeQuery();
        CustomerDTO customer = null;
        JsonArrayBuilder customerArray = Json.createArrayBuilder();
        JsonObjectBuilder customerJSON = Json.createObjectBuilder();
        while (rst.next()){
            customer = new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4));
            customerJSON.add("id",customer.getNic());
            customerJSON.add("name",customer.getName());
            customerJSON.add("address",customer.getAddress());
            customerJSON.add("tel",customer.getTel());
            customerArray.add(customerJSON.build());
        }
       return customerArray.build();
    }

    public  boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = Db.db().getConnection().prepareStatement("INSERT INTO `customer` VALUES(?,?,?,?)");
        pst.setString(1,customer.getNic());
        pst.setString(2,customer.getName());
        pst.setString(3,customer.getAddress());
        pst.setInt(4,customer.getTel());
        return pst.executeUpdate()>0;
    }

    public  boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = Db.db().getConnection().prepareStatement("UPDATE `customer` SET name=?,address=?,tel=? WHERE nic=?");
        pst.setString(1,customer.getName());
        pst.setString(2,customer.getAddress());
        pst.setInt(3,customer.getTel());
        pst.setString(4,customer.getNic());
        return pst.executeUpdate()>0;
    }

    public boolean deleteCustomer(String customerId) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = Db.db().getConnection().prepareStatement("DELETE FROM `customer` WHERE nic=?");
        pst.setString(1,customerId);
        return pst.executeUpdate()>0;
    }

}
