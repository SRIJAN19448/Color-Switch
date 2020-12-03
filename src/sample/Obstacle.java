package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;

import java.io.Serializable;

public abstract class Obstacle implements Serializable {
    Ball ball;
    Game g;
    transient Group grp;
    transient Timeline timeline;
    transient Timeline hit;
    public abstract void passThrough();
    public void animation_pause(){
        timeline.pause();
    }
    public void animation_play(){
        timeline.play();
    }
    Obstacle(Ball ball,Game g){
        this.grp=new Group();
        this.ball=ball;
        this.g=g;
        this.timeline=new Timeline();
        this.hit=new Timeline();
    }

    public abstract void create();
    public abstract void detect_hit();
}

