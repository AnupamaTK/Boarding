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
import boardingPlaceManager.dao.custom.RentRoomDAO;
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.RentRoomDTO;
import boardingPlaceManager.dao.custom.impl.PropertyDAOImpl;

//*
// *
// * @author User
// 
public class RentRoomDAOImpl implements RentRoomDAO {

    @Override
    public boolean add(RentRoomDTO rent_room) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO rent_room VALUES (?,?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, rent_room.getProperty_id());
        pstm.setObject(2, rent_room.getHouse_id());
        pstm.setObject(3, rent_room.getRoom_no());
        pstm.setObject(4, rent_room.getPeople_per_room());
        pstm.setObject(5, rent_room.getAttached_bathroom());
        pstm.setObject(6, rent_room.getOther_details());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(RentRoomDTO rent_room) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE rent_room SET house_id=?,room_no=?,people_per_room=?,attached_bathroom=?,other_details=? where property_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, rent_room.getHouse_id());
        pstm.setObject(2, rent_room.getRoom_no());
        pstm.setObject(3, rent_room.getPeople_per_room());
        pstm.setObject(4, rent_room.getAttached_bathroom());
        pstm.setObject(5, rent_room.getOther_details());
        pstm.setObject(6, rent_room.getProperty_id());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(RentRoomDTO rent_room) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM rent_room WHERE property_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, rent_room.getProperty_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public RentRoomDTO search(RentRoomDTO rent_room) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_room WHERE property_id='" + rent_room.getProperty_id() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new RentRoomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getBoolean(5),
                    rst.getString(6)
            );
        }

        return null;
    }

    @Override

//     *
//     * @return
//     * @throws Exception
    public ArrayList<RentRoomDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_room";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<RentRoomDTO> alRentRooms = null;
        while (rst.next()) {
            if (alRentRooms == null) {
                alRentRooms = new ArrayList<>();
            }

            alRentRooms.add(new RentRoomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getBoolean(5),
                    rst.getString(6)
            ));

        }

        return alRentRooms;
    }

    @Override
    public RentRoomDTO searchByAddress(String address) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_room WHERE address='" + address + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new RentRoomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getBoolean(5),
                    rst.getString(6)
            );
        }

        return null;
    }

}
