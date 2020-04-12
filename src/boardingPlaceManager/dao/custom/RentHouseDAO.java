/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom;

import boardingPlaceManager.dao.SuperDAO;
import boardingPlaceManager.dto.UserDTO;
import boardingPlaceManager.dto.RentHouseDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface RentHouseDAO extends SuperDAO<RentHouseDTO>{
    //public boolean CheckPassword(String name, String password) throws Exception;
    public RentHouseDTO searchByAddress(String Address) throws Exception;
    public ArrayList<RentHouseDTO> searchAvailable() throws Exception;
    public ArrayList<RentHouseDTO> searchRented() throws Exception;
}
