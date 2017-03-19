/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class Cart {

    public int Id, Quantity;
    public float Total;
    public String DateX, Code, Username;

    public Cart(int Id, int Quantity, float Total, String DateX, String Code, String Username) {
        this.Id = Id;
        this.Quantity = Quantity;
        this.Total = Total;
        this.DateX = DateX;
        this.Code = Code;
        this.Username = Username;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getDateX() {
        return DateX;
    }

    public void setDateX(String DateX) {
        this.DateX = DateX;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

}
