package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class RingObs extends Obstacle{
    int pos;
    transient Arc arc[];
    RingObs(int pos,Ball ball){
        super(ball);
        this.pos=pos;
    }
    @Override
    public void passThrough() {

    }
    public void create(Pane canvas){
        arc=new Arc[4];

        arc[0]=new Arc(150,pos,70,70,0,78);
        arc[0].setStrokeWidth(15);
        arc[0].setType(ArcType.OPEN);
        arc[0].setStroke(Color.DARKVIOLET);
        arc[0].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[1]=new Arc(150,pos,70,70,90,78);
        arc[1].setStrokeWidth(15);
        arc[1].setType(ArcType.OPEN);
        arc[1].setStroke(Color.YELLOW);
        arc[1].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[2]=new Arc(150,pos,70,70,180,78);
        arc[2].setStrokeWidth(15);
        arc[2].setType(ArcType.OPEN);
        arc[2].setStroke(Color.CYAN);
        arc[2].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[3]=new Arc(150,pos,70,70,270,78);
        arc[3].setStrokeWidth(15);
        arc[3].setType(ArcType.OPEN);
        arc[3].setStroke(Color.DARKMAGENTA);
        arc[3].setStrokeLineCap(StrokeLineCap.ROUND);

        timeline=new Timeline(new KeyFrame(Duration.seconds(5),new KeyValue(arc[0].startAngleProperty(),-360),new KeyValue(arc[1].startAngleProperty(),-270),new KeyValue(arc[2].startAngleProperty(),-180),new KeyValue(arc[3].startAngleProperty(),-90)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        grp.getChildren().addAll(arc);
//        canvas.getChildren().addAll(grp);
    }
}
