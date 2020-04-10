/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao;


import boardingPlaceManager.dao.custom.impl.RentHouseDAOImpl;
import boardingPlaceManager.dao.custom.impl.UserDAOImpl;
import boardingPlaceManager.dao.custom.impl.PropertyDAOImpl;
import boardingPlaceManager.dao.custom.impl.RentRoomDAOImpl;

/**
 *
 * @author User
 */
public class DAOFactory {

    public enum DAOTypes {

        USER,RENT_HOUSE,PROPERTY,RENT_ROOM
    }

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoType) {
        //System.out.println(daoType+"DT");
        switch (daoType) {
            
            case USER:
                return new UserDAOImpl();
            case RENT_HOUSE:
                return new RentHouseDAOImpl(); 
            case PROPERTY:
                return new PropertyDAOImpl();
            case RENT_ROOM:
                return new RentRoomDAOImpl();
                
            default:
                return null;
        }
    }
}
