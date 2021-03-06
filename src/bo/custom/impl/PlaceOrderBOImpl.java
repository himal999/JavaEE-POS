package bo.custom.impl;/*
author :Himal
version : 0.0.1
*/

import bo.custom.PlaceOrderBO;
import db.Db;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import javax.json.JsonValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    Connection connection = null;
    PreparedStatement pst = null;

    public boolean addOrder(OrderDTO order) throws SQLException {
        try {
            connection = Db.db().getConnection();
            connection.setAutoCommit(false);
            pst = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?,?,?,?)");
            pst.setString(1, order.getOrderId());
            pst.setString(2, order.getOrderCustomerId());
            pst.setInt(3, order.getOrderNoOfItems());
            pst.setString(4, order.getOrderDate());
            pst.setDouble(5, order.getOrderAmount());
            pst.setDouble(6, order.getOrderDiscountAmount());

            if (pst.executeUpdate() > 0) {
                if (addOrderDetail(order)) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                } else {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        return false;

    }

    public boolean addOrderDetail(OrderDTO order) {
        for (JsonValue temp : order.getOrderItems()) {
            OrderDetailDTO orderDetail = new OrderDetailDTO(order.getOrderId(), temp.asJsonObject().getString("itemId"), temp.asJsonObject().getString("itemName"), Integer.parseInt(temp.asJsonObject().getString("qty")));
            try {
                pst = connection.prepareStatement("INSERT INTO `order_details` VALUES (?,?,?,?)");
                pst.setString(1, orderDetail.getOrderId());
                pst.setString(2, orderDetail.getItemId());
                pst.setString(3, orderDetail.getItemName());
                pst.setInt(4, orderDetail.getItemQty());

                if (pst.executeUpdate() > 0) {
                    if (updateItemQty(orderDetail.getItemId(), orderDetail.getItemQty())) {

                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return true;
    }

    public boolean updateItemQty(String itemId, int orderQty) {
        try {
            pst = connection.prepareStatement("SELECT * FROM `item` WHERE `itemcode`=?");
            pst.setString(1, itemId);
            ResultSet rst = pst.executeQuery();
            ItemDTO item = null;
            if (rst.next()) {
                item = new ItemDTO(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getInt(4));
            }

            pst = connection.prepareStatement("UPDATE `item` SET `itemstock`=? WHERE `itemcode`=?");
            int stock = item.getItemStock() - orderQty;
            pst.setInt(1, stock);
            pst.setString(2, itemId);

            return pst.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
