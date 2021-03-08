package sample.MyAccount;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MyAccountController implements Initializable {
    private String name;
    private String lastName;
    private String birthday;
    private int age;
    private String email;
    private String password;

    @FXML
    private AnchorPane installA;

    @FXML
    private Label nameLabel;

    @FXML
    private Label LastNameLabel;

    @FXML
    private Label AgeLabel;

    @FXML
    private Label bithdayLabel;

    @FXML
    private Button btnShowPassword;

    @FXML
    private Label emailLabel;

    @FXML
    private Label passwordLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        btnShowPassword.setOnAction(event -> {

        });
    }

}
