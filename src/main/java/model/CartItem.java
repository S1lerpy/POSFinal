package model;

public class CartItem {
    private String coffeeName;
    private int quantity;
    private String size;
    private double price;
    private String imagePath;  // Add this field for the image

    // Constructor
    public CartItem(String coffeeName, int quantity, String size, double price, String imagePath) {
        this.coffeeName = coffeeName;
        this.quantity = quantity;
        this.size = size;
        this.price = price;
        this.imagePath = imagePath;
    }

    // Getters and setters
    public String getCoffeeName() {
        return coffeeName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }
}

