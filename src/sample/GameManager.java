package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameManager {



    static Game game;
    GameManager() throws IOException {
        game=new Game();
    }
    public static void new_game() throws IOException {
        game=new Game();
        game.new_game();

    }
    public void start_game(Stage primaryStage){
        primaryStage.setScene(Main.main_screen);
        primaryStage.show();
        Main.new_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Main.make_play();
                    new_game();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Main.load_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().setScene(Main.load_screen);
                try {
                    load_game();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        Main.exit.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });
    }





    public static void load_game() throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("saves.txt"));
        game=(Game)in.readObject();
        double t=game.getTranslate();
        System.out.println(game.getBall().centerY);
        double cent=game.getBall().centerY;
        game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getBall().base,game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos());
        game.setTranslate(t);
        game.load_game();
//        ArrayList<Obstacle> obs=new ArrayList<>();
//        ArrayList<Star> strs=new ArrayList<>();
//        ArrayList<ColorChanger> cls=new ArrayList<>();
//        ArrayList<Object> itms=new ArrayList<>();
//        if(game.items==null){
//            System.out.println("NULL");
//        }


    }
}
