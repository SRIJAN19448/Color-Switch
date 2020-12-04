package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;

public class ColorChanger implements Special, Serializable {
    transient Group g;
    transient Pane canvas;
    double pos;
    transient Arc arc[];
    Ball ball;
    Game game;
    transient Timeline t;
    ArrayList<ColorChanger> clrs;
    ArrayList<Object> itms;
    ColorChanger(double pos,Ball ball,Game game,ArrayList<ColorChanger> clrs,ArrayList<Object> itms){
        this.pos=pos;
        this.canvas=game.getCanvas();
        arc=new Arc[4];
        g=new Group();
        this.game=game;
        this.clrs=clrs;
        this.t=new Timeline();
        this.ball=ball;
        this.itms=itms;
    }
    public void create(){
        arc[0]=new Arc(150,pos,12,12,0,90);
        arc[0].setType(ArcType.ROUND);
        arc[0].setFill(Color.DARKVIOLET);
        arc[0].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[1]=new Arc(150,pos,12,12,90,90);
        arc[1].setType(ArcType.ROUND);
        arc[1].setFill(Color.YELLOW);
        arc[1].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[2]=new Arc(150,pos,12,12,180,90);
        arc[2].setType(ArcType.ROUND);
        arc[2].setFill(Color.CYAN);
        arc[2].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[3]=new Arc(150,pos,12,12,270,90);
        arc[3].setType(ArcType.ROUND);
        arc[3].setFill(Color.DARKMAGENTA);
        arc[3].setStrokeLineCap(StrokeLineCap.ROUND);
        g.getChildren().addAll(arc);
        t=new Timeline(new KeyFrame(Duration.millis(10), e->special(ball.ball.getCenterY())));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
//        canvas.getChildren().addAll(g);
    }

    @Override
    public int special(double posY) {
        if(this.canvas==null)
            System.out.println("NULL");
        if(posY>=this.arc[0].getCenterY()+canvas.getTranslateY()-this.arc[0].getRadiusY()/4 && posY<=this.arc[0].getCenterY()+canvas.getTranslateY()+this.arc[0].getRadiusY()/4) {
            System.out.println("BYUV");
            if (game.getBall().ball.getFill().equals(Color.YELLOW))
                game.getBall().ball.setFill(Color.DARKVIOLET);
            else if (game.getBall().ball.getFill().equals(Color.DARKVIOLET))
                game.getBall().ball.setFill(Color.DARKMAGENTA);
            else if (game.getBall().ball.getFill().equals(Color.DARKMAGENTA)) {
                System.out.println("UDIKVJ HJDK");
                game.getBall().ball.setFill(Color.CYAN);
            } else if (game.getBall().ball.getFill().equals(Color.CYAN))
                game.getBall().ball.setFill(Color.YELLOW);
            canvas.getChildren().remove(this.g);
            ColorChanger cl=this;
            this.clrs.remove(cl);
            this.itms.remove(cl);
            t.stop();
        }
        return -1;
    }
}
