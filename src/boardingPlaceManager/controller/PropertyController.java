/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import static boardingPlaceManager.controller.PropertyController.propertyDAO;
import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dto.PropertyDTO;
import boardingPlaceManager.dto.PropertyDTO;

/**
 *
 * @author User
 */
public class PropertyController {

    public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static Boolean checkAvailability(String propertyId) throws Exception {
        Boolean availability = propertyDAO.CheckAvilability(propertyId);
        return availability;
    }
    
    public static PropertyDTO searchProperty(PropertyDTO property) throws Exception {
        PropertyDTO searchedProperty = propertyDAO.search(property);
        return searchedProperty;
    }

}
