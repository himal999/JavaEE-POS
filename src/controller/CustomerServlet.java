package controller;
/*
author :Himal
version : 0.0.1
*/

import dao.CrudDAO;
import dao.DAOFactory;

import dto.CustomerDTO;
import entity.Customer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CrudDAO<Customer,String> customerDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            resp.setContentType("application/json");

            resp.getWriter().print(customerDAO.getAll());
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
            Customer customer = new Customer(req.getParameter("txtCustomerAddId"), req.getParameter("txtCustomerAddName"), req.getParameter("txtCustomerAddAddress"), Integer.parseInt(req.getParameter("txtCustomerAddTel")));
            customerDAO.add(customer);
          /*  if () {

            } else {

            }*/
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
            Customer customer = new Customer(customerJson.getString("id"), customerJson.getString("name"), customerJson.getString("address"), Integer.parseInt(customerJson.getString("tel")));

            if (customerDAO.update(customer)) {

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

            if (customerDAO.delete(req.getParameter("customerId"))) {

            } else {

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
