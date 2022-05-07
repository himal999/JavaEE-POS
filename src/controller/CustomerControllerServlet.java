package controller;
/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.Customer;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject customerJson = Json.createReader(req.getReader()).readObject();
        Customer customer = new Customer(customerJson.getString("id"),customerJson.getString("name"),customerJson.getString("address"),Integer.parseInt(customerJson.getString("tel")));

        try {
            PreparedStatement pst = Db.db().getConnection().prepareStatement("UPDATE `customer` SET name=?,address=?,tel=? WHERE nic=?");
            pst.setString(1,customer.getName());
            pst.setString(2,customer.getAddress());
            pst.setInt(3,customer.getTel());
            pst.setString(4,customer.getNic());

            PrintWriter writer = resp.getWriter();


            if(pst.executeUpdate()>0){
                writer.write("updated customer");
            }else{
                writer.write("try again");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
