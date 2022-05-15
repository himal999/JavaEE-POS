package controller;/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.Order;
import model.OrderDetail;
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
                Order order = new Order(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getString(4),rst.getDouble(5),rst.getDouble(6));

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
        Order order =  new Order(orderJSON.getString("invoiceNo"),orderJSON.getString("customerId"),Integer.parseInt(orderJSON.getString("noOfItems")),orderJSON.getString("date"),Double.parseDouble(orderJSON.getString("amount")),Double.parseDouble(orderJSON.getString("subAmount")),orderJSON.getJsonArray("orderDetails"));


        Connection connection = null;
        try {
            connection = Db.db().getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pst = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?,?,?,?)");
            pst.setString(1,order.getOrderId());
            pst.setString(2,order.getOrderCustomerId());
            pst.setInt(3,order.getOrderNoOfItems());
            pst.setString(4,order.getOrderDate());
            pst.setDouble(5,order.getOrderAmount());
            pst.setDouble(6,order.getOrderDiscountAmount());

            if(pst.executeUpdate()>0){

                for (JsonValue temp:order.getOrderItems()) {

                    OrderDetail orderDetail = new OrderDetail(order.getOrderId(),temp.asJsonObject().getString("itemId"),temp.asJsonObject().getString("itemName"),Integer.parseInt(temp.asJsonObject().getString("qty")));
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO `order_details` VALUES (?,?,?,?)");
                    ps.setString(1,orderDetail.getOrderId());
                    ps.setString(2,orderDetail.getItemId());
                    ps.setString(3,orderDetail.getItemName());
                    ps.setInt(4,orderDetail.getItemQty());

                    if(ps.executeUpdate()>0){

                    }else{
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return;
                    }
                }
                connection.commit();
                connection.setAutoCommit(true);
                return;

            }else{
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {

            try {

                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }






    }
}
