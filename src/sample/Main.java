package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage guiStage;

    public static Stage getStage() {
        return guiStage;
    }


    public void start(Stage primaryStage) throws Exception{
        guiStage = primaryStage;
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("sample1.fxml"));

        Scene scene1=new Scene(root1, 395, 400);
        scene1.setFill(Color.BLACK);

        Scene scene2=new Scene(root2, 300, 500);
        scene2.setFill(Color.BLACK);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
