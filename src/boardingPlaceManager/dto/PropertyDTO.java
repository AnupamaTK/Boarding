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

    public PropertyDTO() {
    }

    public PropertyDTO(String property_id, Boolean availability) {
        this.property_id = property_id;
        this.availability = availability;
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
