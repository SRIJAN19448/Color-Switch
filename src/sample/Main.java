package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Main extends Application {
    public static Scene pause_screen,play_screen,main_screen,load_screen,hit_screen;
    public static Pane pause,play,main,load,hit;
    private static Stage guiStage;
    public static Label scr;
    public static Button new_game,load_game,exit,pausebtn,back,save_game,saves[],use;
    public static Stage getStage() {
        return guiStage;
    }
    int var=3;

    public static Circle circle;
//    public static Arc arc[];
//    public static Rectangle rectangle;
//    public static Pane canvas;
//    public static Bounds bounds;

    public static void make_play(){
        play=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        play.setBackground(background);
        play_screen=new Scene(play,300,500);
        play_screen.setFill(Color.BLACK);
        scr=new Label("0");
        scr.setTextFill(Color.WHITE);
        scr.setFont(new Font("System Bold",25));
        scr.setLayoutX(11);
        scr.setLayoutY(3);
        Group g=new Group();
        pausebtn=new Button("II");
        pausebtn.setStyle("-fx-background-radius: 50;-fx-background-color: #333333");
        pausebtn.setLayoutX(259);
        pausebtn.setLayoutY(3);
        pausebtn.setFont(new Font("System Bold",17));
        pausebtn.setTextFill(Color.WHITE);
        pausebtn.setPrefWidth(38);
        pausebtn.setPrefHeight(38);
        play.getChildren().addAll(scr,pausebtn);
        pausebtn.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {

                guiStage.setScene(pause_screen);
            }
        });
    }
    public static void make_pause(){
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
        arcs[0]=new Arc(0,0,140,140,0,90);
        arcs[0].setStrokeWidth(15);
        arcs[0].setType(ArcType.OPEN);
        arcs[0].setStroke(Color.web("#19e010"));
        arcs[0].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs[1]=new Arc(0,0,140,140,90,90);
        arcs[1].setStrokeWidth(15);
        arcs[1].setType(ArcType.OPEN);
        arcs[1].setStroke(Color.RED);
        arcs[1].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs[2]=new Arc(0,0,140,140,180,90);
        arcs[2].setStrokeWidth(15);
        arcs[2].setType(ArcType.OPEN);
        arcs[2].setStroke(Color.YELLOW);
        arcs[2].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs[3]=new Arc(0,0,140,140,270,90);
        arcs[3].setStrokeWidth(15);
        arcs[3].setType(ArcType.OPEN);
        arcs[3].setStroke(Color.web("#12bcde"));
        arcs[3].setStrokeLineCap(StrokeLineCap.ROUND);
        g1.getChildren().addAll(arcs);
        Group g2=new Group();
        g2.setLayoutX(150);
        g2.setLayoutY(250);
        Arc arcs2[]=new Arc[4];
        arcs2[0]=new Arc(0,0,95,95,0,90);
        arcs2[0].setStrokeWidth(10);
        arcs2[0].setType(ArcType.OPEN);
        arcs2[0].setStroke(Color.web("#19e010"));
        arcs2[0].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[1]=new Arc(0,0,95,95,90,90);
        arcs2[1].setStrokeWidth(10);
        arcs2[1].setType(ArcType.OPEN);
        arcs2[1].setStroke(Color.RED);
        arcs2[1].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[2]=new Arc(0,0,95,95,180,90);
        arcs2[2].setStrokeWidth(10);
        arcs2[2].setType(ArcType.OPEN);
        arcs2[2].setStroke(Color.YELLOW);
        arcs2[2].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[3]=new Arc(0,0,95,95,270,90);
        arcs2[3].setStrokeWidth(10);
        arcs2[3].setType(ArcType.OPEN);
        arcs2[3].setStroke(Color.web("#12bcde"));
        arcs2[3].setStrokeLineCap(StrokeLineCap.ROUND);
        g2.getChildren().addAll(arcs2);
        
        save_game=new Button("Save Game");
        save_game.setStyle("-fx-background-radius: 50;");
        save_game.setLayoutX(-47.0);
        save_game.setLayoutY(-74.0);
        save_game.setFont(new Font(14));
        save_game.setTextFill(Color.web("#9f1818"));
        save_game.setPrefWidth(100);
        save_game.setPrefHeight(30);

        Button restart=new Button("Restart");
        restart.setStyle("-fx-background-radius: 50;");
        restart.setLayoutX(-47.0);
        restart.setLayoutY(-37.0);
        restart.setFont(new Font(14));
        restart.setTextFill(Color.web("#9f1818"));
        restart.setPrefWidth(100);
        restart.setPrefHeight(30);

        Button main_menu=new Button("Main Menu");
        main_menu.setStyle("-fx-background-radius: 50;");
        main_menu.setLayoutX(-47.0);
        main_menu.setLayoutY(37.0);
        main_menu.setFont(new Font(14));
        main_menu.setTextFill(Color.web("#9f1818"));
        main_menu.setPrefWidth(100);
        main_menu.setPrefHeight(30);

        back=new Button("Continue");
        back.setStyle("-fx-background-radius: 50;");
        back.setLayoutX(-47.0);
        back.setLayoutY(0);
        back.setFont(new Font(14));
        back.setTextFill(Color.web("#9f1818"));
        back.setPrefWidth(100);
        back.setPrefHeight(30);
        g2.getChildren().addAll(save_game,restart,back,main_menu);
        pause.getChildren().addAll(label,g1,g2);

        //listener of main_menu
        main_menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                guiStage.setScene(main_screen);
            }
        });


        back.setOnMouseClicked(new EventHandler<MouseEvent>(){
            int var=3;
            Label timer;
            @Override
            public void handle(MouseEvent mouseEvent) {
                guiStage.setScene(play_screen);
                timer=new Label("3");
                timer.setTextFill(Color.WHITE);
                timer.setFont(new Font("System Bold Italic",50));
                timer.setLayoutX(133);
                timer.setLayoutY(220);
                play.getChildren().add(timer);

                Timeline t=new Timeline(new KeyFrame(Duration.millis(1000),e->times()));
                t.setCycleCount(3);
                t.play();

            }

            public void times() {
                if(var!=1){
                    var--;
                    timer.setText(String.valueOf(var));

                }
                else{
                    var=3;
                    play.getChildren().removeAll(timer);
                }
            }
        });
    }


    public static void make_main(){
        main=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        main.setBackground(background);
        main_screen=new Scene(main, 600, 600);
        Label c=new Label("C");
        c.setLayoutX(98);
        c.setLayoutY(-6);
        c.setTextFill(Color.RED);
        c.setFont(new Font("System Bold",48));

        Label l=new Label("L");
        l.setLayoutX(174);
        l.setLayoutY(-6);
        l.setTextFill(Color.RED);
        l.setFont(new Font("System Bold",48));

        Label rest=new Label("UR SWITCH");
        rest.setLayoutX(238);
        rest.setLayoutY(-6);
        rest.setTextFill(Color.RED);
        rest.setFont(new Font("System Bold",48));

        //first o
        Arc arc1o[]=new Arc[4];
        arc1o[0] = new Arc(170.0, 0, 20, 20, 0, 90);
        arc1o[1] = new Arc(170.0, 0, 20, 20, 90, 90);
        arc1o[2] = new Arc(170.0, 0, 20, 20, 180, 90);
        arc1o[3] = new Arc(170.0, 0, 20, 20, 270, 90);

        arc1o[0].setFill(Color.web("#391fff"));
        arc1o[0].setStroke(Color.BLACK);
        arc1o[0].setStrokeType(StrokeType.INSIDE);
        arc1o[0].setType(ArcType.ROUND);

        arc1o[1].setFill(Color.web("#f20dc4"));
        arc1o[1].setStroke(Color.BLACK);
        arc1o[1].setStrokeType(StrokeType.INSIDE);
        arc1o[1].setType(ArcType.ROUND);

        arc1o[2].setFill(Color.web("#a671a0"));
        arc1o[2].setStroke(Color.BLACK);
        arc1o[2].setStrokeType(StrokeType.INSIDE);
        arc1o[2].setType(ArcType.ROUND);

        arc1o[3].setFill(Color.web("#dddbf0"));
        arc1o[3].setStroke(Color.BLACK);
        arc1o[3].setStrokeType(StrokeType.INSIDE);
        arc1o[3].setType(ArcType.ROUND);

        Group g1=new Group();
        g1.getChildren().addAll(arc1o);
        g1.setLayoutX(-20);
        g1.setLayoutY(30);
        //first o completed

        //second o
        Arc arc2o[]=new Arc[4];
        arc2o[0] = new Arc(170.0, 0, 20, 20, 0, 90);
        arc2o[1] = new Arc(170.0, 0, 20, 20, 90, 90);
        arc2o[2] = new Arc(170.0, 0, 20, 20, 180, 90);
        arc2o[3] = new Arc(170.0, 0, 20, 20, 270, 90);

        arc2o[0].setFill(Color.web("#391fff"));
        arc2o[0].setStroke(Color.BLACK);
        arc2o[0].setStrokeType(StrokeType.INSIDE);
        arc2o[0].setType(ArcType.ROUND);

        arc2o[1].setFill(Color.web("#f20dc4"));
        arc2o[1].setStroke(Color.BLACK);
        arc2o[1].setStrokeType(StrokeType.INSIDE);
        arc2o[1].setType(ArcType.ROUND);

        arc2o[2].setFill(Color.web("#a671a0"));
        arc2o[2].setStroke(Color.BLACK);
        arc2o[2].setStrokeType(StrokeType.INSIDE);
        arc2o[2].setType(ArcType.ROUND);

        arc2o[3].setFill(Color.web("#dddbf0"));
        arc2o[3].setStroke(Color.BLACK);
        arc2o[3].setStrokeType(StrokeType.INSIDE);
        arc2o[3].setType(ArcType.ROUND);

        Group g2=new Group();
        g2.getChildren().addAll(arc2o);
        g2.setLayoutX(45);
        g2.setLayoutY(30);
        //second o completed

        //inner  circle
        Arc arc_inner_circle[]=new Arc[4];
        arc_inner_circle[0]=new Arc(0,0,150,150,0,90);
        arc_inner_circle[1]=new Arc(0,0,150,150,90,90);
        arc_inner_circle[2]=new Arc(0,0,150,150,180,90);
        arc_inner_circle[3]=new Arc(0,0,150,150,270,90);

        arc_inner_circle[0].setFill(Color.BLACK);
        arc_inner_circle[0].setStroke(Color.web("#19e010"));
        arc_inner_circle[0].setStrokeType(StrokeType.INSIDE);
        arc_inner_circle[0].setStrokeWidth(15);
        arc_inner_circle[0].setStrokeLineCap(StrokeLineCap.ROUND);

        arc_inner_circle[1].setFill(Color.BLACK);
        arc_inner_circle[1].setStroke(Color.web("#e20e0e"));
        arc_inner_circle[1].setStrokeType(StrokeType.INSIDE);
        arc_inner_circle[1].setStrokeWidth(15);
        arc_inner_circle[1].setStrokeLineCap(StrokeLineCap.ROUND);

        arc_inner_circle[2].setFill(Color.BLACK);
        arc_inner_circle[2].setStroke(Color.web("#fffb00"));
        arc_inner_circle[2].setStrokeType(StrokeType.INSIDE);
        arc_inner_circle[2].setStrokeWidth(15);
        arc_inner_circle[2].setStrokeLineCap(StrokeLineCap.ROUND);

        arc_inner_circle[3].setFill(Color.BLACK);
        arc_inner_circle[3].setStroke(Color.web("#12bcde"));
        arc_inner_circle[3].setStrokeType(StrokeType.INSIDE);
        arc_inner_circle[3].setStrokeWidth(15);
        arc_inner_circle[3].setStrokeLineCap(StrokeLineCap.ROUND);

        // inner circle complete adding the group

        Group g3=new Group();
        g3.getChildren().addAll(arc_inner_circle);
        g3.setLayoutX(312);
        g3.setLayoutY(312);

        //outer circle started
        Arc arc_outer_circle[]=new Arc[4];
        arc_outer_circle[0]=new Arc(0,0,225,225,0,90);
        arc_outer_circle[1]=new Arc(0,0,225,225,90,90);
        arc_outer_circle[2]=new Arc(0,0,225,225,180,90);
        arc_outer_circle[3]=new Arc(0,0,225,225,270,90);

        arc_outer_circle[0].setFill(Color.BLACK);
        arc_outer_circle[0].setStroke(Color.web("#19e010"));
        arc_outer_circle[0].setStrokeType(StrokeType.INSIDE);
        arc_outer_circle[0].setStrokeWidth(15);
        arc_outer_circle[0].setStrokeLineCap(StrokeLineCap.ROUND);

        arc_outer_circle[1].setFill(Color.BLACK);
        arc_outer_circle[1].setStroke(Color.web("#e20e0e"));
        arc_outer_circle[1].setStrokeType(StrokeType.INSIDE);
        arc_outer_circle[1].setStrokeWidth(15);
        arc_outer_circle[1].setStrokeLineCap(StrokeLineCap.ROUND);

        arc_outer_circle[2].setFill(Color.BLACK);
        arc_outer_circle[2].setStroke(Color.web("#fffb00"));
        arc_outer_circle[2].setStrokeType(StrokeType.INSIDE);
        arc_outer_circle[2].setStrokeWidth(15);
        arc_outer_circle[2].setStrokeLineCap(StrokeLineCap.ROUND);

        arc_outer_circle[3].setFill(Color.BLACK);
        arc_outer_circle[3].setStroke(Color.web("#12bcde"));
        arc_outer_circle[3].setStrokeType(StrokeType.INSIDE);
        arc_outer_circle[3].setStrokeWidth(15);
        arc_outer_circle[3].setStrokeLineCap(StrokeLineCap.ROUND);

        // outer circle complete adding the group

        Group g4=new Group();
        g4.getChildren().addAll(arc_outer_circle);
        g4.setLayoutX(312);
        g4.setLayoutY(312);






        //defining internal rotation function
        //since java do not support a method inside a method therefore adding a local class
         class local {
            public void rotate1() {
                if (arc1o[0].getStartAngle() >= 360)
                    arc1o[0].setStartAngle(0);
                else
                    arc1o[0].setStartAngle(arc1o[0].getStartAngle() + 1);

                if (arc2o[0].getStartAngle() >= 360)
                    arc2o[0].setStartAngle(0);
                else
                    arc2o[0].setStartAngle(arc2o[0].getStartAngle() + 1);

                if (arc_inner_circle[0].getStartAngle() <= 0)
                    arc_inner_circle[0].setStartAngle(360);
                else
                    arc_inner_circle[0].setStartAngle(arc_inner_circle[0].getStartAngle() - 1);

                if (arc_outer_circle[0].getStartAngle() >= 360)
                    arc_outer_circle[0].setStartAngle(0);
                else
                    arc_outer_circle[0].setStartAngle(arc_outer_circle[0].getStartAngle() + 1);

                //System.out.println("a");
            }
            public void rotate2() {
                if (arc1o[1].getStartAngle() >= 360)
                    arc1o[1].setStartAngle(0);
                else
                    arc1o[1].setStartAngle(arc1o[1].getStartAngle() + 1);

                if (arc2o[1].getStartAngle() >= 360)
                    arc2o[1].setStartAngle(0);
                else
                    arc2o[1].setStartAngle(arc2o[1].getStartAngle() + 1);

                if (arc_inner_circle[1].getStartAngle() <= 0)
                    arc_inner_circle[1].setStartAngle(360);
                else
                    arc_inner_circle[1].setStartAngle(arc_inner_circle[1].getStartAngle() - 1);

                if (arc_outer_circle[1].getStartAngle() >= 360)
                    arc_outer_circle[1].setStartAngle(0);
                else
                    arc_outer_circle[1].setStartAngle(arc_outer_circle[1].getStartAngle() + 1);

                //System.out.println("b");
            }

            public void rotate3() {
                if (arc1o[2].getStartAngle() >= 360)
                    arc1o[2].setStartAngle(0);
                else
                    arc1o[2].setStartAngle(arc1o[2].getStartAngle() + 1);

                if (arc2o[2].getStartAngle() >= 360)
                    arc2o[2].setStartAngle(0);
                else
                    arc2o[2].setStartAngle(arc2o[2].getStartAngle() + 1);

                if (arc_inner_circle[2].getStartAngle() <= 0)
                    arc_inner_circle[2].setStartAngle(360);
                else
                    arc_inner_circle[2].setStartAngle(arc_inner_circle[2].getStartAngle() - 1);

                if (arc_outer_circle[2].getStartAngle() >= 360)
                    arc_outer_circle[2].setStartAngle(0);
                else
                    arc_outer_circle[2].setStartAngle(arc_outer_circle[2].getStartAngle() + 1);

                //System.out.println("c");
            }

            public void rotate4() {
                if (arc1o[3].getStartAngle() >= 360)
                    arc1o[3].setStartAngle(0);
                else
                    arc1o[3].setStartAngle(arc1o[3].getStartAngle() + 1);

                if (arc2o[3].getStartAngle() >= 360)
                    arc2o[3].setStartAngle(0);
                else
                    arc2o[3].setStartAngle(arc2o[3].getStartAngle() + 1);

                if (arc_inner_circle[3].getStartAngle() <= 0)
                    arc_inner_circle[3].setStartAngle(360);
                else
                    arc_inner_circle[3].setStartAngle(arc_inner_circle[3].getStartAngle() - 1);

                if (arc_outer_circle[3].getStartAngle() >= 360)
                    arc_outer_circle[3].setStartAngle(0);
                else
                    arc_outer_circle[3].setStartAngle(arc_outer_circle[3].getStartAngle() + 1);

                //System.out.println("d");
            }

        } // local class ends

        //handler for rotate
        class handler1 implements  EventHandler<ActionEvent>{
            local obj=new local();
             @Override
            public void handle(ActionEvent event) {
                obj.rotate1();
                obj.rotate2();
                obj.rotate3();
                obj.rotate4();
            }
        }

        //handle for changing the colour
        class handler2 implements EventHandler<ActionEvent>{

            @Override
            public void handle(ActionEvent event) {
                double r=Math.random();
                double g=Math.random();
                double b=Math.random();

                c.setTextFill(Color.color(r,g,b));
                l.setTextFill(Color.color(r,g,b));
                rest.setTextFill(Color.color(r,g,b));
            }
        }


         Timeline timeline1=new Timeline(new KeyFrame(Duration.millis(10),new handler1()));
         timeline1.setCycleCount(Timeline.INDEFINITE);
         timeline1.play();

        Timeline timeline2=new Timeline(new KeyFrame(Duration.millis(1000),new handler2()));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();


        new_game=new Button("New Game");
        new_game.setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        new_game.setLayoutX(240);
        new_game.setLayoutY(238);
        new_game.setFont(new Font(18));
        new_game.setTextFill(Color.web("#fc0101"));
        new_game.setPrefWidth(150);
        new_game.setPrefHeight(40);

        load_game=new Button("Load Game");
        load_game.setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        load_game.setLayoutX(240);
        load_game.setLayoutY(288);
        load_game.setFont(new Font(18));
        load_game.setTextFill(Color.web("#fc0101"));
        load_game.setPrefWidth(150);
        load_game.setPrefHeight(40);

        exit=new Button("Exit");
        exit.setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        exit.setLayoutX(240);
        exit.setLayoutY(338);
        exit.setFont(new Font(18));
        exit.setTextFill(Color.web("#fc0101"));
        exit.setPrefWidth(150);
        exit.setPrefHeight(40);

        main.getChildren().addAll(c,l,rest,new_game,load_game,exit,g1,g2,g3,g4);



    }

    public static void make_load(){
        load=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        load.setBackground(background);
        load_screen=new Scene(load, 600, 600);
        Label save=new Label("Saved Games");
        save.setTextFill(Color.RED);
        save.setFont(new Font("System Bold Italic",39));
        save.setLayoutX(176);
        save.setLayoutY(24);

        saves=new Button[6];

        saves[0]=new Button("Saved Game 1");
        saves[0].setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        saves[0].setLayoutX(187);
        saves[0].setLayoutY(108);
        saves[0].setFont(new Font(25));
        saves[0].setTextFill(Color.web("#fc0101"));
        saves[0].setPrefWidth(225);
        saves[0].setPrefHeight(15);

        saves[1]=new Button("Saved Game 2");
        saves[1].setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        saves[1].setLayoutX(187);
        saves[1].setLayoutY(167);
        saves[1].setFont(new Font(25));
        saves[1].setTextFill(Color.web("#fc0101"));
        saves[1].setPrefWidth(225);
        saves[1].setPrefHeight(15);

        saves[2]=new Button("Saved Game 3");
        saves[2].setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        saves[2].setLayoutX(187);
        saves[2].setLayoutY(226);
        saves[2].setFont(new Font(25));
        saves[2].setTextFill(Color.web("#fc0101"));
        saves[2].setPrefWidth(225);
        saves[2].setPrefHeight(15);

        saves[3]=new Button("Saved Game 4");
        saves[3].setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        saves[3].setLayoutX(187);
        saves[3].setLayoutY(285);
        saves[3].setFont(new Font(25));
        saves[3].setTextFill(Color.web("#fc0101"));
        saves[3].setPrefWidth(225);
        saves[3].setPrefHeight(15);

        saves[4]=new Button("Saved Game 5");
        saves[4].setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        saves[4].setLayoutX(187);
        saves[4].setLayoutY(344);
        saves[4].setFont(new Font(25));
        saves[4].setTextFill(Color.web("#fc0101"));
        saves[4].setPrefWidth(225);
        saves[4].setPrefHeight(15);

        saves[5]=new Button("Saved Game 6");
        saves[5].setStyle("-fx-background-radius: 50;-fx-background-color:#4CAF50;");
        saves[5].setLayoutX(187);
        saves[5].setLayoutY(403);
        saves[5].setFont(new Font(25));
        saves[5].setTextFill(Color.web("#fc0101"));
        saves[5].setPrefWidth(225);
        saves[5].setPrefHeight(15);

        Button back=new Button("Back");
        back.setStyle("-fx-background-radius: 50;");
        back.setLayoutX(245);
        back.setLayoutY(486);
        back.setFont(new Font(25));
        back.setTextFill(Color.web("#9f1818"));
        back.setPrefWidth(100);
        back.setPrefHeight(15);

        load.getChildren().addAll(save,back);
        load.getChildren().addAll(saves);

        back.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                guiStage.setScene(main_screen);
            }
        });

    }
    public static void make_hit(){
        hit=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        hit.setBackground(background);
        hit_screen=new Scene(hit, 300, 500);
        Label h=new Label("Oops! Collision");
        h.setTextFill(Color.RED);
        h.setFont(new Font("System Bold Italic",28));
        h.setLayoutX(55);
        h.setLayoutY(71);

        use=new Button("Use Stars");
        use.setStyle("-fx-background-radius: 50;");
        use.setLayoutX(100);
        use.setLayoutY(195);
        use.setFont(new Font(14));
        use.setTextFill(Color.web("#9f1818"));
        use.setPrefWidth(100);
        use.setPrefHeight(10);

        Button restart=new Button("Restart");
        restart.setStyle("-fx-background-radius: 50;");
        restart.setLayoutX(100);
        restart.setLayoutY(230);
        restart.setFont(new Font(14));
        restart.setTextFill(Color.web("#9f1818"));
        restart.setPrefWidth(100);
        restart.setPrefHeight(10);

        Button menu=new Button("Main Menu");
        menu.setStyle("-fx-background-radius: 50;");
        menu.setLayoutX(100);
        menu.setLayoutY(265);
        menu.setFont(new Font(14));
        menu.setTextFill(Color.web("#9f1818"));
        menu.setPrefWidth(100);
        menu.setPrefHeight(10);

        hit.getChildren().addAll(h,use,restart,menu);

        menu.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                guiStage.setScene(main_screen);
            }
        });

        restart.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        guiStage=primaryStage;
        make_pause();
        make_play();
        make_main();
        make_load();
        make_hit();
        GameManager gm=new GameManager();
        gm.start_game(primaryStage);







    }



    public static void main(String[] args) {
        launch(args);
    }


}
