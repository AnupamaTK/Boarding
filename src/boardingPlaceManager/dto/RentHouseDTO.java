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
public class RentHouseDTO extends SuperDTO{
    private String property_id;
    private int no_of_rooms;
    private int no_of_bathrooms;
    private int no_of_story;
    private String address;

    public RentHouseDTO() {
    }

    public RentHouseDTO(String property_id, int no_of_rooms, int no_of_bathrooms, int no_of_story, String address) {
        this.property_id = property_id;
        this.no_of_rooms = no_of_rooms;
        this.no_of_bathrooms = no_of_bathrooms;
        this.no_of_story = no_of_story;
        this.address = address;
    }

    @Override
    public String toString() {
        return "RentHouseDTO{" + "property_id=" + property_id + ", no_of_rooms=" + no_of_rooms + ", no_of_bathrooms=" + no_of_bathrooms + ", no_of_story=" + no_of_story + ", address=" + address + '}';
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public int getNo_of_bathrooms() {
        return no_of_bathrooms;
    }

    public void setNo_of_bathrooms(int no_of_bathrooms) {
        this.no_of_bathrooms = no_of_bathrooms;
    }

    public int getNo_of_story() {
        return no_of_story;
    }

    public void setNo_of_story(int no_of_story) {
        this.no_of_story = no_of_story;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
