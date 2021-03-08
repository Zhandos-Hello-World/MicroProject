package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    private static String useranameS;
    private static String passwordS;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Label messageIncorrectPassword;

    @FXML
    private Label messageIncorrectUsername;

    private void checkUsername(){
        try{
            Scanner scanner = new Scanner(new File("CurrentUser"));
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            useranameS = scanner.nextLine();
            passwordS = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }


    @FXML
    public void btnLogin(){
        if(usernameText.getText().equals(useranameS) && passwordText.getText().equals(passwordS)){
                try {
                    Stage stage = (Stage)cancelButton.getScene().getWindow();
                    stage.close();
                    Stage stage1 = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Generall.fxml"));
                    Scene scene = new Scene(root);
                    stage1.setScene(scene);
                    stage1.show();
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        else if(usernameText.getText().equals(useranameS)){
            messageIncorrectPassword.setText("Incorrect password");
            messageIncorrectPassword.setStyle("-fx-text-fill: red");
            messageIncorrectUsername.setText("");
        }
        else if(passwordText.getText().equals(passwordS)){
            messageIncorrectUsername.setText("Incorrect password");
            messageIncorrectUsername.setStyle("-fx-text-fill: red");
            messageIncorrectPassword.setText("");
        }
        else{
            messageIncorrectUsername.setText("Incorrect password");
            messageIncorrectUsername.setStyle("-fx-text-fill: red");
            messageIncorrectPassword.setText("Incorrect password");
            messageIncorrectPassword.setStyle("-fx-text-fill: red");
        }
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
        checkUsername();
    }
}
