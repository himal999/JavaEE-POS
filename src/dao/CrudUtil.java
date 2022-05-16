package dao;/*
author :Himal
version : 0.0.1
*/

import db.Db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {

    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = Db.db().getConnection().prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pst.setObject(i + 1, args[i]);
        }
        return pst;
    }

    public static boolean executeUpdate(String sql, Object... args) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = getPreparedStatement(sql, args);
        return pst.executeUpdate() > 0;
    }

    public static ResultSet executeQuery(String sql, Object... args) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = getPreparedStatement(sql, args);
        return pst.executeQuery();
    }
}
