package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager {
    Game game;
    public void new_game(Game g){

    }
    public void load_game(Game g){

    }
    public void start_game(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene1=new Scene(root1, 600, 600);
        scene1.setFill(Color.BLACK);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene1);
        primaryStage.show();

//        if(){
//            new_game(game);
//        }
//        else if(){
//            load_game(game);
//        }
    }
}
