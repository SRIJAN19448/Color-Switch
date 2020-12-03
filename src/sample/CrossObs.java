package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class CrossObs extends Obstacle {
    int length;
    int pos;
    int degree[];
    transient Line line[];
    transient Circle pivot;
    CrossObs(int pos,Ball ball,Game g){
        super(ball,g);
        this.pos=pos;
        degree=new int[4];
        line=new Line[4];
    }
    @Override
    public void passThrough() {

    }

    public void create(){
        length=80;
        degree[0]=0;
        degree[1]=90;
        degree[2]=180;
        degree[3]=270;

        pivot=new Circle(9);
        pivot.setCenterX(120);
        pivot.setCenterY(pos);
        pivot.setFill(Color.WHITE);

        line[0]=new Line(120,pos,120+length ,pos);
        line[0].setStrokeWidth(10);
        line[0].setStroke(Color.YELLOW);
        line[0].setStrokeLineCap(StrokeLineCap.ROUND);

        line[1]=new Line(120,pos,120 ,pos-length);
        line[1].setStrokeWidth(10);
        line[1].setStroke(Color.DARKVIOLET);
        line[1].setStrokeLineCap(StrokeLineCap.ROUND);

        line[2]=new Line(120,pos,120-length ,pos);
        line[2].setStrokeWidth(10);
        line[2].setStroke(Color.DARKMAGENTA);
        line[2].setStrokeLineCap(StrokeLineCap.ROUND);

        line[3]=new Line(120,pos,120 ,pos+length);
        line[3].setStrokeWidth(10);
        line[3].setStroke(Color.CYAN);
        line[3].setStrokeLineCap(StrokeLineCap.ROUND);

        timeline=new Timeline(new KeyFrame(Duration.millis(20),e->rotateX(line[0],0)),new KeyFrame(Duration.millis(20),e->rotateX(line[1],1)),new KeyFrame(Duration.millis(20),e->rotateX(line[2],2)),new KeyFrame(Duration.millis(20),e->rotateX(line[3],3)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        hit=new Timeline(new KeyFrame(Duration.millis(10),e->detect_hit()));
        hit.setCycleCount(Timeline.INDEFINITE);
        hit.play();
        grp.getChildren().addAll(line);
        grp.getChildren().add(pivot);
//        canvas.getChildren().addAll(grp);
//        canvas.getChildren().addAll(pivot);

    }

    @Override
    public void detect_hit() {
        for(int i=0;i<4;i++) {
            Shape shape = Shape.intersect(ball.ball, line[i]);
            if(shape.getBoundsInLocal().getWidth()!=-1 && line[i].getStroke()!=ball.ball.getFill()){
                System.out.println("Collision detected");
                timeline.pause();
                hit.pause();
                ball.up.pause();
                ball.down.pause();
                g.hit_detected();
                g.pause_stat=1;
                break;
            }
        }
    }

    public void rotateX(Line line, int number){

        if(number==0) {
            degree[0] = (degree[0] + 1) % 360;
            line.setEndX(120+ length * Math.cos(Math.toRadians(degree[0])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree[0])));
        }
        else if(number==1) {
            degree[1] = (degree[1] + 1) % 360;
            line.setEndX(120+ length * Math.cos(Math.toRadians(degree[1])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree[1])));

        }
        else if(number==2){
            degree[2] = (degree[2] + 1) % 360;
            line.setEndX(120+ length * Math.cos(Math.toRadians(degree[2])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree[2])));


        }
        else if(number==3){
            degree[3] = (degree[3] + 1) % 360;
            line.setEndX(120+ length * Math.cos(Math.toRadians(degree[3])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree[3])));


        }
    }

}
