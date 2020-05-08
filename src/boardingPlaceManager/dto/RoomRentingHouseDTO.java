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
public class RoomRentingHouseDTO extends SuperDTO{
    private String property_id;
    private int no_of_rooms;
    private int no_of_common_bathrooms;
    private int no_of_story;
    private String address;

    public RoomRentingHouseDTO() {
    }

    public RoomRentingHouseDTO(String property_id, int no_of_rooms, int no_of_common_bathrooms, int no_of_story, String address) {
        this.property_id = property_id;
        this.no_of_rooms = no_of_rooms;
        this.no_of_common_bathrooms = no_of_common_bathrooms;
        this.no_of_story = no_of_story;
        this.address = address;
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

    public int getNo_of_common_bathrooms() {
        return no_of_common_bathrooms;
    }

    public void setNo_of_common_bathrooms(int no_of_common_bathrooms) {
        this.no_of_common_bathrooms = no_of_common_bathrooms;
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

    @Override
    public String toString() {
        return "RoomRentingHouse{" + "property_id=" + property_id + ", no_of_rooms=" + no_of_rooms + ", no_of_common_bathrooms=" + no_of_common_bathrooms + ", no_of_story=" + no_of_story + ", address=" + address + '}';
    }

    
}
