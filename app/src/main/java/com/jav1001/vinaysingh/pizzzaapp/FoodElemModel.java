package com.jav1001.vinaysingh.pizzzaapp;

public class FoodElemModel {


    private String image,name,cal,price,time;

    public FoodElemModel() {
    }
    public FoodElemModel(String image,String name,String cal,String price,String time) {

        this.name=name;
        this.cal = cal;
        this.price=price;
        this.time=time;
        this.image = image;


    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}
