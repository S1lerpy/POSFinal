package com.perlas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{

            Parent parentRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Login.fxml")));
            primaryStage.setTitle("Login");
            primaryStage.setResizable(false);
            primaryStage.setIconified(false);
            primaryStage.setScene(new Scene(parentRoot));
            primaryStage.show();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
