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

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    Pane canvas;
    ArrayList<Obstacle> obstacles;
    Ball ball;
    ArrayList<ColorChanger> clrs;
    ArrayList<Star> stars;
    int score=0;
    @FXML
    Button pause;

    public void new_game() throws IOException {
        canvas= FXMLLoader.load(getClass().getResource("play_screen.fxml"));
//        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
//        Background background=new Background(background_fill);
//        canvas.setBackground(background);

        Scene scene=new Scene(canvas, 300, 500);
        scene.setFill(Color.BLACK);
        Main.getStage().setScene(scene);
//        pause.addEventFilter(KeyEvent.ANY,k->{
//            ball.make_jump();
//        });
        SquareObs square=new SquareObs(250);
        square.create(canvas);
        

        ColorChanger clr=new ColorChanger(100,canvas);
        clr.create(canvas);
        RingObs ring=new RingObs(-50);
        ring.create(canvas);
        ColorChanger clr2=new ColorChanger(-200,canvas);
        clr2.create(canvas);
        CrossObs cross=new CrossObs(-350);
        cross.create(canvas);
        ColorChanger clr3=new ColorChanger(-500,canvas);
        clr3.create(canvas);
        LineObs line=new LineObs(-650,1);
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
                ball.make_jump();
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                ball.make_move();
            }
        });

    }
    public void play_game(){

    }

    public void pause_game(ActionEvent e){
        if()
        System.out.println("mota");

    }

    public void detetct_hit(){

    }

    public void save_game(ActionEvent e){

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
