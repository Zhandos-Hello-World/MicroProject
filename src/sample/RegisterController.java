package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    private static int currentYear = - 1;
    private static int currentDay = - 1;
    private static int currentMonth = - 1;
    //false equals to Male
    private static boolean checkMF = false;

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
    private MenuButton day;
    @FXML
    private MenuButton month;
    @FXML
    private MenuButton year;
    @FXML
    private RadioButton MaleRadioButton;
    @FXML
    private RadioButton FemaleRadioButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label messageIncorrectBirthday;

    @FXML
    void Cancel() {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }
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
            System.out.print(e.getMessage());
            System.out.print("Mistake");
        }
    }

    @FXML
    public void btnCreate(){
        if(checkNameText(nameText.getText()) && checkLastNameText(lastNameText.getText()) && checkNumberText(numberText.getText()) && emailTextCheck(emailText.getText())){
            File filepath = new File("CurrentUser");
            try {
                PrintWriter pw = new PrintWriter(filepath);
                pw.println(nameText.getText());
                pw.println(lastNameText.getText());
                pw.println(numberText.getText());
                pw.println(emailText.getText());
                //password and birthday
                pw.println(checkMF);
                pw.println();
                pw.close();
            }catch (FileNotFoundException ex){
                System.out.print(ex.getMessage());
            }
        }

    }
    private boolean emailTextCheck(String email){
        return email.length() > 7;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //birthday for controlling 3 MenuButtons
        bithday();
        //maleOrFemale for controlling 2 RadioButtons
        maleOrFemale();
        // install value for MaleRadioButton and FemaleRadioButton

    }
    private void maleOrFemale(){
        ToggleGroup MF = new ToggleGroup();
        MaleRadioButton.setToggleGroup(MF);
        FemaleRadioButton.setToggleGroup(MF);
        MaleRadioButton.setOnAction(event -> {
            checkMF = false;
        });
        FemaleRadioButton.setOnAction(event -> {
            checkMF = true;
        });
    }



    private void bithday(){
        //Create menuItems for menuButtons
        //year
        MenuItem []yearItem = new MenuItem[120];
        for(int i = 0, years = 1900; i < yearItem.length; i ++, years++){
            yearItem[i] = new MenuItem(String.valueOf(years));
        }
        //Month
        MenuItem[]monthItem = new MenuItem[12];
        for(int i = 0; i < monthItem.length; i++){
            monthItem[i] = new MenuItem(i + 1 + "");
        }
        //day
        MenuItem[]dayItem = new MenuItem[31];
        for(int i = 0; i < dayItem.length; i++){
            dayItem[i] = new MenuItem(i + + 1 + "");
        }
        //default value all menuButtons
        year.getItems().clear();
        month.getItems().clear();
        day.getItems().clear();
        month.setMinWidth(67.2);
        year.setMinWidth(54.4);
        day.setMinWidth(51.2);
        //install all menuItems in MenuButtons
        year.getItems().addAll(yearItem);
        month.getItems().addAll(monthItem);
        day.getItems().addAll(dayItem);

        //set size for menuButtons when user on click its.

        //all menuItems action
        for(int i = 0; i < yearItem.length; i++){
            int finalI = i;
            yearItem[i].setOnAction(event -> {
                year.setText(yearItem[finalI].getText());
                currentYear = Integer.parseInt(yearItem[finalI].getText());
            });
        }
        for(int i = 0; i < dayItem.length; i++){
            int finalI = i;
            dayItem[i].setOnAction(event -> {
                day.setText(dayItem[finalI].getText());
                currentDay = Integer.parseInt(dayItem[finalI].getText());
            });
        }
        for(int i = 0 ; i < monthItem.length; i++){
            int finalI = i;
            monthItem[i].setOnAction(event -> {
                month.setText(monthItem[finalI].getText());
                currentMonth = Integer.parseInt(monthItem[finalI].getText());
            });
        }
    }

}
