package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {
    public static Scene pause_screen,play_screen,main_screen,hit_screen;
    public static Pane pause,play,main,hit;
    private static Stage guiStage;
    public static Label scr;
    public static Stage getStage() {
        return guiStage;
    }


    public static Circle circle;
//    public static Arc arc[];
//    public static Rectangle rectangle;
//    public static Pane canvas;
//    public static Bounds bounds;

    public void make_play(){
        play=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        play.setBackground(background);
        play_screen=new Scene(play,300,500);
        scr=new Label("0");
        scr.setTextFill(Color.WHITE);
        scr.setFont(new Font(25));
        scr.setLayoutX(279);
        scr.setLayoutY(-4);
        Group g=new Group();
        g.setLayoutX(250);
        g.setLayoutY(100);
        Button new_game=new Button("Pause");
        new_game.setLayoutY(0);
        new_game.setLayoutX(2);
        new_game.setFont(new Font(14));
        new_game.setTextFill(Color.RED);
        play.getChildren().addAll(scr,new_game,g);
        new_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                guiStage.setScene(pause_screen);
            }
        });
    }
    public void make_pause(){
        pause=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        pause.setBackground(background);
        pause_screen=new Scene(pause, 300, 500);
        Label label=new Label("Game Paused");
        label.setTextFill(Color.RED);
        label.setFont(new Font("System Bold Italic",25));
        label.setLayoutX(70);
        label.setLayoutY(50);
        Group g1=new Group();
        g1.setLayoutX(150);
        g1.setLayoutY(250);
        Arc arcs[]=new Arc[4];
        arcs[0]=new Arc(0,0,120,120,0,90);
        arcs[0].setStrokeWidth(15);
        arcs[0].setType(ArcType.OPEN);
        arcs[0].setStroke(Color.web("#19e010"));
        arcs[0].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs[1]=new Arc(0,0,120,120,90,90);
        arcs[1].setStrokeWidth(15);
        arcs[1].setType(ArcType.OPEN);
        arcs[1].setStroke(Color.RED);
        arcs[1].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs[2]=new Arc(0,0,120,120,180,90);
        arcs[2].setStrokeWidth(15);
        arcs[2].setType(ArcType.OPEN);
        arcs[2].setStroke(Color.YELLOW);
        arcs[2].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs[3]=new Arc(0,0,120,120,270,90);
        arcs[3].setStrokeWidth(15);
        arcs[3].setType(ArcType.OPEN);
        arcs[3].setStroke(Color.web("#12bcde"));
        arcs[3].setStrokeLineCap(StrokeLineCap.ROUND);
        g1.getChildren().addAll(arcs);
        Group g2=new Group();
        g2.setLayoutX(150);
        g2.setLayoutY(250);
        Arc arcs2[]=new Arc[4];
        arcs2[0]=new Arc(0,0,80,80,0,90);
        arcs2[0].setStrokeWidth(10);
        arcs2[0].setType(ArcType.OPEN);
        arcs2[0].setStroke(Color.web("#19e010"));
        arcs2[0].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[1]=new Arc(0,0,80,80,90,90);
        arcs2[1].setStrokeWidth(10);
        arcs2[1].setType(ArcType.OPEN);
        arcs2[1].setStroke(Color.RED);
        arcs2[1].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[2]=new Arc(0,0,80,80,180,90);
        arcs2[2].setStrokeWidth(10);
        arcs2[2].setType(ArcType.OPEN);
        arcs2[2].setStroke(Color.YELLOW);
        arcs2[2].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[3]=new Arc(0,0,80,80,270,90);
        arcs2[3].setStrokeWidth(10);
        arcs2[3].setType(ArcType.OPEN);
        arcs2[3].setStroke(Color.web("#12bcde"));
        arcs2[3].setStrokeLineCap(StrokeLineCap.ROUND);
        g2.getChildren().addAll(arcs2);
        Button save_game=new Button("Save Game");
        save_game.setStyle("-fx-background-radius: 50");
        save_game.setLayoutX(100);
        save_game.setLayoutY(195);
        save_game.setFont(new Font(14));
        save_game.setTextFill(Color.web("#9f1818"));
        save_game.setPrefWidth(100);
        save_game.setPrefHeight(30);
        Button restart=new Button("Restart");
        restart.setStyle("-fx-background-radius: 50;");
        restart.setLayoutX(100);
        restart.setLayoutY(235);
        restart.setFont(new Font(14));
        restart.setTextFill(Color.web("#9f1818"));
        restart.setPrefWidth(100);
        restart.setPrefHeight(30);
        Button back=new Button("Back");
        back.setStyle("-fx-background-radius: 50;");
        back.setLayoutX(100);
        back.setLayoutY(275);
        back.setFont(new Font(14));
        back.setTextFill(Color.web("#9f1818"));
        back.setPrefWidth(100);
        back.setPrefHeight(30);
        pause.getChildren().addAll(label,g1,g2,save_game,restart,back);
        back.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                guiStage.setScene(play_screen);
            }
        });
    }

    public void make_hit(){

    }
    public void make_main(){
        main=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        main.setBackground(background);
        main_screen=new Scene(main, 600, 600);
        Label c=new Label("C");
        c.setLayoutX(98);
        c.setLayoutY(-6);
        c.setTextFill(Color.RED);
        c.setFont(new Font(48));

        Label l=new Label("L");
        l.setLayoutX(174);
        l.setLayoutY(-6);
        l.setTextFill(Color.RED);
        l.setFont(new Font(48));

        Label rest=new Label("UR SWITCH");
        rest.setLayoutX(238);
        rest.setLayoutY(-6);
        rest.setTextFill(Color.RED);
        rest.setFont(new Font(48));

        Button new_game=new Button("New Game");
        new_game.setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        new_game.setLayoutX(240);
        new_game.setLayoutY(238);
        new_game.setFont(new Font(18));
        new_game.setTextFill(Color.web("#fc0101"));
        new_game.setPrefWidth(150);
        new_game.setPrefHeight(40);

        Button load_game=new Button("Load Game");
        load_game.setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        load_game.setLayoutX(240);
        load_game.setLayoutY(288);
        load_game.setFont(new Font(18));
        load_game.setTextFill(Color.web("#fc0101"));
        load_game.setPrefWidth(150);
        load_game.setPrefHeight(40);

        Button exit=new Button("Exit");
        exit.setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        exit.setLayoutX(240);
        exit.setLayoutY(338);
        exit.setFont(new Font(18));
        exit.setTextFill(Color.web("#fc0101"));
        exit.setPrefWidth(150);
        exit.setPrefHeight(40);

        main.getChildren().addAll(c,l,rest,new_game,load_game,exit);
        new_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    GameManager.new_game();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        load_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        exit.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        guiStage=primaryStage;
        make_pause();
        make_play();
        make_main();
        make_hit();
        GameManager gm=new GameManager();
        gm.start_game(primaryStage);







    }



    public static void main(String[] args) {
        launch(args);
    }


}
