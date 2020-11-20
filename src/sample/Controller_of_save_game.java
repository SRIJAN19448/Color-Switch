package sample;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_of_save_game implements Initializable{
    @FXML
    Label label;


    public void change_label_colour(ActionEvent e){
        double r=Math.random();
        double g=Math.random();
        double b=Math.random();

        label.setTextFill(Color.color(r,g,b));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline timeline2=new Timeline((new KeyFrame(Duration.millis(1000), this::change_label_colour)));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();
    }
}
