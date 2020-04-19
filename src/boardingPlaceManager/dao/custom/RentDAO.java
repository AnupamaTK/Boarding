/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom;

import boardingPlaceManager.dao.SuperDAO;
import boardingPlaceManager.dto.RentDTO;
import java.util.ArrayList;

/**
 *
 * @author Rent
 */
public interface RentDAO extends SuperDAO<RentDTO> {

    public ArrayList<RentDTO> searchPastRents(String Property_id) throws Exception;

    public ArrayList<RentDTO> searchCurrentRents(String Property_id) throws Exception;

    public ArrayList<RentDTO> searchFutureRents(String Property_id) throws Exception;

    public ArrayList<RentDTO> searchByPropertyId(String Property_id) throws Exception;

}
