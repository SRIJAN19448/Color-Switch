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

    Obstacle(Ball ball,Game g,double pos){
        this.grp=new Group();
        this.ball=ball;
        this.g=g;
        this.pos=pos;
        this.timeline=new Timeline();
        this.hit=new Timeline();
    }

    public Ball getBall() {
        return ball;
    }

    public Game getG() {
        return g;
    }

    public double getPos() {
        return pos;
    }

    public Group getGrp() {
        return grp;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public Timeline getHit() {
        return hit;
    }
    public void animation_pause(){
        timeline.pause();
    }
    public void animation_play(){
        timeline.play();
    }

    public abstract void create();
    public abstract void detect_hit();
}

