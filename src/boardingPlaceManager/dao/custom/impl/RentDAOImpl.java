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
        String sql = "INSERT INTO rent VALUES (?,?,?,?.?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, rent.getRent_id());
        pstm.setObject(2, rent.getProperty_id());
        pstm.setObject(3, rent.getBoadere_id());
        pstm.setObject(4, rent.getFrom_date());
        pstm.setObject(5, rent.getTo_date());
        pstm.setObject(6, rent.getAdvance_fee());
        pstm.setObject(7, rent.getMonthly_rent());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(RentDTO rent) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE rent SET property_id=?,boarder_id=?,from_date=?,to_date=?,monthly_fee=?,advance_fee=? where rent_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, rent.getProperty_id());
        pstm.setObject(2, rent.getBoadere_id());
        pstm.setObject(3, rent.getFrom_date());
        pstm.setObject(4, rent.getTo_date());
        pstm.setObject(5, rent.getAdvance_fee());
        pstm.setObject(6, rent.getMonthly_rent());
        pstm.setObject(7, rent.getRent_id());

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
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getDate(5),
                    rst.getDouble(6),
                    rst.getDouble(7)
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
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getDate(5),
                    rst.getDouble(6),
                    rst.getDouble(7)
            ));

        }

        return alRents;
    }

}
