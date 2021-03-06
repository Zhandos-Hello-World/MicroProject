package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generall implements Initializable {
    @FXML
    private BorderPane Install;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadUI("Home/Home");
    }

    public void LoadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(Generall.class.getName()).log(Level.SEVERE, null, e);
        }
        Install.setCenter(root);
    }
}
