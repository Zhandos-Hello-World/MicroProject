package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class ImageLocation extends RegisterController{
    @FXML
    private TextField location;

    @FXML
    public void btnAction(){
        Image image = new Image(location.getText());
        ImageSet(image);
    }
}
