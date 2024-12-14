package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.perlas.JdbcDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtpassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // You can add initialization logic here if needed
    }

    @FXML
    private void actionLogin(ActionEvent event) {
        Window owner = txtUsername.getScene().getWindow();
        System.out.println(txtUsername.getText());
        System.out.println(txtpassword.getText());

        if (txtUsername.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Please enter a valid username", "Form Error!");
            return;
        }
        if (txtpassword.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Please enter a valid password", "Form Error!");
            return;
        }

        String username = txtUsername.getText();
        String password = txtpassword.getText();

        JdbcDao jdbcDao = new JdbcDao();
        boolean flag = jdbcDao.validate(username, password);

        if (!flag) {
            infoBox("Please enter the correct username and password.", null, "Login Failed");
        } else {
            infoBox("Login successful!", null, "Login Success");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
                Parent root = fxmlLoader.load();

                Stage stage = new Stage();
                stage.setTitle("POS: Dashboard");
                stage.setScene(new Scene(root));

                // Passing the username to the DashboardController
                DashboardController controller = fxmlLoader.getController();
                controller.setUsername(username);

                // Show the Dashboard window
                stage.show();

                ((Node)(event.getSource())).getScene().getWindow().hide();

            } catch (IOException ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, owner, "An error occurred while opening the dashboard.", "Error");
            }
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.initOwner(owner);
        alert.show();
    }
}
