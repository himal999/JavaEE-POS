package controller;/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.Order;

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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/place_order")
public class PlaceOrderControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        JsonArrayBuilder orderArray = Json.createArrayBuilder();
        JsonObjectBuilder orderJSON = Json.createObjectBuilder();
        try {
            ResultSet rst = Db.db().getConnection().prepareStatement("SELECT * FROM `order`").executeQuery();
            while (rst.next()){
                Order order = new Order(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDate(4),rst.getDouble(5),rst.getDouble(6));

                orderJSON.add("orderId",order.getOrderId());
                orderJSON.add("orderCustomerId",order.getOrderCustomerId());
                orderJSON.add("orderNoOfItems",order.getOrderNoOfItems());
                orderJSON.add("orderDate", String.valueOf(order.getOrderDate()));
                orderJSON.add("orderAmount",order.getOrderAmount());
                orderJSON.add("orderDiscountAmount",order.getOrderDiscountAmount());

                orderArray.add(orderJSON.build());
            }
            PrintWriter writer = resp.getWriter();
            writer.print(orderArray.build());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
