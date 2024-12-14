package model;

public class Coffee {

    private String name;
    private String imgSrc;
    private double price;
    private String color;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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
