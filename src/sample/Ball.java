package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.io.Serializable;

public class Ball implements Serializable {

    private double centerX,centerY;
    private int radius;
    private transient Timeline up;
    private transient Timeline down;
    private transient Circle ball;
    private Game game;
    Ball(double centerx, double centery, int radius, Game game){

        this.centerX=centerx;
        this.centerY=centery;
        this.radius=radius;
        this.game=game;
        ball=new Circle(centerx,centery,radius);


    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public Timeline getUp() {
        return up;
    }

    public Timeline getDown() {
        return down;
    }

    public Circle getBall() {
        return ball;
    }

    public void create(Pane canvas){
        ball.setFill(Color.DARKMAGENTA);
        up=new Timeline(new KeyFrame(Duration.millis(10),e->jump()));
        down=new Timeline(new KeyFrame(Duration.millis(10),e-> {
            try {
                move_ball();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }));
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
        double y=ball.getCenterY();
        y-=3;
        ball.setCenterY(y);
        if(y<250){
            if(250-y>game.getCanvas().getLayoutY()){
                game.getCanvas().setLayoutY(250-y);
                game.setTranslate(250-y);
                GameManager.pausebtn.setLayoutY(y-250);
                GameManager.scr.setLayoutY(y-250);
            }
        }
    }
    public void move_ball() throws InterruptedException {
        if(ball.getCenterY()==490-game.getCanvas().getLayoutY())
            if(game.getTranslate()==0)
                down.pause();
            else{
                game.hit_detected();
                game.setPause_stat(1);
            }
        else
            ball.setCenterY(ball.getCenterY()+1);

    }
}
