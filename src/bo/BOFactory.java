package bo;/*
author :Himal
version : 0.0.1
*/

import bo.custom.PlaceOrderBO;
import bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public enum BOTypes{
        ORDER
    }

    public static  BOFactory getBoFactory(){
        return boFactory==null? boFactory = new BOFactory() :boFactory;
    }

    public PlaceOrderBO getBo(BOTypes types){
        switch (types){
            case ORDER:return new PlaceOrderBOImpl();
            default:return null;
        }
    }
}
