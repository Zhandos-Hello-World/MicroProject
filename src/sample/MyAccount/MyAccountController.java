package sample.MyAccount;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MyAccountController implements Initializable {
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
    private Label telLabel;

    @FXML
    private Label passwordLabel;

    private void setCurrentUser(){
        try{
            Scanner scanner  = new Scanner(new File("CurrentUser"));
            nameLabel.setText(scanner.nextLine());
            LastNameLabel.setText(scanner.nextLine());
            telLabel.setText(scanner.nextLine());
            emailLabel.setText(scanner.nextLine() + "@gmail.com");
            password = scanner.nextLine();
            scanner.close();
        }
        catch (FileNotFoundException ex){
            System.out.print(ex.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCurrentUser();

        btnShowPassword.setOnAction(event -> {
            passwordLabel.setText(password);
        });
    }

}
