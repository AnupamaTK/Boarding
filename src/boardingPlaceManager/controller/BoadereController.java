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

    public static BoadereDAO boadereDAO = (BoadereDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOADERE);
    //public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static boolean addBoadere(BoadereDTO boadere, PropertyDTO property) throws Exception {
        //PropertyDTO propertyDto=new PropertyDTO(boadere.getProperty_id(),true);
        //boolean res = propertyDAO.add(property);
        boolean result = boadereDAO.add(boadere);
        return result;
    }

    public static boolean deleteBoadere(BoadereDTO boadere) throws Exception {
        boolean result = boadereDAO.delete(boadere);
        return result;
    }

    public static boolean updateBoadere(BoadereDTO boadere) throws Exception {
        boolean result = boadereDAO.update(boadere);
        return result;
    }

    public static BoadereDTO searchBoadere(BoadereDTO boadere) throws Exception {
        BoadereDTO searchedBoadere = boadereDAO.SearchByName(boadere.getName());
        return searchedBoadere;
    }

    public static ArrayList<BoadereDTO> getAllBoaderes() throws Exception {
        return boadereDAO.getAll();
    }

}
