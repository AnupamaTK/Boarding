/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.controller;

import java.util.ArrayList;
import boardingPlaceManager.dao.DAOFactory;
import boardingPlaceManager.dao.custom.PaymentDAO;
import boardingPlaceManager.dao.custom.PropertyDAO;
import boardingPlaceManager.dto.PaymentDTO;
import boardingPlaceManager.dto.PropertyDTO;

/**
 *
 * @author User
 */
public class PaymentController {

    public static PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
    // public static PropertyDAO propertyDAO = (PropertyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROPERTY);

    public static boolean addPayment(PaymentDTO payment) throws Exception {
        // PropertyDTO propertyDto = new PropertyDTO(payment.getProperty_id(), true,0.0,0.0);
        // boolean res = propertyDAO.add(propertyDto);
        boolean result = paymentDAO.add(payment);
        return result;
    }

    public static boolean deletePayment(PaymentDTO payment) throws Exception {
        boolean result = paymentDAO.delete(payment);
        return result;
    }

    public static boolean updatePayment(PaymentDTO payment) throws Exception {
        boolean result = paymentDAO.update(payment);
        return result;
    }

    public static PaymentDTO searchPayment(PaymentDTO payment) throws Exception {
        PaymentDTO searchedPayment = paymentDAO.search(payment);
        return searchedPayment;
    }

    public static ArrayList<PaymentDTO> getAllPayments() throws Exception {
        return paymentDAO.getAll();
    }

    public static boolean addPayments(ArrayList<PaymentDTO> payments) throws Exception {
        boolean result = false;
        PaymentDTO payment = payments.get(0);
        int i = 0;
        while (i< payments.size()) {
            payment = payments.get(i);
            result = paymentDAO.add(payment);
            i++;
        }
        return result;
    }
    
    public static ArrayList<PaymentDTO> searchPayment(String rent_no, Integer type) throws Exception {
        //System.out.println("pay controller");
        ArrayList<PaymentDTO> searchedPayment = null;
        if (type == 0) {
            searchedPayment = paymentDAO.searchByRentNo(rent_no);
        } else if (type == 1) {
            searchedPayment = paymentDAO.searchCompletedPayments(rent_no);
        } else if (type == 2) {
            searchedPayment = paymentDAO.searchNotCompletedPayments(rent_no);
        } else if (type == 3) {
            searchedPayment = paymentDAO.searchFuturePayments(rent_no);
        }
        return searchedPayment;
    }

//    public static PaymentDTO searchByAddress(String address) throws Exception {
//        PaymentDTO searchedPayment = paymentDAO.searchByAddress(address);
//        return searchedPayment;
//    }
}
