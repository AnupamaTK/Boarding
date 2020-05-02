/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dto;

import java.util.Date;

/**
 *
 * @author User
 */
public class PaymentDTO extends SuperDTO{
    
    private String payment_id;
    private String rent_no;
    private Date due_date;
    private Date payment_date;
    private String discription;
    private double dueAmount;
    private double paidAmount;
    

    public PaymentDTO() {
    }

    @Override
    public String toString() {
        return "PaymentDTO{" + "payment_id=" + payment_id + ", rent_no=" + rent_no + ", due_date=" + due_date + ", payment_date=" + payment_date + ", discription=" + discription + ", dueAmount=" + dueAmount + ", paidAmount=" + paidAmount + '}';
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public PaymentDTO(String payment_id, String rent_no, Date due_date, Date payment_date, String discription, double dueAmount, double paidAmount) {
        this.payment_id = payment_id;
        this.rent_no = rent_no;
        this.due_date = due_date;
        this.payment_date = payment_date;
        this.discription = discription;
        this.dueAmount = dueAmount;
        this.paidAmount = paidAmount;
    }

   

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getRent_no() {
        return rent_no;
    }

    public void setRent_no(String rent_no) {
        this.rent_no = rent_no;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public String getDescription() {
        return discription;
    }

    public void setDescription(String discription) {
        this.discription = discription;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    

    
}
