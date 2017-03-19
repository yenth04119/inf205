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
public class Product {
    private String code;
    private String name;
    private float price;
    private int quantity;
    private float tatol;
    public Product() {
    }

    public Product(String code, String name, float price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
 public Product(String code, String name, float price, int quantity, float tatol) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.tatol = tatol;
    }

  public Product(String code, String name, float price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
 public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   public float getTatol() {
        return tatol;
    }

    public void setTatol(float tatol) {
        this.tatol = tatol;
    }
    public float Tong(){
        return price*quantity;
    }
 
}
