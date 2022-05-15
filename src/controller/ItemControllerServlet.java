package controller;/*
author :Himal
version : 0.0.1
*/

import db.Db;
import model.ItemDTO;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.setContentType("application/json");
            ItemDTO item ;
            JsonArrayBuilder itemArray = Json.createArrayBuilder();
            JsonObjectBuilder itemJSON = Json.createObjectBuilder();

            ResultSet  rst = Db.db().getConnection().prepareStatement("SELECT * FROM `item`").executeQuery();
            while (rst.next()){
                item = new ItemDTO(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getInt(4));
                itemJSON.add("itemCode",item.getItemCode());
                itemJSON.add("itemName",item.getItemName());
                itemJSON.add("itemUnitPrice",item.getItemUnitPrice());
                itemJSON.add("itemStock",item.getItemStock());
                itemArray.add(itemJSON.build());

            }
            PrintWriter writer = resp.getWriter();
            writer.print(itemArray.build());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDTO item = new ItemDTO(req.getParameter("txtItemAddId"),req.getParameter("txtItemAddName"),Double.parseDouble(req.getParameter("txtItemAddUnitPrice")),Integer.parseInt(req.getParameter("txtItemAddStock")));


        try {
            PreparedStatement pst = Db.db().getConnection().prepareStatement("INSERT INTO `item` VALUES (?,?,?,?)");
            pst.setString(1,item.getItemCode());
            pst.setString(2,item.getItemName());
            pst.setDouble(3,item.getItemUnitPrice());
            pst.setInt(4,item.getItemStock());

            if(pst.executeUpdate()>0){

            }else{

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        JsonObject itemJson = Json.createReader(req.getReader()).readObject();

        ItemDTO item = new ItemDTO( itemJson.getString("itemCode"),itemJson.getString("itemName"),Double.parseDouble(itemJson.getString("itemUnitPrice")),Integer.parseInt(itemJson.getString("itemStock")));




        try {

            PreparedStatement pst = Db.db().getConnection().prepareStatement("UPDATE `item` SET `itemname`=?,`unitprice`=?,`itemstock`=? WHERE itemcode=?");
            pst.setString(1,item.getItemName());
            pst.setDouble(2,item.getItemUnitPrice());
            pst.setInt(3,item.getItemStock());
            pst.setString(4,item.getItemCode());

            PrintWriter writer = resp.getWriter();
            if(pst.executeUpdate()>0){
                 writer.write("Success");
            }else{
                writer.write("try");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PreparedStatement pst = Db.db().getConnection().prepareStatement("DELETE FROM `item` WHERE itemCode=?");
            pst.setString(1,req.getParameter("itemCode"));

            PrintWriter writer = resp.getWriter();


            if(pst.executeUpdate()>0){
                writer.write("success");
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
