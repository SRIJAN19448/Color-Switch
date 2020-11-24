package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
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
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Game implements Serializable {
    transient static Scene scene;
    transient static Pane canvas;
    ArrayList<Obstacle> obstacles;
    Ball ball;
    ArrayList<ColorChanger> clrs;
    ArrayList<Star> stars;
    int pause_stat;
    int score=0;



    public Game() throws IOException {
        this.canvas=Main.play;
        this.pause_stat=0;
        this.scene=Main.play_screen;

    }
    public void new_game() throws IOException {

        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        canvas.setBackground(background);
        Main.getStage().setScene(scene);

        SquareObs square=new SquareObs(250,this.ball);
        square.create(canvas);
        ColorChanger clr=new ColorChanger(100,canvas);
        clr.create(canvas);
        RingObs ring=new RingObs(-50,this.ball);
        ring.create(canvas);
        ColorChanger clr2=new ColorChanger(-200,canvas);
        clr2.create(canvas);
        CrossObs cross=new CrossObs(-350,this.ball);
        cross.create(canvas);
        ColorChanger clr3=new ColorChanger(-500,canvas);
        clr3.create(canvas);
        LineObs line=new LineObs(-650,1,this.ball);
        line.create(canvas);
        ColorChanger clr4=new ColorChanger(-800,canvas);
        clr4.create(canvas);

        obstacles=new ArrayList<>();
        obstacles.add(square);
        obstacles.add(ring);
        obstacles.add(cross);
        obstacles.add(line);

        clrs=new ArrayList<>();
        clrs.add(clr);
        clrs.add(clr2);
        clrs.add(clr3);
        clrs.add(clr4);
        ball=new Ball(150,490,10,canvas);
        ball.create(canvas,clrs);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(pause_stat==0)
                    ball.make_jump();
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(pause_stat==0)
                    ball.make_move();
            }
        });
        Main.pausebtn.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                for (Obstacle i:obstacles){
                    i.animation_pause();
                }
                pause_stat=1;
                ball.up.pause();
                ball.down.pause();
//                obstacles.get(1).animation_pause();
                Main.getStage().setScene(Main.pause_screen);
            }
        });
        Main.back.setOnMouseClicked(new EventHandler<MouseEvent>(){
            int var=3;
            Label timer;
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().setScene(Main.play_screen);
                timer=new Label("3");
                timer.setTextFill(Color.WHITE);
                timer.setFont(new Font("System Bold Italic",50));
                timer.setLayoutX(133);
                timer.setLayoutY(220-canvas.getTranslateY());
                Main.play.getChildren().add(timer);

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
                    Main.play.getChildren().removeAll(timer);
                    for(Obstacle i:obstacles){
                        i.animation_play();
                    }
                    ball.down.play();
                    pause_stat=0;
//                    obstacles.get(0).animation_play();
                }
            }
        });
        Main.save_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    save_game();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void play_game(){

    }

    public void pause_game() throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("pause_screen.fxml"));
        Scene scene2=new Scene(root, 300, 500);
        scene2.setFill(Color.BLACK);
        Main.getStage().setScene(scene2);

    }
    public void back(ActionEvent e) {

    }
    public void detetct_hit(){

    }

    public void save_game() throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("saves.txt"));
        out.writeObject(this);
    }
    public void restart_game(ActionEvent e){

    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
    }

    public void jump(Bounds bounds){
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(0.75),new KeyValue(ball.ball.layoutYProperty(),bounds.getMinY()+ball.ball.getRadius())));
        //timeline.setCycleCount(1);
        timeline.play();
    }
    public void move_ball(Bounds bounds){
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(3),new KeyValue(ball.ball.layoutYProperty(),bounds.getMaxY()-ball.ball.getRadius())));
        //timeline.setCycleCount(1);
        timeline.play();
    }
}
