package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.perlas.MyListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.CartItem;
import model.Coffee;

public class DashboardController implements Initializable {

    public static final String CURRENCY = "P";
    @FXML
    private Label lblUsername;
    @FXML
    private Button btnManageTable;

    @FXML
    private VBox chosenCoffeeCard;

    @FXML
    private Label CoffeeNameLabel;

    @FXML
    private Label CoffeePriceLabel;

    @FXML
    private ImageView CoffeeImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private VBox cartVBox;

    @FXML
    private ComboBox<String> sizeComboBox;

    @FXML
    private ComboBox<Integer> quantityComboBox;

    @FXML
    private Button addToCartButton;



    Scene fxmlFile;
    Parent root;
    Stage window;

    private static Stage pStage;

    @FXML
    private ImageView imageView;
    @FXML
    private GridPane grid;



    private List<CartItem> cart = new ArrayList<>();
    private List<Coffee> coffees = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    private List<Coffee> getData(){
        List<Coffee> coffees = new ArrayList<>();
        Coffee coffee;

        coffee =new Coffee();
        coffee.setName("CaffeWhiteMocha");
        coffee.setPrice(210.00);
        coffee.setImgSrc("/Images/CaffeWhiteMochaSpanishLatte.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("SaltedCaramelMacchiato");
        coffee.setPrice(205.00);
        coffee.setImgSrc("/Images/SaltedCaramelMacchiato.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("VanillaColdBrew");
        coffee.setPrice(195.00);
        coffee.setImgSrc("/Images/VanillaColdBrew.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("SaltedCaramelEspressoBlend");
        coffee.setPrice(230.00);
        coffee.setImgSrc("/Images/SaltedCaramelEspressoBlend.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("PeachMangoGrahamBlend");
        coffee.setPrice(155.00);
        coffee.setImgSrc("/Images/PeachMangoGrahamBlend.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("PeppermintMochaBlend");
        coffee.setPrice(175.00);
        coffee.setImgSrc("/Images/PeppermintMochaBlend.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("ExpressoInfusedChai");
        coffee.setPrice(180.00);
        coffee.setImgSrc("/Images/ExpressoInfusedChai.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("BlueberryLassi");
        coffee.setPrice(200.00);
        coffee.setImgSrc("/Images/BlueberryLassi.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("RoseChai");
        coffee.setPrice(215.00);
        coffee.setImgSrc("/Images/RoseChai.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("AfzaSharbat");
        coffee.setPrice(210.00);
        coffee.setImgSrc("/Images/AfzaSharbat.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("PeppermintMocha");
        coffee.setPrice(160.00);
        coffee.setImgSrc("/Images/PeppermintMocha.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);

        coffee =new Coffee();
        coffee.setName("AfzaLemonade");
        coffee.setPrice(155.00);
        coffee.setImgSrc("/Images/AfzaLemonade.png");
        coffee.setColor("C5AC94");
        coffees.add(coffee);


        return coffees;
    }

    private void setChosenCoffee(Coffee coffee){
        CoffeeNameLabel.setText(coffee.getName());
        CoffeePriceLabel.setText(DashboardController.CURRENCY + coffee.getPrice());
        image = new Image(getClass().getResourceAsStream(coffee.getImgSrc()));
        CoffeeImg.setImage(image);
        chosenCoffeeCard.setStyle("-fx-background-color: #" + coffee.getColor() + ";\n" +
                "    -fx-background-radius: 30;");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coffees.addAll(getData()); // This should be called only once

        // Populate size options
        sizeComboBox.getItems().addAll("Small", "Medium", "Large");

        // Populate quantity options
        for (int i = 1; i <= 10; i++) {
            quantityComboBox.getItems().add(i);
        }

        // Default selections
        sizeComboBox.setValue("Small");
        quantityComboBox.setValue(1);

        if (coffees.size() > 0) {
            setChosenCoffee(coffees.get(0));
            myListener = coffee -> setChosenCoffee(coffee);
        }

        int column = 0;
        int row = 0;

        // Handle "Add to Cart" button click
        addToCartButton.setOnAction(event -> handleAddToCart());

        try {
            for (int i = 0; i < coffees.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/product.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(coffees.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleAddToCart() {
        String selectedSize = sizeComboBox.getValue();
        int selectedQuantity = quantityComboBox.getValue();
        Coffee selectedCoffee = coffees.stream()
                .filter(coffee -> coffee.getName().equals(CoffeeNameLabel.getText()))
                .findFirst()
                .orElse(null);

        if (selectedCoffee != null) {
            double basePrice = selectedCoffee.getPrice();
            double sizeMultiplier = switch (selectedSize) {
                case "Medium" -> 1.2;
                case "Large" -> 1.5;
                default -> 1.0;
            };
            double finalPrice = basePrice * sizeMultiplier * selectedQuantity;

            // Pass the coffee image path here
            CartItem cartItem = new CartItem(
                    selectedCoffee.getName(),
                    selectedQuantity,
                    selectedSize,
                    finalPrice,
                    selectedCoffee.getImgSrc()  // Include the image path
            );
            cart.add(cartItem);

            System.out.println("Item added to cart: " + cartItem.getCoffeeName());
            System.out.println("Cart size: " + cart.size());

            updateCartDisplay(); // Refresh cart display
        }
    }


    public void setUsername(String username) {
        lblUsername.setText(username);
    }
    private void setPrimaryStage(Stage pStage) {
        DashboardController.pStage = pStage;
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    @FXML
    private void manageTable(ActionEvent event){
        try {
            openModalWindow("Tables.fxml", "Manage Tables");
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            ex.printStackTrace();
        }
    }
    @FXML
    private void actionManageProduct(ActionEvent event) {
        try {
            openModalWindow("Products.fxml", "Manage Products");
        }catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void openModalWindow(String resources, String title) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/" + resources));

        fxmlFile = new Scene(root);
        window = new Stage();
        window.setScene(fxmlFile);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setAlwaysOnTop(true);
        window.setIconified(false);
//        window.initStyle(StageStyle.UNDECORATED);
        window.setTitle(title);
        setPrimaryStage(window);
        window.showAndWait();
    }

    private void updateCartDisplay() {
        cartVBox.getChildren().clear(); // Clear existing items
        for (int i = 0; i < cart.size(); i++) {
            CartItem cartItem = cart.get(i);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CartCard.fxml"));
                VBox card = loader.load(); // Match the root element of the FXML

                ChosenCartCardController cardController = loader.getController();

                // Pass the index and remove callback to the card
                final int index = i; // Make 'i' final or effectively final by declaring it here
                cardController.setData(
                        cartItem.getCoffeeName(),
                        cartItem.getSize(),
                        cartItem.getQuantity(),
                        cartItem.getPrice(),
                        cartItem.getImagePath(),
                        index, // Pass the index here
                        () -> handleRemoveFromCart(index) // Use 'index' in the lambda
                );

                cartVBox.getChildren().add(card); // Add the VBox to the cart display
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void handleRemoveFromCart(int index) {
        cart.remove(index); // Remove item from the cart
        updateCartDisplay(); // Refresh the cart display
    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        System.out.println("Key pressed: " + event.getCode());
        switch (event.getCode()) {
            case F1:
                System.out.println("New Order");
                break;
            case F2:
                System.out.println("Payment Triggered.");
                break;
            case F3:
                System.out.println("Cancel order.");
                break;
            case F4:
                System.out.println("Manage products.");
                try {
                    openModalWindow("Products.fxml", "Manage Products");
                } catch (Exception ex) {

                }
                break;
            case F5:
                System.out.println("Manage Table");
                try {
                    openModalWindow("Tables.fxml", "Manage Tables");
                } catch (Exception ex) {
                    System.out.println("" + ex.getMessage());
                    ex.printStackTrace();
                }
                break;
            case F6:
                System.out.println("Sales Report");
                break;
            case F7:
                try {
                    openModalWindow("Lookup.fxml", "Product Lookup");
                } catch (Exception ex) {
                    System.out.println("" + ex.getMessage());
                    ex.printStackTrace();
                }
                break;
            case F8:
                System.out.println("Logout.");
                break;

        }
    }


}


