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
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.BoadereDTO;
import boardingPlaceManager.dao.custom.BoadereDAO;

//*
// *
// * @author Boarder
// 
public class BoadereDAOImpl implements BoadereDAO {

    @Override
    public boolean add(BoadereDTO boarder) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO boarder VALUES (?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, boarder.getNic());
        pstm.setObject(2, boarder.getName());
        pstm.setObject(3, boarder.getTel());
        pstm.setObject(4, boarder.getAddress());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(BoadereDTO boarder) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE boarder SET name=?,tel=?,address=? where nic=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, boarder.getName());
        pstm.setObject(2, boarder.getTel());
        pstm.setObject(3, boarder.getAddress());
        pstm.setObject(4, boarder.getNic());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(BoadereDTO boarder) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM boarder WHERE nic = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, boarder.getNic());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public BoadereDTO search(BoadereDTO boarder) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM boarder WHERE nic='" + boarder.getNic() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new BoadereDTO(
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
    public ArrayList<BoadereDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM boarder";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<BoadereDTO> alBoarders = null;

        while (rst.next()) {
            if (alBoarders == null) {
                alBoarders = new ArrayList<>();
            }

            alBoarders.add(new BoadereDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));

        }

        return alBoarders;
    }

    @Override
    public BoadereDTO SearchByName(String Name) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM boarder WHERE name='" + Name + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new BoadereDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }

        return null;
    }

}
