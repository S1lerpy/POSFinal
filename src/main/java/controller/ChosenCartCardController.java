package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChosenCartCardController {

    @FXML
    private Label coffeeNameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label sizeLabel;
    @FXML
    private Button removeButton;

    private int cartItemIndex;

    @FXML
    private ImageView coffeeImage;  // This is where the coffee image will be displayed.

    public void setData(String coffeeName, String size, int quantity, double price, String imagePath, int index, Runnable onRemoveCallback) {
        coffeeNameLabel.setText(coffeeName);
        sizeLabel.setText(size + " x" + quantity);
        priceLabel.setText(DashboardController.CURRENCY + price);

        // Load the image
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        coffeeImage.setImage(image);  // Set the image to the ImageView

        this.cartItemIndex = index;  // Store the index of the cart item

        // When the remove button is clicked, trigger the callback
        removeButton.setOnAction(event -> {
            if (onRemoveCallback != null) {
                onRemoveCallback.run();  // Call the remove callback
            }
        });
    }

    public int getCartItemIndex() {
        return cartItemIndex;
    }
}

