/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom;

import boardingPlaceManager.dao.SuperDAO;
import boardingPlaceManager.dto.BoadereDTO;

/**
 *
 * @author User
 */
public interface BoadereDAO extends SuperDAO<BoadereDTO> {
    public BoadereDTO SearchByName(String Name) throws Exception;

}
