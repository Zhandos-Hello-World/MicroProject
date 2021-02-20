package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;


    @FXML
    public void btnLogin(ActionEvent event){
        System.out.println("Login");
    }
    @FXML
    public void btnRegister(ActionEvent event){
        try {
            Stage stage = (Stage)cancelButton.getScene().getWindow();
            stage.close();
            Stage registerStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
            Scene scene = new Scene(root);
            registerStage.setScene(scene);
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void cancelButton(ActionEvent event) {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
