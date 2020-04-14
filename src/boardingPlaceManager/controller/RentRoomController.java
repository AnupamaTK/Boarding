/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.RentRoomDAO;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dto.RentRoomDTO;
import boardingPlaceManager.dto.PropertyDTO;

/**
 *
 * @author User
 */
public class RentRoomController {

    public static RentRoomDAO rentRoomDAO = (RentRoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENT_ROOM);
    public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static boolean addRentRoom(RentRoomDTO rentRoom) throws Exception {
        PropertyDTO propertyDto = new PropertyDTO(rentRoom.getProperty_id(), true,0.0,0.0);
        boolean res = propertyDAO.add(propertyDto);
        boolean result = rentRoomDAO.add(rentRoom);
        return result;
    }

    public static boolean deleteRentRoom(RentRoomDTO rentRoom) throws Exception {
        boolean result = rentRoomDAO.delete(rentRoom);
        return result;
    }

    public static boolean updateRentRoom(RentRoomDTO rentRoom) throws Exception {
        boolean result = rentRoomDAO.update(rentRoom);
        return result;
    }

    public static RentRoomDTO searchRentRoom(RentRoomDTO rentRoom) throws Exception {
        RentRoomDTO searchedRentRoom = rentRoomDAO.search(rentRoom);
        return searchedRentRoom;
    }

    public static ArrayList<RentRoomDTO> getAllRentRooms() throws Exception {
        return rentRoomDAO.getAll();
    }

    public static RentRoomDTO searchByAddress(String address) throws Exception {
        RentRoomDTO searchedRentRoom = rentRoomDAO.searchByAddress(address);
        return searchedRentRoom;
    }
}
