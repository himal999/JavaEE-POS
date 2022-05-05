package db;

/*
author :Himal
version : 0.0.1
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Db {
    static private Db instance;
    private Connection connection;

    private Db() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
    }

    public static Db db() throws SQLException, ClassNotFoundException {
        return  (instance==null) ? instance=new Db() : instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
