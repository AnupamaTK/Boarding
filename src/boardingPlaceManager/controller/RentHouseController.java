/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.RentHouseDAO;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dto.RentHouseDTO;
import boardingPlaceManager.dto.PropertyDTO;

/**
 *
 * @author User
 */
public class RentHouseController {

    public static RentHouseDAO rentHouseDAO = (RentHouseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENT_HOUSE);
    public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static boolean addRentHouse(RentHouseDTO rentHouse) throws Exception {
        PropertyDTO propertyDto=new PropertyDTO(rentHouse.getProperty_id(),true);
        boolean res=propertyDAO.add(propertyDto);
        boolean result = rentHouseDAO.add(rentHouse);
        return result;
    }

    public static boolean deleteRentHouse(RentHouseDTO rentHouse) throws Exception {
        boolean result = rentHouseDAO.delete(rentHouse);
        return result;
    }

    public static boolean updateRentHouse(RentHouseDTO rentHouse) throws Exception {
        boolean result = rentHouseDAO.update(rentHouse);
        return result;
    }

    public static RentHouseDTO searchRentHouse(RentHouseDTO rentHouse) throws Exception {
        RentHouseDTO searchedRentHouse = rentHouseDAO.search(rentHouse);
        return searchedRentHouse;
    }

    public static ArrayList<RentHouseDTO> getAllRentHouses() throws Exception {
        return rentHouseDAO.getAll();
    }
    
    public static RentHouseDTO searchByAddress(String address) throws Exception {
        RentHouseDTO searchedRentHouse = rentHouseDAO.searchByAddress(address);
        return searchedRentHouse;
    }
}
