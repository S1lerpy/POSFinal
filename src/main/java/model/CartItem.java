package model;

public class CartItem {
    private String coffeeName;
    private String size;
    private int quantity;
    private double price;
    private String imagePath;

    // Constructor
    public CartItem(String coffeeName, String size, int quantity, double price, String imagePath) {
        this.coffeeName = coffeeName;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.imagePath = imagePath;
    }

    // Getters and setters
    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
