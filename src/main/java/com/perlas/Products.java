package com.perlas;

import java.sql.Blob;

/**
 *
 * @author Admin
 */
public class Products {
    private int id;
    private String barcode;
    private String description;
    private String price;
    private String category;
    private Blob image;
    private String status;

    public Products(int id, String barcode, String description, String price, String category, Blob image, String status) {
        this.id = id;
        this.barcode = barcode;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = (com.mysql.cj.jdbc.Blob) image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Blob getImage() { // Add this getter
        return image;
    }

    public String getStatus() {
        return status;
    }
}
