package bo.custom;/*
author :Himal
version : 0.0.1
*/

import dto.OrderDTO;

import java.sql.SQLException;

public interface PlaceOrderBO {
   boolean addOrder(OrderDTO order) throws SQLException;
   boolean addOrderDetail(OrderDTO order);
   boolean updateItemQty(String itemId,int orderQty);
}
