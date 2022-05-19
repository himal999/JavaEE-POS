package controller;/*
author :Himal
version : 0.0.1
*/

import dao.CrudDAO;
import dao.DAOFactory;
import dao.custom.impl.ItemDAOImpl;
import dto.ItemDTO;
import entity.Item;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    CrudDAO<Item, String> itemDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            resp.setContentType("application/json");

            resp.getWriter().print(itemDAO.getAll());
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
            Item item = new Item(req.getParameter("txtItemAddId"), req.getParameter("txtItemAddName"), Double.parseDouble(req.getParameter("txtItemAddUnitPrice")), Integer.parseInt(req.getParameter("txtItemAddStock")));

            if (itemDAO.add(item)) {

            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {

            JsonObject itemJson = Json.createReader(req.getReader()).readObject();
            Item item = new Item(itemJson.getString("itemCode"), itemJson.getString("itemName"), Double.parseDouble(itemJson.getString("itemUnitPrice")), Integer.parseInt(itemJson.getString("itemStock")));

            if (itemDAO.update(item)) {

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

            if (itemDAO.delete(req.getParameter("itemCode"))) {

            } else {

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    }
}
