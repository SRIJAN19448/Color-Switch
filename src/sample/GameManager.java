package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameManager {
    @FXML
    Pane pn;
    Game game;
    public void new_game(Game g){

    }
    public void load_game(Game g){

    }
    public void start_game(Stage primaryStage){
        Scene scene=new Scene(pn, 300, 500);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        primaryStage.show();

        if(){
            new_game(game);
        }
        else if(){
            load_game(game);
        }
    }
}
