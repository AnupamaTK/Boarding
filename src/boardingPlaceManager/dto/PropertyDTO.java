/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.dto;

/**
 *
 * @author User
 */
public class PropertyDTO extends SuperDTO {

    private String property_id;
    private Boolean availability;
    private Double advance_fee;
    private Double monthly_rent;

    public PropertyDTO() {
    }

    public PropertyDTO(String property_id, Boolean availability, Double advance_fee, Double monthly_rent) {
        this.property_id = property_id;
        this.availability = availability;
        this.advance_fee = advance_fee;
        this.monthly_rent = monthly_rent;
    }

    public Double getAdvance_fee() {
        return advance_fee;
    }

    public void setAdvance_fee(Double advance_fee) {
        this.advance_fee = advance_fee;
    }

    public Double getMonthly_rent() {
        return monthly_rent;
    }

    public void setMonthly_rent(Double monthly_rent) {
        this.monthly_rent = monthly_rent;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "PropertyDTO{" + "property_id=" + property_id + ", availability=" + availability + '}';
    }

}
