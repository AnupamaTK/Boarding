/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.BoadereDAO;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dto.BoadereDTO;
import boardingPlaceManager.dto.PropertyDTO;

/**
 *
 * @author User
 */
public class BoadereController {

    public static BoadereDAO boadereDAO = (BoadereDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENT_HOUSE);
    public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static boolean addBoadere(BoadereDTO boadere, PropertyDTO property) throws Exception {
        //PropertyDTO propertyDto=new PropertyDTO(boadere.getProperty_id(),true);
        boolean res = propertyDAO.add(property);
        boolean result = boadereDAO.add(boadere);
        return result;
    }

    public static boolean deleteBoadere(BoadereDTO boadere) throws Exception {
        boolean result = boadereDAO.delete(boadere);
        return result;
    }

    public static boolean updateBoadere(BoadereDTO boadere, PropertyDTO property) throws Exception {
        boolean result = boadereDAO.update(boadere);
        if (result == true) {
            result = propertyDAO.update(property);
        }
        return result;
    }

    public static BoadereDTO searchBoadere(BoadereDTO boadere) throws Exception {
        BoadereDTO searchedBoadere = boadereDAO.search(boadere);
        return searchedBoadere;
    }

    public static ArrayList<BoadereDTO> getAllBoaderes() throws Exception {
        return boadereDAO.getAll();
    }

//    public static BoadereDTO searchByAddress(String address) throws Exception {
//        BoadereDTO searchedBoadere = boadereDAO.searchByAddress(address);
//        return searchedBoadere;
//    }
//
//    public static ArrayList<BoadereDTO> searchAvailable() throws Exception {
//        ArrayList<BoadereDTO> availableBoaderes = boadereDAO.searchAvailable();
//        return availableBoaderes;
//    }
//
//    public static ArrayList<BoadereDTO> searchRented() throws Exception {
//        ArrayList<BoadereDTO> availableBoaderes = boadereDAO.searchRented();
//        return availableBoaderes;
//    }

}
