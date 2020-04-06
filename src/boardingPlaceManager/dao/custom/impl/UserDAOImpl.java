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
import boardingPlaceManager.dao.custom.UserDAO;
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.UserDTO;

//*
// *
// * @author User
// 
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean add(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES (?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, user.getNic());
        pstm.setObject(2, user.getUser_name());
        pstm.setObject(3, user.getPassword());
        pstm.setObject(4, user.getTel());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE user SET user_name=?,password=?,tel=? where nic=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, user.getUser_name());
        pstm.setObject(2, user.getPassword());
        pstm.setObject(3, user.getTel());
        pstm.setObject(4, user.getNic());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM user WHERE nic = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, user.getNic());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public UserDTO search(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE nic='" + user.getNic()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new UserDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }

        return null;
    }

    @Override

//     *
//     * @return
//     * @throws Exception
    public ArrayList<UserDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<UserDTO> alUsers = null;

        while (rst.next()) {
            if (alUsers == null) {
                alUsers = new ArrayList<>();
            }

            alUsers.add(new UserDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));

        }

        return alUsers;
    }

    @Override
    public boolean CheckPassword(String name, String password) throws Exception {
        String sql = "Select * from user where user_name='" + name + "' && password='" + password + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return true;
        } else {
            return false;
        }
    }
}
