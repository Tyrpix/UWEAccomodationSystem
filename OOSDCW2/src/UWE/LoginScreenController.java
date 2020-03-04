package UWE;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;


    private void notAuthorized() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Incorrect Login!");
        alert.show();
    }

    public void loginEvent(ActionEvent event) throws IOException {
        int user = authorized();
        if (user >= 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            Parent root = loader.load();

            //Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            MainViewController mainViewController = loader.getController();
            mainViewController.setUser(user);
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
        else{
            notAuthorized();
        }
    }

    public int authorized() {

        int user = -1;

        if ("manager".equals(username.getText()) && "manager".equals(password.getText())) {
            user = 0;
        }
        if ("warden1".equals(username.getText()) && "warden1".equals(password.getText())) {
            user = 1;
        }
        if ("warden2".equals(username.getText()) && "warden2".equals(password.getText())) {
            user = 2;
        }
        if ("warden3".equals(username.getText()) && "warden3".equals(password.getText())) {
            user = 3;
        }
        if ("warden4".equals(username.getText()) && "warden4".equals(password.getText()))
            user = 4;

        return user;
    }

}