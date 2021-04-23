package com.jav1001.vinaysingh.pizzzaapp;


import java.io.Serializable;

public class CartElemModel implements Serializable {

    String name, price, quantity, image;

    public CartElemModel(){

    }
    public CartElemModel(String name, String price, String quantity, String image){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public String getImage() {return image;}

    public String getPrice() {return price;}

    public String getName() {return name;}

    public String getQuantity() {return quantity;}

    public void setName(String name) {this.name = name;}

    public void setImage(String image) {this.image = image;}

    public void setQuantity(String quantity) {this.quantity = quantity;}

    public void setPrice(String price) {this.price = price;}


}
