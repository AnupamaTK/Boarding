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
public class SharingRoomDTO extends SuperDTO{
    private String property_id;
    private int people_per_room;
    private String address;

    public SharingRoomDTO() {
    }

    public SharingRoomDTO(String property_id, int people_per_room, String address) {
        this.property_id = property_id;
        this.people_per_room = people_per_room;
        this.address = address;
    }

    public String getProperty_id() {
        return property_id;
    }

    @Override
    public String toString() {
        return "RentRoomDTO{" + "property_id=" + property_id + ", people_per_room=" + people_per_room + ", address=" + address + '}';
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public int getPeople_per_room() {
        return people_per_room;
    }

    public void setPeople_per_room(int people_per_room) {
        this.people_per_room = people_per_room;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

    
}
