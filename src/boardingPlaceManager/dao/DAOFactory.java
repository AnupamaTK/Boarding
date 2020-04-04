/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao;


import boardingPlaceManager.dao.custom.impl.UserDAOImpl;

/**
 *
 * @author User
 */
public class DAOFactory {

    public enum DAOTypes {

        USER
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
        switch (daoType) {
            
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
