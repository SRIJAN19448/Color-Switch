package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Color Switch");
        FileInputStream path=new FileInputStream("src/sample/images/icon.png");
        primaryStage.getIcons().add(new Image(path));
        GameManager gm=new GameManager(primaryStage);
        gm.start_game(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
