package controller;
/*
author :Himal
version : 0.0.1
*/

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.CustomerDTO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/customer")
public class CustomerControllerServlet extends HttpServlet {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            resp.setContentType("application/json");

            resp.getWriter().print(customerDAO.getAllCustomers());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            CustomerDTO customer = new CustomerDTO(req.getParameter("txtCustomerAddId"), req.getParameter("txtCustomerAddName"), req.getParameter("txtCustomerAddAddress"), Integer.parseInt(req.getParameter("txtCustomerAddTel")));

            if (customerDAO.addCustomer(customer)) {

            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

        try {
            JsonObject customerJson = Json.createReader(req.getReader()).readObject();
            CustomerDTO customer = new CustomerDTO(customerJson.getString("id"), customerJson.getString("name"), customerJson.getString("address"), Integer.parseInt(customerJson.getString("tel")));

            if (customerDAO.updateCustomer(customer)) {

            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        try {

            if (customerDAO.deleteCustomer(req.getParameter("customerId"))) {

            } else {

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
