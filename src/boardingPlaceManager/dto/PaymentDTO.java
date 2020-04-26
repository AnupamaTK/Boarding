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
    private String description;
    private double amount;
    

    public PaymentDTO() {
    }

    public PaymentDTO(String payment_id, String rent_no, Date due_date, Date payment_date, String description, double amount) {
        this.payment_id = payment_id;
        this.rent_no = rent_no;
        this.due_date = due_date;
        this.payment_date = payment_date;
        this.description = description;
        this.amount = amount;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" + "payment_id=" + payment_id + ", rent_no=" + rent_no + ", due_date=" + due_date + ", payment_date=" + payment_date + ", description=" + description + ", amount=" + amount + '}';
    }

    
}
