package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField nameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField numberText;
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button btnCreate;
    @FXML
    private Label labelShowName;
    @FXML
    private Label labelShowName2;
    @FXML
    private Label labelShowNumber1;
    @FXML
    private Button addImage;
    @FXML
    private ImageView Avatar;


    @FXML
    protected void ImageSet(Image image){
        Avatar.setImage(image);
    }
    @FXML
    public void addImage(){
        try {
            Stage location = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("ImageLocation.fxml"));
            Scene scene1 = new Scene(root1);
            location.setScene(scene1);
            location.show();
        } catch (IOException e) {
<<<<<<< Updated upstream
            System.out.print(e.getMessage());
=======
            System.out.print("Mistake");
>>>>>>> Stashed changes
        }
    }

    @FXML
    public void btnCreate(){
        if(checkNameText(nameText.getText()) && checkLastNameText(lastNameText.getText()) && checkNumberText(numberText.getText())){
            //This place will be loading Intro.fxml
        }

    }


    private boolean checkNameText(String name){
        boolean check = true;
        for(int i = 0; i < name.length(); i++){
            if(!((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z'))){
                check = false;
                break;
            }
        }
        if(name.length() > 1){
            labelShowName.setText("Incorrect");
            labelShowName.setTextFill(new Color(.96,0,0, 1));
            if(check){
                labelShowName.setText("Correct");
                labelShowName.setTextFill(new Color(.16,.65,.27, 1));
            }
            return check;
        }
        else{
            labelShowName.setText("Name empty");
            labelShowName.setTextFill(new Color(.96,0,0, 1));
            return false;
        }
    }
    //problem
    private boolean checkLastNameText(String name){
        boolean check = true;
        for(int i = 0; i < name.length(); i++){
            if(!((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z'))){
                check = false;
                break;
            }
        }
        if(name.length() > 1){
            labelShowName2.setText("Incorrect");
            labelShowName2.setTextFill(new Color(.96,0,0, 1));
            if(check){
                labelShowName2.setText("Correct");
                labelShowName2.setTextFill(new Color(.16,.65,.27, 1));
            }
            return check;
        }
        else{
            labelShowName2.setText("Name empty");
            labelShowName2.setTextFill(new Color(.96,0,0, 1));
            return false;
        }
    }


private boolean checkNumberText(String number){
        try{
            long a = Long.parseLong(number);
            labelShowNumber1.setText("Correct");
            labelShowNumber1.setTextFill(new Color(.16,.65,.27, 1));
            return true;
        }
        catch (Exception ex){
            labelShowNumber1.setText("Incorrect");
            labelShowNumber1.setTextFill(new Color(.96,0,0, 1));
            return false;
        }
    }

}
