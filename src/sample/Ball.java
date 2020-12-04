package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Ball implements Serializable {
    private int color=0;
    private int trans=1;
    private double centerX,centerY;
    private int radius;
    private transient Pane canvas;
    private transient Timeline up;
    private transient Timeline down;
    private transient Circle ball;
    private Game g;



    Ball(double centerx, double centery, int radius, Pane canvas, Game g){
        this.centerX=centerx;
        this.centerY=centery;
        this.radius=radius;
        this.canvas=canvas;
        this.g=g;
        ball=new Circle(centerx,centery,radius);


    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }
    public void fall_pause(){
        down.pause();
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public Circle getBall() {
        return ball;
    }

    public void jump_pause(){
        up.pause();
    }

    public void create(Pane canvas){
        ball.setFill(Color.DARKMAGENTA);
        up=new Timeline(new KeyFrame(Duration.millis(10),e->jump()));
        down=new Timeline(new KeyFrame(Duration.millis(10),e->move_ball()));
        up.setCycleCount(Timeline.INDEFINITE);
        down.setCycleCount(Timeline.INDEFINITE);
        canvas.getChildren().addAll(ball);
    }
    public void make_jump(){
        down.pause();
        up.play();
    }
    public void make_move(){
        up.pause();
        down.play();
    }
    public void jump(){
//        if(canvas==null){
//            System.out.println("NULL");
//        }
//        if(ball.getCenterY()<=10)
//            up.pause();
//        else
//            ball.setCenterY(ball.getCenterY()-3);
//        if(ball.getCenterY()<=170 && newpos<=prevpos) {
//            newpos = ball.getCenterY();
//            base += 3;
//            canvas.setTranslateY(base);
//            Main.pausebtn.setTranslateY(-base);
//            Main.scr.setTranslateY(-base);
//            if(canvas.getTranslateY()>=150*trans) {
//                trans++;
//            }
//            ball.setTranslateY(-base);
//                prevpos = newpos;
//        }

        double y=ball.getCenterY();
        y-=3;
        ball.setCenterY(y);
        if(y<250){
            if(250-y>canvas.getLayoutY()){
                canvas.setLayoutY(250-y);
                g.setTranslate(250-y);
                Main.pausebtn.setLayoutY(y-250);
                Main.scr.setLayoutY(y-250);
            }
        }
    }
    public void move_ball(){
        if(ball.getCenterY()==490-canvas.getLayoutY())
            down.pause();
        else
            ball.setCenterY(ball.getCenterY()+1);

    }
}
