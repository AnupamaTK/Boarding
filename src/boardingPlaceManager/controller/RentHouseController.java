/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.RentHouseDAO;
import boardingPlaceManager.dto.RentHouseDTO;

/**
 *
 * @author User
 */
public class RentHouseController {
     public static RentHouseDAO customerDAO = (RentHouseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENT_HOUSE);
    
    public static boolean addRentHouse(RentHouseDTO customer) throws  Exception  {
        boolean result = customerDAO.add(customer);
        return result;
    }
    
    public static boolean deleteRentHouse(RentHouseDTO customer)throws Exception{
        boolean result = customerDAO.delete(customer);
        return result;
    }
    
    public static boolean updateRentHouse(RentHouseDTO customer)throws Exception{
        boolean result = customerDAO.update(customer);
        return result;
    }
    
    public static RentHouseDTO searchRentHouse(RentHouseDTO customer) throws Exception{
        RentHouseDTO searchedRentHouse = customerDAO.search(customer);
        return searchedRentHouse;
    }
    
    public static ArrayList<RentHouseDTO> getAllRentHouses()throws Exception{
        return customerDAO.getAll();
    }
}
