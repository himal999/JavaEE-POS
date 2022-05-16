package dao;/*
author :Himal
version : 0.0.1
*/

import model.CustomerDTO;

import javax.json.JsonArray;
import java.sql.SQLException;

public interface CustomerDAO {
     JsonArray getAllCustomers() throws SQLException, ClassNotFoundException;
     boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;
     boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;
     boolean deleteCustomer(String customerId) throws SQLException, ClassNotFoundException;
}
