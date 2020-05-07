/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dao.custom;

import boardingPlaceManager.dao.SuperDAO;
import boardingPlaceManager.dto.PropertyDTO;
import boardingPlaceManager.dto.PaymentDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Payment
 */
public interface PaymentDAO extends SuperDAO<PaymentDTO> {

    public ArrayList<PaymentDTO> searchCompletedPayments(String rent_no) throws Exception;
//

    public ArrayList<PaymentDTO> searchNotCompletedPayments(String rent_no) throws Exception;
//

    public ArrayList<PaymentDTO> searchFuturePayments(String property_id) throws Exception;
//

    public ArrayList<PaymentDTO> searchByRentNo(String rent_no) throws Exception;

    public PaymentDTO getNearestPayment(String rent_no, Date date, int paymentId) throws Exception;
//    
//    public PaymentDTO searchPaymentWithoutId(PaymentDTO rent) throws Exception;

}
