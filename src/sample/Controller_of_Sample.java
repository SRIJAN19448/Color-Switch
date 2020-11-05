package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Controller_of_Sample extends Main {
    @FXML
    Pane pane1;

    @FXML
    Button b1, b2;

    public void action1(ActionEvent e) throws IOException { // New Game button ka action
        Parent root2 = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        Scene scene2=new Scene(root2, 300, 500);
        scene2.setFill(Color.BLACK);
        Main.getStage().setScene(scene2);

    }

    public void action2(ActionEvent e) throws IOException { // Exit game
        System.exit(0);

    }




}
