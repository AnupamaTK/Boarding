/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.RoomRentingHouseDAO;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dto.RoomRentingHouseDTO;
import boardingPlaceManager.dto.PropertyDTO;

/**
 *
 * @author User
 */
public class RoomRentingHouseController {

    public static RoomRentingHouseDAO roomRentingHouseDAO = (RoomRentingHouseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM_RENTING_HOUSE);
    //public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static boolean addRoomRentingHouse(RoomRentingHouseDTO roomRentingHouse, PropertyDTO property) throws Exception {
        //PropertyDTO propertyDto=new PropertyDTO(roomRentingHouse.getProperty_id(),true);
        //boolean res = propertyDAO.add(property);
        boolean result = roomRentingHouseDAO.add(roomRentingHouse);
        return result;
    }

    public static boolean deleteRoomRentingHouse(RoomRentingHouseDTO roomRentingHouse) throws Exception {
        boolean result = roomRentingHouseDAO.delete(roomRentingHouse);
        return result;
    }

    public static boolean updateRoomRentingHouse(RoomRentingHouseDTO roomRentingHouse, PropertyDTO property) throws Exception {
        boolean result = roomRentingHouseDAO.update(roomRentingHouse);
        // if (result == true) {
        // result = propertyDAO.update(property);
        //  }
        return result;
    }

    public static RoomRentingHouseDTO searchRoomRentingHouse(RoomRentingHouseDTO roomRentingHouse) throws Exception {
        RoomRentingHouseDTO searchedRoomRentingHouse = roomRentingHouseDAO.search(roomRentingHouse);
        return searchedRoomRentingHouse;
    }

    public static ArrayList<RoomRentingHouseDTO> getAllRoomRentingHouses() throws Exception {
        return roomRentingHouseDAO.getAll();
    }

    
}
