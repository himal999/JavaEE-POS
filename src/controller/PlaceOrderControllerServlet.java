package controller;/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.OrderDTO;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


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
                OrderDTO order = new OrderDTO(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getString(4),rst.getDouble(5),rst.getDouble(6));

                orderJSON.add("orderId",order.getOrderId());
                orderJSON.add("orderCustomerId",order.getOrderCustomerId());
                orderJSON.add("orderNoOfItems",order.getOrderNoOfItems());
                orderJSON.add("orderDate", order.getOrderDate());
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject orderJSON= Json.createReader(req.getReader()).readObject();
        OrderDTO order =  new OrderDTO(orderJSON.getString("invoiceNo"),orderJSON.getString("customerId"),Integer.parseInt(orderJSON.getString("noOfItems")),orderJSON.getString("date"),Double.parseDouble(orderJSON.getString("amount")),Double.parseDouble(orderJSON.getString("subAmount")),orderJSON.getJsonArray("orderDetails"));

        PlaceOrderController placeOrderController = new PlaceOrderController();

        try {
            if(placeOrderController.addOrder(order)){

            }else{

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
