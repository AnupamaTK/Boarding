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
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.RentHouseDTO;
import boardingPlaceManager.dao.custom.impl.PropertyDAOImpl;

//*
// *
// * @author User
// 
public class RentHouseDAOImpl implements RentHouseDAO {

    @Override
    public boolean add(RentHouseDTO rent_house) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO rent_house VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, rent_house.getProperty_id());
        pstm.setObject(2, rent_house.getNo_of_rooms());
        pstm.setObject(3, rent_house.getNo_of_bathrooms());
        pstm.setObject(4, rent_house.getNo_of_story());
        pstm.setObject(5, rent_house.getAddress());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(RentHouseDTO rent_house) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE rent_house SET no_of_rooms=?,no_of_bathrooms=?,no_of_story=?,address=? where property_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, rent_house.getNo_of_rooms());
        pstm.setObject(2, rent_house.getNo_of_bathrooms());
        pstm.setObject(3, rent_house.getNo_of_story());
        pstm.setObject(4, rent_house.getAddress());
        pstm.setObject(5, rent_house.getProperty_id());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(RentHouseDTO rent_house) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM rent_house WHERE property_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, rent_house.getProperty_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public RentHouseDTO search(RentHouseDTO rent_house) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_house WHERE property_id='" + rent_house.getProperty_id() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new RentHouseDTO(
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
    public ArrayList<RentHouseDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_house";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<RentHouseDTO> alRentHouses = null;
        while (rst.next()) {
            if (alRentHouses == null) {
                alRentHouses = new ArrayList<>();
            }

            alRentHouses.add(new RentHouseDTO(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getString(5)
            ));

        }

        return alRentHouses;
    }

    @Override
    public RentHouseDTO searchByAddress(String address) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_house WHERE address='" + address + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new RentHouseDTO(
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
    public ArrayList<RentHouseDTO> searchAvailable() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_house inner join property on rent_house.property_id=property.property_id where availability=1";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<RentHouseDTO> alRentHouses = null;
        while (rst.next()) {
            if (alRentHouses == null) {
                alRentHouses = new ArrayList<>();
            }

            alRentHouses.add(new RentHouseDTO(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getString(5)
            ));

        }

        return alRentHouses;
    }
     @Override
    public ArrayList<RentHouseDTO> searchRented() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent_house inner join property on rent_house.property_id=property.property_id where availability=0";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<RentHouseDTO> alRentHouses = null;
        while (rst.next()) {
            if (alRentHouses == null) {
                alRentHouses = new ArrayList<>();
            }

            alRentHouses.add(new RentHouseDTO(
                    rst.getString(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getString(5)
            ));

        }

        return alRentHouses;
    }

}
