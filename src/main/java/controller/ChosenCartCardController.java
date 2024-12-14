package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChosenCartCardController {

    public Button minusButton;
    public Button addButton;
    @FXML
    private Label coffeeNameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label sizeLabel;
    @FXML
    private Label quantityLabel; // Ensure it's properly linked in the FXML file
    @FXML
    private Button removeButton;
    @FXML
    private ImageView coffeeImage; // This is where the coffee image will be displayed.

    private int cartItemIndex;
    private int quantity; // Track the quantity of the item
    private double price; // Track the price of the item
    private Runnable onQuantityChangedCallback; // Callback for updating quantity

    /**
     * Sets data for the chosen cart card.
     *
     * @param coffeeName       The name of the coffee.
     * @param size             The size of the coffee (e.g., Small, Medium, Large).
     * @param quantity         The quantity of the coffee.
     * @param price            The total price of the coffee items.
     * @param imagePath        The path to the coffee image.
     * @param index            The index of the cart item.
     * @param onRemoveCallback A callback to handle item removal from the cart.
     */
    public void setData(String coffeeName, String size, int quantity, double price, String imagePath, int index, Runnable onRemoveCallback) {
        this.quantity = quantity;
        this.price = price;
        this.onQuantityChangedCallback = onQuantityChangedCallback;

        coffeeNameLabel.setText(coffeeName);
        sizeLabel.setText(size);
        quantityLabel.setText("x" + quantity); // Set quantity with "x" prefix
        priceLabel.setText(DashboardController.CURRENCY + String.format("%.2f", price)); // Display formatted price

        // Load the image safely
        if (imagePath != null && !imagePath.isEmpty()) {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            coffeeImage.setImage(image);
        } else {
            coffeeImage.setImage(null); // Set a placeholder or null if no image is available
        }

        this.cartItemIndex = index;

        // Attach a callback to the remove button
        removeButton.setOnAction(event -> {
            if (onRemoveCallback != null) {
                onRemoveCallback.run(); // Execute the callback when the button is clicked
            }
        });

        // Attach actions for the plus and minus buttons
        addButton.setOnAction(event -> increaseQuantity());
        minusButton.setOnAction(event -> decreaseQuantity());
    }

    /**
     * Increases the quantity of the item, updates the UI, and the price.
     */
    private void increaseQuantity() {
        quantity++;
        updateUI();
        if (onQuantityChangedCallback != null) {
            onQuantityChangedCallback.run(); // Call the callback when the quantity changes
        }
    }

    /**
     * Decreases the quantity of the item, updates the UI, and the price.
     */
    private void decreaseQuantity() {
        if (quantity > 1) {
            quantity--;
            updateUI();
            if (onQuantityChangedCallback != null) {
                onQuantityChangedCallback.run(); // Call the callback when the quantity changes
            }
        }
    }

    /**
     * Updates the UI with the new quantity and price.
     */
    private void updateUI() {
        quantityLabel.setText("x" + quantity); // Update the displayed quantity
        priceLabel.setText(DashboardController.CURRENCY + String.format("%.2f", price * quantity)); // Update price based on quantity
    }

    /**
     * Gets the cart item index for this card.
     *
     * @return The index of the cart item.
     */
    public int getCartItemIndex() {
        return cartItemIndex;
    }
}
