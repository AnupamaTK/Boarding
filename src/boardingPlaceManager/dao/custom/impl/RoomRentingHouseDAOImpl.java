/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import boardingPlaceManager.dao.custom.RentHouseDAO;
import boardingPlaceManager.dao.custom.RoomRentingHouseDAO;
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.RoomRentingHouseDTO;
import boardingPlaceManager.dao.custom.impl.PropertyDAOImpl;
import boardingPlaceManager.dto.RentHouseDTO;

//*
// *
// * @author User
// 
public class RoomRentingHouseDAOImpl implements RoomRentingHouseDAO {

    @Override
    public boolean add(RoomRentingHouseDTO room_renting_house) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO room_renting_house VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, room_renting_house.getProperty_id());
        pstm.setObject(2, room_renting_house.getNo_of_rooms());
        pstm.setObject(3, room_renting_house.getNo_of_common_bathrooms());
        pstm.setObject(4, room_renting_house.getNo_of_story());
        pstm.setObject(5, room_renting_house.getAddress());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(RoomRentingHouseDTO room_renting_house) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE room_renting_house SET no_of_rooms=?,no_of_common_bathrooms=?,no_of_story=?,address=? where property_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, room_renting_house.getNo_of_rooms());
        pstm.setObject(2, room_renting_house.getNo_of_common_bathrooms());
        pstm.setObject(3, room_renting_house.getNo_of_story());
        pstm.setObject(4, room_renting_house.getAddress());
        pstm.setObject(5, room_renting_house.getProperty_id());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(RoomRentingHouseDTO room_renting_house) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM room_renting_house WHERE property_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, room_renting_house.getProperty_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public RoomRentingHouseDTO search(RoomRentingHouseDTO room_renting_house) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM room_renting_house WHERE property_id='" + room_renting_house.getProperty_id() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new RoomRentingHouseDTO(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getString(5)
            );
        }

        return null;
    }

    @Override

//     *
//     * @return
//     * @throws Exception
    public ArrayList<RoomRentingHouseDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM room_renting_house";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<RoomRentingHouseDTO> alRentHouses = null;
        while (rst.next()) {
            if (alRentHouses == null) {
                alRentHouses = new ArrayList<>();
            }

            alRentHouses.add(new RoomRentingHouseDTO(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getString(5)
            ));

        }

        return alRentHouses;
    }

//    @Override
//    public RoomRentingHouseDTO searchByAddress(String address) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM room_renting_house WHERE address='" + address + "'";
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//
//        if (rst.next()) {
//            return new RoomRentingHouseDTO(
//                    rst.getString(1),
//                    rst.getInt(2),
//                    rst.getInt(3),
//                    rst.getInt(4),
//                    rst.getString(5)
//            );
//        }
//
//        return null;
//    }

//    @Override
//    public ArrayList<RoomRentingHouseDTO> searchAvailable() throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM room_renting_house inner join property on room_renting_house.property_id=property.property_id where availability=1";
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//
//        ArrayList<RoomRentingHouseDTO> alRentHouses = null;
//        while (rst.next()) {
//            if (alRentHouses == null) {
//                alRentHouses = new ArrayList<>();
//            }
//
//            alRentHouses.add(new RoomRentingHouseDTO(
//                    rst.getString(1),
//                    rst.getInt(2),
//                    rst.getInt(3),
//                    rst.getInt(4),
//                    rst.getString(5)
//            ));
//
//        }
//
//        return alRentHouses;
//    }
//     @Override
//    public ArrayList<RoomRentingHouseDTO> searchRented() throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM room_renting_house inner join property on room_renting_house.property_id=property.property_id where availability=0";
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//
//        ArrayList<RoomRentingHouseDTO> alRentHouses = null;
//        while (rst.next()) {
//            if (alRentHouses == null) {
//                alRentHouses = new ArrayList<>();
//            }
//
//            alRentHouses.add(new RoomRentingHouseDTO(
//                    rst.getString(1),
//                    rst.getInt(2),
//                    rst.getInt(3),
//                    rst.getInt(4),
//                    rst.getString(5)
//            ));
//
//        }
//
//        return alRentHouses;
//    }


}
