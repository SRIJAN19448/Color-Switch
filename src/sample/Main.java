package sample;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameManager gm=new GameManager(primaryStage);
        gm.start_game(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
