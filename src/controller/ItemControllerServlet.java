package controller;/*
author :Himal
version : 0.0.1
*/

import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.ItemDTO;
import javax.json.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemControllerServlet extends HttpServlet {
    ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            resp.setContentType("application/json");

            resp.getWriter().print(itemDAO.getAllItems());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ItemDTO item = new ItemDTO(req.getParameter("txtItemAddId"), req.getParameter("txtItemAddName"), Double.parseDouble(req.getParameter("txtItemAddUnitPrice")), Integer.parseInt(req.getParameter("txtItemAddStock")));

            if (itemDAO.addItem(item)) {

            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        try {
            JsonObject itemJson = Json.createReader(req.getReader()).readObject();
            ItemDTO item = new ItemDTO(itemJson.getString("itemCode"), itemJson.getString("itemName"), Double.parseDouble(itemJson.getString("itemUnitPrice")), Integer.parseInt(itemJson.getString("itemStock")));

            if (itemDAO.updateItem(item)) {

            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {

            if (itemDAO.deleteItem(req.getParameter("itemCode"))) {

            } else {

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    }
}
