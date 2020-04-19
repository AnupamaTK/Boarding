/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.RentDAO;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dto.RentDTO;
import boardingPlaceManager.dto.RentDTO;

/**
 *
 * @author User
 */
public class RentController {

    public static RentDAO rentDAO = (RentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENT);
    public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static boolean addRent(RentDTO rent) throws Exception {
        boolean result = rentDAO.add(rent);
        if (result == true) {
            propertyDAO.changeAvailability(rent.getProperty_id(), false);
        }
        return result;
    }

    public static boolean deleteRent(RentDTO rent) throws Exception {
        boolean result = rentDAO.delete(rent);
        return result;
    }

    public static boolean updateRent(RentDTO rent) throws Exception {
        boolean result = rentDAO.update(rent);
        return result;
    }

    public static RentDTO searchRent(RentDTO rent) throws Exception {
        RentDTO searchedRent = rentDAO.search(rent);
        return searchedRent;
    }

    public static ArrayList<RentDTO> getAllRents() throws Exception {
        return rentDAO.getAll();
    }

    public static ArrayList<RentDTO> searchRent(String property_id, Integer type) throws Exception {

        ArrayList<RentDTO> searchedRent = null;
        if (type == 0) {
            searchedRent = rentDAO.searchByPropertyId(property_id);
        } else if (type == 1) {
            searchedRent = rentDAO.searchPastRents(property_id);
        } else if (type == 2) {
            searchedRent = rentDAO.searchCurrentRents(property_id);
        } else if (type == 3) {
            searchedRent = rentDAO.searchFutureRents(property_id);
        }
        return searchedRent;
    }

}
