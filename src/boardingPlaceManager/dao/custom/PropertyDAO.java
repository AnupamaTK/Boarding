/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom;

import boardingPlaceManager.dao.SuperDAO;
import boardingPlaceManager.dto.PropertyDTO;

/**
 *
 * @author Property
 */
public interface PropertyDAO extends SuperDAO<PropertyDTO>{
   public boolean CheckAvilability(String property) throws Exception;
   public boolean changeAvailability(String property_id,Boolean value)throws Exception;
}
