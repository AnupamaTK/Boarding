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
public class UserDTO extends SuperDTO{
    private String nic;
    private String name;
    private String tel;

    public UserDTO() {
    }

    public UserDTO(String nic, String name, String tel) {
        this.nic = nic;
        this.name = name;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "nic=" + nic + ", name=" + name + ", tel=" + tel + '}';
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    
}
