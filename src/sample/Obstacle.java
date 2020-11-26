package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;

import java.io.Serializable;

public abstract class Obstacle implements Serializable {
    Ball ball;
    transient Group grp;
    transient Timeline timeline;
    public abstract void passThrough();
    public void animation_pause(){
        timeline.pause();
    }
    public void animation_play(){
        timeline.play();
    }
    Obstacle(Ball ball){
        this.grp=new Group();
        this.ball=ball;
    }

    public abstract void create();
}

