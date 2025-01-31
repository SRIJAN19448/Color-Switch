package sample;

import java.io.*;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;



public class GameManager {


    private static Scene main_screen,load_screen,play_screen,hit_screen,pause_screen;
    private static Pane main,load,play,hit,pause;
    private static Button new_game,load_game,exit,saves[],pausebtn,use,restart_hit,save_game,restart_pause,back;
    private static Label scr;
    private static ArrayList<Game> save_games;
    private static Game game;
    private static Stage guiStage;

    public GameManager(Stage stage) throws IOException, ClassNotFoundException {
        guiStage=stage;
        game=new Game();
        save_games=new ArrayList<Game>();
        File f1=new File("C:\\Users\\srija\\IdeaProjects\\ColorSwitch\\src\\sample\\saved_games\\savegames.txt");
        if(f1.exists()){
            System.out.println("exists");
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("src/sample/saved_games/savegames.txt"));
            save_games=(ArrayList<Game>)in.readObject();
            in.close();
        }
        else{
            System.out.println("doesnt");
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("src/sample/saved_games/savegames.txt"));
            out.writeObject(save_games);
            out.close();
        }
        make_main();
        make_play();
        make_hit();
        make_pause();
    }

    public static Stage getGuiStage() {
        return guiStage;
    }

    public static ArrayList<Game> getSave_games() {
        return save_games;
    }

    public static Label getScr() {
        return scr;
    }

    public static Button getNew_game() {
        return new_game;
    }

    public static Button getLoad_game() {
        return load_game;
    }

    public static Button getExit() {
        return exit;
    }

    public static Button[] getSaves() {
        return saves;
    }

    public static Button getPausebtn() {
        return pausebtn;
    }

    public static Button getUse() {
        return use;
    }

    public static Button getRestart_hit() {
        return restart_hit;
    }

    public static Button getSave_game() {
        return save_game;
    }

    public static Button getRestart_pause() {
        return restart_pause;
    }

    public static Button getBack() {
        return back;
    }

    public static Pane getMain() {
        return main;
    }

    public static Pane getLoad() {
        return load;
    }

    public static Pane getPlay() {
        return play;
    }

    public static Pane getHit() {
        return hit;
    }

    public static Pane getPause() {
        return pause;
    }

    public static Scene getMain_screen() {
        return main_screen;
    }

    public static Scene getLoad_screen() {
        return load_screen;
    }

    public static Scene getPlay_screen() {
        return play_screen;
    }

    public static Scene getHit_screen() {
        return hit_screen;
    }

    public static Scene getPause_screen() {
        return pause_screen;
    }

    public static void new_game() throws IOException {
        make_play();
        game=new Game();
        game.new_game();

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
        arcs2[0]=new Arc(0,0,110,110,0,90);
        arcs2[0].setStrokeWidth(15);
        arcs2[0].setType(ArcType.OPEN);
        arcs2[0].setStroke(Color.web("#19e010"));
        arcs2[0].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[1]=new Arc(0,0,110,110,90,90);
        arcs2[1].setStrokeWidth(15);
        arcs2[1].setType(ArcType.OPEN);
        arcs2[1].setStroke(Color.RED);
        arcs2[1].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[2]=new Arc(0,0,110,110,180,90);
        arcs2[2].setStrokeWidth(15);
        arcs2[2].setType(ArcType.OPEN);
        arcs2[2].setStroke(Color.YELLOW);
        arcs2[2].setStrokeLineCap(StrokeLineCap.ROUND);
        arcs2[3]=new Arc(0,0,110,110,270,90);
        arcs2[3].setStrokeWidth(15);
        arcs2[3].setType(ArcType.OPEN);
        arcs2[3].setStroke(Color.web("#12bcde"));
        arcs2[3].setStrokeLineCap(StrokeLineCap.ROUND);
        g2.getChildren().addAll(arcs2);

        save_game=new Button("Save Game");
        save_game.setStyle("-fx-background-radius: 50;");
        save_game.setLayoutX(-57.0);
        save_game.setLayoutY(3);
        save_game.setFont(new Font(18));
        save_game.setTextFill(Color.ORANGE);
        save_game.setPrefWidth(120);
        save_game.setPrefHeight(30);

        restart_pause=new Button("Restart");
        restart_pause.setStyle("-fx-background-radius: 50;");
        restart_pause.setLayoutX(-57.0);
        restart_pause.setLayoutY(-41.0);
        restart_pause.setFont(new Font(18));
        restart_pause.setTextFill(Color.ORANGE);
        restart_pause.setPrefWidth(120);
        restart_pause.setPrefHeight(30);

        Button main_menu=new Button("Main Menu");
        main_menu.setStyle("-fx-background-radius: 50;");
        main_menu.setLayoutX(-57.0);
        main_menu.setLayoutY(47.0);
        main_menu.setFont(new Font(18));
        main_menu.setTextFill(Color.ORANGE);
        main_menu.setPrefWidth(120);
        main_menu.setPrefHeight(30);

        back=new Button("Continue");
        back.setStyle("-fx-background-radius: 50;");
        back.setLayoutX(-57.0);
        back.setLayoutY(-85.0);
        back.setFont(new Font(18));
        back.setTextFill(Color.ORANGE);
        back.setPrefWidth(120);
        back.setPrefHeight(30);
        g2.getChildren().addAll(save_game,restart_pause,back,main_menu);
        pause.getChildren().addAll(label,g1,g2);
        pause_screen.getStylesheets().add("sample/buttons.css");

        //listener of main_menu
        main_menu.setOnMouseClicked(mouseEvent -> guiStage.setScene(GameManager.main_screen));


        back.setOnMouseClicked(new EventHandler<MouseEvent>(){
            int var=3;
            Label timer;
            @Override
            public void handle(MouseEvent mouseEvent) {
                guiStage.setScene(GameManager.play_screen);
                timer=new Label("3");
                timer.setTextFill(Color.WHITE);
                timer.setFont(new Font("System Bold Italic",50));
                timer.setLayoutX(133);
                timer.setLayoutY(220);
                GameManager.play.getChildren().add(timer);

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
                    GameManager.play.getChildren().removeAll(timer);
                }
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
        use.setLayoutX(-82);
        use.setLayoutY(-66);
        use.setFont(new Font(23));
        use.setTextFill(Color.ORANGE);
        use.setPrefWidth(150);
        use.setPrefHeight(30);

        restart_hit=new Button("Restart");
        restart_hit.setStyle("-fx-background-radius: 50;");
        restart_hit.setLayoutX(-82);
        restart_hit.setLayoutY(0);
        restart_hit.setFont(new Font(23));
        restart_hit.setTextFill(Color.ORANGE);
        restart_hit.setPrefWidth(150);
        restart_hit.setPrefHeight(30);

        Button menu=new Button("Main Menu");
        menu.setStyle("-fx-background-radius: 50;");
        menu.setLayoutX(-82);
        menu.setLayoutY(66);
        menu.setFont(new Font(23));
        menu.setTextFill(Color.ORANGE);
        menu.setPrefWidth(150);
        menu.setPrefHeight(30);
        Group g=new Group();
        g.setLayoutX(155);
        g.setLayoutY(231);
        g.getChildren().addAll(use,restart_hit,menu);
        hit.getChildren().addAll(h,g);
        hit_screen.getStylesheets().add("sample/buttons.css");
        menu.setOnMouseClicked(mouseEvent -> guiStage.setScene(GameManager.main_screen));

        restart_hit.setOnMouseClicked(mouseEvent -> {

        });
    }

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
        pausebtn=new Button("II");
        pausebtn.setStyle("-fx-background-radius: 50;");
        pausebtn.setLayoutX(259);
        pausebtn.setLayoutY(3);
        pausebtn.setFont(new Font("System Bold",17));
        pausebtn.setTextFill(Color.WHITE);
        pausebtn.setPrefWidth(38);
        pausebtn.setPrefHeight(38);
        pausebtn.setId("pause");
        play.getChildren().addAll(scr,pausebtn);
        play_screen.getStylesheets().add("sample/buttons.css");
        pausebtn.setOnMouseClicked(mouseEvent -> guiStage.setScene(pause_screen));
    }

    public static void make_load(){
        System.out.println("save size:"+save_games.size());
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

        saves[0]=new Button("Slot 1");
        if(save_games.size()>0) {
            saves[0].setText(save_games.get(0).getGameName());
            System.out.println("TRUE");
        }
        saves[0].setStyle("-fx-background-radius: 50;");
        saves[0].setLayoutX(159);
        saves[0].setLayoutY(108);
        saves[0].setFont(new Font(25));
        saves[0].setTextFill(Color.ORANGE);
        saves[0].setPrefWidth(270);
        saves[0].setPrefHeight(15);

        saves[1]=new Button("Slot 2");
        if(save_games.size()>1)
            saves[1].setText(save_games.get(1).getGameName());
        saves[1].setStyle("-fx-background-radius: 50;");
        saves[1].setLayoutX(159);
        saves[1].setLayoutY(167);
        saves[1].setFont(new Font(25));
        saves[1].setTextFill(Color.ORANGE);
        saves[1].setPrefWidth(270);
        saves[1].setPrefHeight(15);

        saves[2]=new Button("Slot 3");
        if(save_games.size()>2)
            saves[2].setText(save_games.get(2).getGameName());
        saves[2].setStyle("-fx-background-radius: 50;");
        saves[2].setLayoutX(159);
        saves[2].setLayoutY(226);
        saves[2].setFont(new Font(25));
        saves[2].setTextFill(Color.ORANGE);
        saves[2].setPrefWidth(270);
        saves[2].setPrefHeight(15);

        saves[3]=new Button("Slot 4");
        if(save_games.size()>3)
            saves[3].setText(save_games.get(3).getGameName());
        saves[3].setStyle("-fx-background-radius: 50;");
        saves[3].setLayoutX(159);
        saves[3].setLayoutY(285);
        saves[3].setFont(new Font(25));
        saves[3].setTextFill(Color.ORANGE);
        saves[3].setPrefWidth(270);
        saves[3].setPrefHeight(15);

        saves[4]=new Button("Slot 5");
        if(save_games.size()>4)
            saves[4].setText(save_games.get(4).getGameName());
        saves[4].setStyle("-fx-background-radius: 50;");
        saves[4].setLayoutX(159);
        saves[4].setLayoutY(344);
        saves[4].setFont(new Font(25));
        saves[4].setTextFill(Color.ORANGE);
        saves[4].setPrefWidth(270);
        saves[4].setPrefHeight(15);

        saves[5]=new Button("Slot 6");
        if(save_games.size()>5)
            saves[5].setText(save_games.get(5).getGameName());
        saves[5].setStyle("-fx-background-radius: 50;");
        saves[5].setLayoutX(159);
        saves[5].setLayoutY(403);
        saves[5].setFont(new Font(25));
        saves[5].setTextFill(Color.ORANGE);
        saves[5].setPrefWidth(270);
        saves[5].setPrefHeight(15);

        Button back=new Button("Back");
        back.setStyle("-fx-background-radius: 50;");
        back.setLayoutX(245);
        back.setLayoutY(486);
        back.setFont(new Font(25));
        back.setTextFill(Color.web("#9f1818"));
        back.setPrefWidth(100);
        back.setPrefHeight(15);
        back.setId("back");
        load.getChildren().addAll(save,back);
        load.getChildren().addAll(saves);
        load_screen.getStylesheets().add("sample/buttons.css");
        back.setOnMouseClicked(mouseEvent -> guiStage.setScene(GameManager.main_screen));

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
        arc_inner_circle[0]=new Arc(0,0,165,165,0,90);
        arc_inner_circle[1]=new Arc(0,0,165,165,90,90);
        arc_inner_circle[2]=new Arc(0,0,165,165,180,90);
        arc_inner_circle[3]=new Arc(0,0,165,165,270,90);

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
        arc_outer_circle[0]=new Arc(0,0,240,240,0,90);
        arc_outer_circle[1]=new Arc(0,0,240,240,90,90);
        arc_outer_circle[2]=new Arc(0,0,240,240,180,90);
        arc_outer_circle[3]=new Arc(0,0,240,240,270,90);

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
        new_game.setStyle("-fx-background-radius: 50;");
        new_game.setLayoutX(228);
        new_game.setLayoutY(222);
        new_game.setFont(new Font(25));
        new_game.setTextFill(Color.ORANGE);
        new_game.setPrefWidth(170);
        new_game.setPrefHeight(40);

        load_game=new Button("Load Game");
        load_game.setStyle("-fx-background-radius: 50;");
        load_game.setLayoutX(228);
        load_game.setLayoutY(287);
        load_game.setFont(new Font(25));
        load_game.setTextFill(Color.ORANGE);
        load_game.setPrefWidth(170);
        load_game.setPrefHeight(40);

        exit=new Button("Exit");
        exit.setStyle("-fx-background-radius: 50;");
        exit.setLayoutX(228);
        exit.setLayoutY(352);
        exit.setFont(new Font(25));
        exit.setTextFill(Color.ORANGE);
        exit.setPrefWidth(170);
        exit.setPrefHeight(40);

        main.getChildren().addAll(c,l,rest,new_game,load_game,exit,g1,g2,g3,g4);
        main_screen.getStylesheets().add("sample/buttons.css");


    }

    public void start_game(Stage primaryStage){
        primaryStage.setScene(main_screen);
        primaryStage.show();
        new_game.setOnMouseReleased(mouseEvent -> {
            try {
                make_play();
                new_game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        load_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("size: "+save_games.size());
                if(save_games.size()!=0) {
                    make_load();
                    guiStage.setScene(load_screen);
                    make_play();
                    load_game();
                }
                else{
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("WARNING");
                    alert.setHeaderText("No Saved Games!!!");
                    alert.setContentText("You haven't saved any games yet");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                }
            }
        });
        exit.setOnMouseClicked(mouseEvent -> System.exit(0));
        restart_hit.setOnMouseClicked(mouseEvent -> {
            try {
                make_play();
                new_game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        restart_pause.setOnMouseClicked(mouseEvent -> {
            try {
                make_play();
                new_game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }





    public static void load_game(){

        saves[0].setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if(save_games.size()<0+1){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    ImageView icon=new ImageView("sample/images/empty_icon.jpg");
                    icon.setFitHeight(48);
                    icon.setFitWidth(48);
                    alert.getDialogPane().setGraphic(icon);
                    alert.setHeaderText("Empty!!!");
                    alert.setContentText("No saved game in this slot yet.");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                    return;
                }
                game=save_games.get(0);
                double t=game.getTranslate();
                System.out.println(game.getBall().getCenterY());
                double cent=game.getBall().getCenterY();
                game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos(),game.getDifficulty());
                game.setTranslate(t);
                try {
                    game.load_game();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        saves[1].setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if(save_games.size()<1+1){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    ImageView icon=new ImageView("sample/images/empty_icon.jpg");
                    icon.setFitHeight(48);
                    icon.setFitWidth(48);
                    alert.getDialogPane().setGraphic(icon);
                    alert.setHeaderText("Empty!!!");
                    alert.setContentText("No saved game in this slot yet.");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                    return;
                }
                game=save_games.get(1);
                double t=game.getTranslate();
                System.out.println(game.getBall().getCenterY());
                double cent=game.getBall().getCenterY();
                game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos(),game.getDifficulty());
                game.setTranslate(t);
                try {
                    game.load_game();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        saves[2].setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if(save_games.size()<2+1){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    ImageView icon=new ImageView("sample/images/empty_icon.jpg");
                    icon.setFitHeight(48);
                    icon.setFitWidth(48);
                    alert.getDialogPane().setGraphic(icon);
                    alert.setHeaderText("Empty!!!");
                    alert.setContentText("No saved game in this slot yet.");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                    return;
                }
                game=save_games.get(2);
                double t=game.getTranslate();
                System.out.println(game.getBall().getCenterY());
                double cent=game.getBall().getCenterY();
                game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos(),game.getDifficulty());
                game.setTranslate(t);
                try {
                    game.load_game();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        saves[3].setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if(save_games.size()<3+1){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    ImageView icon=new ImageView("sample/images/empty_icon.jpg");
                    icon.setFitHeight(48);
                    icon.setFitWidth(48);
                    alert.getDialogPane().setGraphic(icon);
                    alert.setHeaderText("Empty!!!");
                    alert.setContentText("No saved game in this slot yet.");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                    return;
                }
                game=save_games.get(3);
                double t=game.getTranslate();
                System.out.println(game.getBall().getCenterY());
                double cent=game.getBall().getCenterY();
                game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos(),game.getDifficulty());
                game.setTranslate(t);
                try {
                    game.load_game();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        saves[4].setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if(save_games.size()<4+1){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    ImageView icon=new ImageView("sample/images/empty_icon.jpg");
                    icon.setFitHeight(48);
                    icon.setFitWidth(48);
                    alert.getDialogPane().setGraphic(icon);
                    alert.setHeaderText("Empty!!!");
                    alert.setContentText("No saved game in this slot yet.");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                    return;
                }
                game=save_games.get(4);
                double t=game.getTranslate();
                System.out.println(game.getBall().getCenterY());
                double cent=game.getBall().getCenterY();
                game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos(),game.getDifficulty());
                game.setTranslate(t);
                try {
                    game.load_game();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        saves[5].setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if(save_games.size()<5+1) {
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    ImageView icon=new ImageView("sample/images/empty_icon.jpg");
                    icon.setFitHeight(48);
                    icon.setFitWidth(48);
                    alert.getDialogPane().setGraphic(icon);
                    alert.setHeaderText("Empty!!!");
                    alert.setContentText("No saved game in this slot yet.");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                    return;
                }
                game=save_games.get(5);
                double t=game.getTranslate();
                System.out.println(game.getBall().getCenterY());
                double cent=game.getBall().getCenterY();
                game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos(),game.getDifficulty());
                game.setTranslate(t);
                try {
                    game.load_game();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
