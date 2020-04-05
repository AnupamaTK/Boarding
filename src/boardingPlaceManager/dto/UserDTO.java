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
    private String user_name;
    private String password;
    private String tel;

    public UserDTO() {
    }

    public UserDTO(String nic, String user_name, String password, String tel) {
        this.nic = nic;
        this.user_name = user_name;
        this.password = password;
        this.tel = tel;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "nic=" + nic + ", user_name=" + user_name + ", password=" + password + ", tel=" + tel + '}';
    }

     
}
