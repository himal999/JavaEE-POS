package controller;/*
author :Himal
version : 0.0.1
*/

import bo.BOFactory;
import bo.custom.PlaceOrderBO;
import dao.CrudDAO;
import dao.DAOFactory;
import dto.OrderDTO;
import entity.Order;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/place_order")
public class PlaceOrderServlet extends HttpServlet  {
    CrudDAO<Order,String> placeOrderDAO =  DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    PlaceOrderBO placeOrderController = BOFactory.getBoFactory().getBo(BOFactory.BOTypes.ORDER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
        try {
            placeOrderDAO.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JsonObject orderJSON = Json.createReader(req.getReader()).readObject();
        OrderDTO order = new OrderDTO(orderJSON.getString("invoiceNo"), orderJSON.getString("customerId"), Integer.parseInt(orderJSON.getString("noOfItems")), orderJSON.getString("date"), Double.parseDouble(orderJSON.getString("amount")), Double.parseDouble(orderJSON.getString("subAmount")), orderJSON.getJsonArray("orderDetails"));

        try {
            if (placeOrderController.addOrder(order)) {

            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
