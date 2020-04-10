/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom;

import boardingPlaceManager.dao.SuperDAO;
import boardingPlaceManager.dto.UserDTO;
import boardingPlaceManager.dto.SharingRoomDTO;

/**
 *
 * @author User
 */
public interface SharingRoomDAO extends SuperDAO<SharingRoomDTO> {

    public SharingRoomDTO searchByAddress(String Address) throws Exception;
}
