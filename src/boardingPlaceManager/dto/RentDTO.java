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
public class RentDTO extends SuperDTO{
    
    private String rent_id;
    private String property_id;
    private String boadere_id;
    private Date from_date;
    private Date to_date;
    private double advance_fee;
    private double monthly_rent;
    

    public RentDTO() {
    }

    public RentDTO(String rent_id, String property_id, String boadere_id, Date from_date, Date to_date, double advance_fee, double monthly_rent) {
        this.rent_id = rent_id;
        this.property_id = property_id;
        this.boadere_id = boadere_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.advance_fee = advance_fee;
        this.monthly_rent = monthly_rent;
    }

    public String getRent_id() {
        return rent_id;
    }

    @Override
    public String toString() {
        return "RentDTO{" + "rent_id=" + rent_id + ", property_id=" + property_id + ", boadere_id=" + boadere_id + ", from_date=" + from_date + ", to_date=" + to_date + ", advance_fee=" + advance_fee + ", monthly_rent=" + monthly_rent + '}';
    }

    public void setRent_id(String rent_id) {
        this.rent_id = rent_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getBoadere_id() {
        return boadere_id;
    }

    public void setBoadere_id(String boadere_id) {
        this.boadere_id = boadere_id;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public double getAdvance_fee() {
        return advance_fee;
    }

    public void setAdvance_fee(double advance_fee) {
        this.advance_fee = advance_fee;
    }

    public double getMonthly_rent() {
        return monthly_rent;
    }

    public void setMonthly_rent(double monthly_rent) {
        this.monthly_rent = monthly_rent;
    }
    
    
    
    
    
}
