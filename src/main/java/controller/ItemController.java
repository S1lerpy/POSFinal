package controller;

import com.perlas.MyListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Coffee;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;


public class ItemController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label PriceLabel;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(coffee);
    }

    private Coffee coffee;
    private MyListener myListener;
    public void setData(Coffee coffee, MyListener myListener) {
        this.coffee = coffee; // Correctly assign the passed coffee object.
        this.myListener = myListener;
        nameLabel.setText(this.coffee.getName());
        PriceLabel.setText(DashboardController.CURRENCY + this.coffee.getPrice());
        Image image = new Image(getClass().getResourceAsStream(this.coffee.getImgSrc()));
        img.setImage(image);
    }

}
