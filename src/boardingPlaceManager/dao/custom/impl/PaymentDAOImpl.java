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
import boardingPlaceManager.dao.custom.PaymentDAO;
import boardingPlaceManager.db.DBConnection;
import boardingPlaceManager.dto.PaymentDTO;
import boardingPlaceManager.dao.custom.impl.PropertyDAOImpl;

//*
// *
// * @author User
// 
public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean add(PaymentDTO payment) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO payment VALUES (?,?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, null);
        pstm.setObject(2, payment.getRent_no());
        pstm.setObject(3, payment.getDue_date());
        pstm.setObject(4, payment.getPayment_date());
        pstm.setObject(5, payment.getDescription());
        pstm.setObject(6, payment.getAmount());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE payment SET rent_no=?,due_date=?,payment_date=?,description=?,amount=? where payment_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, payment.getRent_no());
        pstm.setObject(2, payment.getDue_date());
        pstm.setObject(3, payment.getPayment_date());
        pstm.setObject(4, payment.getDescription());
        pstm.setObject(5, payment.getAmount());
        pstm.setObject(6, payment.getPayment_id());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM payment WHERE payment_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, payment.getPayment_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public PaymentDTO search(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM payment WHERE payment_id='" + payment.getPayment_id()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new PaymentDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getDate(4),
                    rst.getString(5),
                    rst.getDouble(6)
            );
        }

        return null;
    }

    @Override

//     *
//     * @return
//     * @throws Exception
    public ArrayList<PaymentDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM payment";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<PaymentDTO> alPayments = null;
        while (rst.next()) {
            if (alPayments == null) {
                alPayments = new ArrayList<>();
            }

            alPayments.add(new PaymentDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getDate(4),
                    rst.getString(5),
                    rst.getDouble(6)
            ));

        }

        return alPayments;
    }

}
