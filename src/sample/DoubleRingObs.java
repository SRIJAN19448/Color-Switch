package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class DoubleRingObs extends Obstacle{

    private transient Arc arc[];

    public DoubleRingObs(double pos,Ball ball,Game g){
        super(ball,g,pos);
        this.arc=new Arc[8];

    }

    @Override
    public void create() {

        arc[0]=new Arc(80,pos,70,70,0,78);
        arc[0].setStrokeWidth(15);
        arc[0].setType(ArcType.OPEN);
        arc[0].setStroke(Color.DARKVIOLET);
        arc[0].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[1]=new Arc(80,pos,70,70,90,78);
        arc[1].setStrokeWidth(15);
        arc[1].setType(ArcType.OPEN);
        arc[1].setStroke(Color.YELLOW);
        arc[1].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[2]=new Arc(80,pos,70,70,180,78);
        arc[2].setStrokeWidth(15);
        arc[2].setType(ArcType.OPEN);
        arc[2].setStroke(Color.CYAN);
        arc[2].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[3]=new Arc(80,pos,70,70,270,78);
        arc[3].setStrokeWidth(15);
        arc[3].setType(ArcType.OPEN);
        arc[3].setStroke(Color.DARKMAGENTA);
        arc[3].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[4]=new Arc(220,pos,70,70,12,78);
        arc[4].setStrokeWidth(15);
        arc[4].setType(ArcType.OPEN);
        arc[4].setStroke(Color.YELLOW);
        arc[4].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[5]=new Arc(220,pos,70,70,102,78);
        arc[5].setStrokeWidth(15);
        arc[5].setType(ArcType.OPEN);
        arc[5].setStroke(Color.DARKVIOLET);
        arc[5].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[6]=new Arc(220,pos,70,70,192,78);
        arc[6].setStrokeWidth(15);
        arc[6].setType(ArcType.OPEN);
        arc[6].setStroke(Color.DARKMAGENTA);
        arc[6].setStrokeLineCap(StrokeLineCap.ROUND);

        arc[7]=new Arc(220,pos,70,70,282,78);
        arc[7].setStrokeWidth(15);
        arc[7].setType(ArcType.OPEN);
        arc[7].setStroke(Color.CYAN);
        arc[7].setStrokeLineCap(StrokeLineCap.ROUND);
        
        timeline=new Timeline(new KeyFrame(Duration.millis(5000-250*g.getDifficulty()),new KeyValue(arc[0].startAngleProperty(),360),new KeyValue(arc[1].startAngleProperty(),450),new KeyValue(arc[2].startAngleProperty(),540),new KeyValue(arc[3].startAngleProperty(),630),new KeyValue(arc[4].startAngleProperty(),-348),new KeyValue(arc[5].startAngleProperty(),-258),new KeyValue(arc[6].startAngleProperty(),-168),new KeyValue(arc[7].startAngleProperty(),-78)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        hit=new Timeline(new KeyFrame(Duration.millis(10),e-> detect_hit()));
        hit.setCycleCount(Timeline.INDEFINITE);
        hit.play();
        grp.getChildren().addAll(arc);
    }

    @Override
    public void detect_hit(){

        for(int i=0;i<4;i++) {
            Shape shape = Shape.intersect(ball.getBall(), arc[i]);
            if(shape.getBoundsInLocal().getWidth()!=-1 && arc[i].getStroke()!=ball.getBall().getFill()){
                System.out.println("Collision detected");
                timeline.pause();
                hit.pause();
                ball.getUp().pause();
                ball.getDown().pause();
                g.hit_detected();
                g.setPause_stat(1);
                break;
            }
        }
    }
}
