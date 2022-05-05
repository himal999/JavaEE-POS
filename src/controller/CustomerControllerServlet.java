package controller;
/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.Customer;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/customer")
public class CustomerControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try {
            Connection connection = Db.db().getConnection();
            ResultSet rst = connection.prepareStatement("SELECT * FROM `customer`").executeQuery();
            Customer customer = null;
            JsonArrayBuilder customerArray = Json.createArrayBuilder();
            JsonObjectBuilder customerJSON = Json.createObjectBuilder();
            while (rst.next()){
                customer = new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4));
                customerJSON.add("id",customer.getNic());
                customerJSON.add("name",customer.getName());
                customerJSON.add("address",customer.getAddress());
                customerJSON.add("tel",customer.getTel());
                customerArray.add(customerJSON.build());
            }

            PrintWriter writer = resp.getWriter();
            writer.print(customerArray.build());



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
