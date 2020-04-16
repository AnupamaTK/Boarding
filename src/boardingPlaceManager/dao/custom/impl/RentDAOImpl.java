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
import boardingPlaceManager.dao.custom.RentDAO;
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.RentDTO;

//*
// *
// * @author User
// 
public class RentDAOImpl implements RentDAO {

    @Override
    public boolean add(RentDTO rent) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO rent VALUES (?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, rent.getRent_id());
        pstm.setObject(2, rent.getAvailability());
        pstm.setObject(3, rent.getAdvance_fee());
        pstm.setObject(4, rent.getMonthly_Rent());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(RentDTO rent) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE rent SET availability=?,advance_fee=?,monthly_Rent=? where rent_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, rent.getAvailability());
        pstm.setObject(2, rent.getAdvance_fee());
        pstm.setObject(3, rent.getMonthly_Rent());
        pstm.setObject(4, rent.getRent_id());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(RentDTO rent) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM rent WHERE rent_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, rent.getRent_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public RentDTO search(RentDTO rent) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent WHERE rent_id='" + rent.getRent_id() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new RentDTO(
                    rst.getString(1),
                    rst.getBoolean(2),
                    rst.getDouble(3),
                    rst.getDouble(4)
            );
        }

        return null;
    }

    @Override

//     *
//     * @return
//     * @throws Exception
    public ArrayList<RentDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM rent";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<RentDTO> alRents = null;
        while (rst.next()) {
            if (alRents == null) {
                alRents = new ArrayList<>();
            }

            alRents.add(new RentDTO(
                    rst.getString(1),
                    rst.getBoolean(2),
                    rst.getDouble(3),
                    rst.getDouble(4)
            ));

        }

        return alRents;
    }

    @Override
    public boolean CheckAvilability(String rentId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT availability FROM rent WHERE rent_id='" + rentId + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Boolean val = null;
        if (rst.next()) {
            val = rst.getBoolean(1);
        }
        return val;

    }

}
