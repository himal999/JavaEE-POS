package dao;/*
author :Himal
version : 0.0.1
*/



import javax.json.JsonArray;
import java.sql.SQLException;

public interface CrudDAO<T,ID> {
    JsonArray getAll() throws SQLException, ClassNotFoundException;
    boolean add(T t) throws SQLException, ClassNotFoundException;
    boolean update(T t) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;
}
