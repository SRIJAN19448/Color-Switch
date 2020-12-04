package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;

import java.io.Serializable;

public abstract class Obstacle implements Serializable {
    protected Ball ball;
    protected Game g;
    protected double pos;
    protected transient Group grp;
    protected transient Timeline timeline;
    protected transient Timeline hit;
    public abstract void passThrough();
    public void animation_pause(){
        timeline.pause();
    }
    public void animation_play(){
        timeline.play();
    }
    public void detection_stop(){
        hit.stop();
    }
    Obstacle(Ball ball,Game g,double pos){
        this.grp=new Group();
        this.ball=ball;
        this.g=g;
        this.pos=pos;
        this.timeline=new Timeline();
        this.hit=new Timeline();
    }

    public abstract void create();
    public abstract void detect_hit() throws InterruptedException;
}

