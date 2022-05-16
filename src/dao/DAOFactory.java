package dao;/*
author :Himal
version : 0.0.1
*/

import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.PlaceOrderDAOImpl;


public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return daoFactory==null? daoFactory = new DAOFactory() : daoFactory;
    }
    public  enum  DAOTypes{
        ITEM,CUSTOMER,ORDER
    }

    public  CrudDAO  getDAO(DAOTypes types){
        switch (types){
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new PlaceOrderDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            default:
                return null;
        }
    }
}
