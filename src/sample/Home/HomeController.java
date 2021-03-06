package sample.Home;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private static final String[] dataLocation = {"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQT6SAhNZkTMzGWUO9uWpNUZYLh979WmMxf-CIRGCGK9UfNfu9M",
            "https://upload.wikimedia.org/wikipedia/ru/f/f0/Green_Book.jpg",
            "https://lh3.googleusercontent.com/proxy/fKDZEIOM-N8mD2cv7qO30UOT366RLSXlzHvVjLPWFF_AGoTFugiyInufIIjd87b_GaNvhLbWcRCLFd1yqzA"};
    private static final String[] name = {"Tomy & Jerry", "Green book", "Harry Potter"};
    @FXML
    private GridPane gridPaneInstall;

    private VBox films(int i){
        ImageView imageView = new ImageView(new Image(dataLocation[i]));
        imageView.setFitWidth(200);
        imageView.setFitHeight(300);
        Label label = new Label(name[i]);
        label.setStyle("-fx-text-fill: white");
        label.setFont(Font.font("Calibri Light", FontWeight.NORMAL, FontPosture.ITALIC, 20));
        label.setTranslateX(40);
        Button button = new Button("Watch");
        button.setTranslateX(60);
        button.setStyle("-fx-background-color: #B63FD5FF; -fx-text-fill: white");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(imageView, label, button);
        return vBox;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gridPaneInstall.setPadding(new Insets(160,10,10,10));
        gridPaneInstall.setStyle("-fx-background-color: black");
        for(int i = 0; i < 3; i++){
            gridPaneInstall.add(films(i), i, 0);
        }
    }
}
