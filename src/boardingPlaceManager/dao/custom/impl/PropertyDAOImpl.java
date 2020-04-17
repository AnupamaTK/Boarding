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
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.PropertyDTO;

//*
// *
// * @author User
// 
public class PropertyDAOImpl implements PropertyDAO {

    @Override
    public boolean add(PropertyDTO property) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO property VALUES (?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, property.getProperty_id());
        pstm.setObject(2, property.getAvailability());
        pstm.setObject(3, property.getAdvance_fee());
        pstm.setObject(4, property.getMonthly_rent());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(PropertyDTO property) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE property SET availability=?,advance_fee=?,monthly_rent=? where property_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, property.getAvailability());
        pstm.setObject(2, property.getAdvance_fee());
        pstm.setObject(3, property.getMonthly_rent());
        pstm.setObject(4, property.getProperty_id());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(PropertyDTO property) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM property WHERE property_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, property.getProperty_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public PropertyDTO search(PropertyDTO property) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM property WHERE property_id='" + property.getProperty_id() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new PropertyDTO(
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
    public ArrayList<PropertyDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM property";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<PropertyDTO> alPropertys = null;
        while (rst.next()) {
            if (alPropertys == null) {
                alPropertys = new ArrayList<>();
            }

            alPropertys.add(new PropertyDTO(
                    rst.getString(1),
                    rst.getBoolean(2),
                    rst.getDouble(3),
                    rst.getDouble(4)
            ));

        }

        return alPropertys;
    }

    @Override
    public boolean CheckAvilability(String propertyId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT availability FROM property WHERE property_id='" + propertyId + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Boolean val = null;
        if (rst.next()) {
            val = rst.getBoolean(1);
        }
        return val;

    }

    @Override
    public boolean changeAvailability(String property_id,Boolean value) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE property SET availability=? where property_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(2, property_id);
        pstm.setObject(1, value);

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

}
