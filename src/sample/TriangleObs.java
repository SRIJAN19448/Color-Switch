package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class TriangleObs extends Obstacle{
    transient Line line[];
    int degree[];
    int length;
    TriangleObs(double pos,Ball ball,Game g){
        super(ball,g,pos);
        line=new Line[3];
        degree=new int[3];
    }
    @Override
    public void passThrough() {

    }

    public void create(){
        degree[0]=0;
        degree[1]=120;
        degree[2]=240;
        length=80;

        line[0]=new Line(150+length,250,150-length*Math.cos(Math.toRadians(60)),250-length*Math.sin(Math.toRadians(60)));
        line[0].setStrokeWidth(10);
        line[0].setStroke(Color.YELLOW);
        line[0].setStrokeLineCap(StrokeLineCap.ROUND);

        line[1]=new Line(150-length*Math.cos(Math.toRadians(60)),250-length*Math.sin(Math.toRadians(60)),150-length*Math.cos(Math.toRadians(60)),250+length*Math.sin(Math.toRadians(60)));
        line[1].setStrokeWidth(10);
        line[1].setStroke(Color.DARKVIOLET);
        line[1].setStrokeLineCap(StrokeLineCap.ROUND);

        line[2]=new Line(150-length*Math.cos(Math.toRadians(60)),250+length*Math.sin(Math.toRadians(60)),150+length,250);
        line[2].setStrokeWidth(10);
        line[2].setStroke(Color.DARKMAGENTA);
        line[2].setStrokeLineCap(StrokeLineCap.ROUND);

        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(20), e->rotateX(line[0],0)),new KeyFrame(Duration.millis(20), e->rotateX(line[1],1)),new KeyFrame(Duration.millis(20), e->rotateX(line[2],2)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        grp.getChildren().addAll(line);
//        canvas.getChildren().addAll(grp);
    }

    @Override
    public void detect_hit() {

    }

    public void rotateX(Line line, int number) {

        if (number == 0) {
            degree[0] = (degree[0] + 1) % 360;
            line.setStartX(150 + length * Math.cos(Math.toRadians(degree[0])));
            line.setStartY(250 - length * Math.sin(Math.toRadians(degree[0])));
            line.setEndX(150 + length * Math.cos(Math.toRadians(degree[0] + 120)));
            line.setEndY(250 - length * Math.sin(Math.toRadians(degree[0] + 120)));
        } else if (number == 1) {
            degree[1] = (degree[1] + 1) % 360;
            line.setStartX(150 + length * Math.cos(Math.toRadians(degree[1])));
            line.setStartY(250 - length * Math.sin(Math.toRadians(degree[1])));
            line.setEndX(150 + length * Math.cos(Math.toRadians(degree[1] + 120)));
            line.setEndY(250 - length * Math.sin(Math.toRadians(degree[1] + 120)));

        } else if (number == 2) {
            degree[2] = (degree[2] + 1) % 360;
            line.setStartX(150 + length * Math.cos(Math.toRadians(degree[2])));
            line.setStartY(250 - length * Math.sin(Math.toRadians(degree[2])));
            line.setEndX(150 + length * Math.cos(Math.toRadians(degree[2] + 120)));
            line.setEndY(250 - length * Math.sin(Math.toRadians(degree[2] + 120)));


        }
    }
}
