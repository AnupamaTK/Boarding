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
public class RentRoomDTO extends SuperDTO{
    private String property_id;
    private String house_id;
    private int room_no;
    private int people_per_room;
    private boolean attached_bathroom;
    private String other_details;

    public RentRoomDTO() {
    }

    public RentRoomDTO(String property_id, String house_id, int room_no, int people_per_room, boolean attached_bathroom, String other_details) {
        this.property_id = property_id;
        this.house_id = house_id;
        this.room_no = room_no;
        this.people_per_room = people_per_room;
        this.attached_bathroom = attached_bathroom;
        this.other_details = other_details;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public int getPeople_per_room() {
        return people_per_room;
    }

    public void setPeople_per_room(int people_per_room) {
        this.people_per_room = people_per_room;
    }

    public boolean getAttached_bathroom() {
        return attached_bathroom;
    }

    public void setAttached_bathroom(boolean attached_bathroom) {
        this.attached_bathroom = attached_bathroom;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @Override
    public String toString() {
        return "RentRoomDTO{" + "property_id=" + property_id + ", house_id=" + house_id + ", room_no=" + room_no + ", people_per_room=" + people_per_room + ", attached_bathroom=" + attached_bathroom + ", other_details=" + other_details + '}';
    }

    
}
