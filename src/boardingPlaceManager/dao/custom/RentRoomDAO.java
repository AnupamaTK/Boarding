/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom;

import boardingPlaceManager.dao.SuperDAO;
import boardingPlaceManager.dto.UserDTO;
import boardingPlaceManager.dto.RentRoomDTO;

/**
 *
 * @author User
 */
public interface RentRoomDAO extends SuperDAO<RentRoomDTO> {

    public RentRoomDTO searchByAddress(String Address) throws Exception;
}
