package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;
import java.io.Serializable;
import java.util.Random;

public class ColorChanger implements Special, Serializable {
    private transient Group grp;
    private double pos;
    private transient Arc arc[];
    private Game game;
    private transient Timeline t;
    ColorChanger(double pos,Game game){
        this.pos=pos;
        arc=new Arc[4];
        grp=new Group();
        this.game=game;
        this.t=new Timeline();
    }

    public Group getGrp() {
        return grp;
    }

    public double getPos() {
        return pos;
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
        grp.getChildren().addAll(arc);
        t=new Timeline(new KeyFrame(Duration.millis(10), e->special(game.getBall().getBall().getCenterY())));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
//        canvas.getChildren().addAll(g);
    }

    @Override
    public int special(double posY) {
//        if(this.canvas==null)
//            System.out.println("NULL");
        Paint paints[]=new Paint[4];
        paints[0]=Color.YELLOW;
        paints[1]=Color.DARKVIOLET;
        paints[2]=Color.DARKMAGENTA;
        paints[3]=Color.CYAN;
        if(posY>=this.arc[0].getCenterY()-this.arc[0].getRadiusY()/4 && posY<=this.arc[0].getCenterY()+this.arc[0].getRadiusY()/4) {
//            System.out.println("BYUV");
            Random r=new Random();
            int random=r.nextInt(4);
            while(paints[random]==game.getBall().getBall().getFill()) {
                random = r.nextInt(4);
            }
            game.getBall().getBall().setFill(paints[random]);
            game.getCanvas().getChildren().remove(this.grp);
            ColorChanger cl=this;
            this.game.getClrs().remove(cl);
            this.game.getItems().remove(cl);
            t.stop();
        }
        return -1;
    }
}
