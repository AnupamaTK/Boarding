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
public class BoadereDTO extends SuperDTO{
    private String nic;
    private String name;
    private String tel;
    private String Address;

    public BoadereDTO() {
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public BoadereDTO(String nic, String name, String tel, String Address) {
        this.nic = nic;
        this.name = name;
        this.tel = tel;
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "BoardereDTO{" + "nic=" + nic + ", name=" + name + ", tel=" + tel + ", Address=" + Address + '}';
    }

    
     
}
