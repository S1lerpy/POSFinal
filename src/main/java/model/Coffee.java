package model;

import javafx.scene.image.Image;

public class Coffee {

    private String name;
    private String imgSrc;
    private double price;
    private String color;
    private Image img;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImgSrc() {
        return imgSrc;
    }

    // In Coffee class
    public void setImgSrc(String img) {
        this.imgSrc = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


}
