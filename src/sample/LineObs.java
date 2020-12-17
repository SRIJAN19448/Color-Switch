package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class LineObs extends Obstacle {
    private transient Line line[];
    private int orientation;

    LineObs(double pos,int orientation,Ball ball,Game g){
        super(ball,g,pos);
        this.orientation=orientation;
        line=new Line[8];
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void create(){
        line=new Line[8];
        line[0]=new Line(-440,pos,-343,pos);
        line[0].setStrokeWidth(15);
        line[0].setStroke(Color.YELLOW);
        line[0].setStrokeLineCap(StrokeLineCap.ROUND);

        line[1]=new Line(-330,pos,-233,pos);
        line[1].setStrokeWidth(15);
        line[1].setStroke(Color.DARKVIOLET);
        line[1].setStrokeLineCap(StrokeLineCap.ROUND);

        line[2]=new Line(-220,pos,-123,pos);
        line[2].setStrokeWidth(15);
        line[2].setStroke(Color.DARKMAGENTA);
        line[2].setStrokeLineCap(StrokeLineCap.ROUND);

        line[3]=new Line(-110,pos,-13,pos);
        line[3].setStrokeWidth(15);
        line[3].setStroke(Color.CYAN);
        line[3].setStrokeLineCap(StrokeLineCap.ROUND);

        line[4]=new Line(0,pos,97,pos);
        line[4].setStrokeWidth(15);
        line[4].setStroke(Color.YELLOW);
        line[4].setStrokeLineCap(StrokeLineCap.ROUND);

        line[5]=new Line(110,pos,207,pos);
        line[5].setStrokeWidth(15);
        line[5].setStroke(Color.DARKVIOLET);
        line[5].setStrokeLineCap(StrokeLineCap.ROUND);

        line[6]=new Line(220,pos,317,pos);
        line[6].setStrokeWidth(15);
        line[6].setStroke(Color.DARKMAGENTA);
        line[6].setStrokeLineCap(StrokeLineCap.ROUND);

        line[7]=new Line(330,pos,427,pos);
        line[7].setStrokeWidth(15);
        line[7].setStroke(Color.CYAN);
        line[7].setStrokeLineCap(StrokeLineCap.ROUND);

        if(orientation==1)
            timeline=new Timeline(new KeyFrame(Duration.millis(20-g.getDifficulty()),e -> move(line[7])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e1 -> move(line[6])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e2 -> move(line[5])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e3 -> move(line[4])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e4 -> move(line[3])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e5 -> move(line[2])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e6 -> move(line[1])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e7 -> move(line[0])));
        else
            timeline=new Timeline(new KeyFrame(Duration.millis(20-g.getDifficulty()),e -> move2(line[0])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e1 -> move2(line[1])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e2 -> move2(line[2])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e3 -> move2(line[3])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e4 -> move2(line[4])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e5 -> move2(line[5])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e6 -> move2(line[6])),new KeyFrame(Duration.millis(20-g.getDifficulty()),e7 -> move2(line[7])));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        hit=new Timeline(new KeyFrame(Duration.millis(10),e-> detect_hit()));
        hit.setCycleCount(Timeline.INDEFINITE);
        hit.play();
        grp.getChildren().addAll(line);
    }

    @Override
    public void detect_hit(){
        for(int i=0;i<8;i++) {
            Shape shape = Shape.intersect(ball.getBall(), line[i]);
            if(shape.getBoundsInLocal().getWidth()!=-1 && line[i].getStroke()!=ball.getBall().getFill()){
                System.out.println("Collision detected");
                System.out.println("LINEOBS");
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


    public void move(Line line){
        if(line.getLayoutX()>=440)
            line.setLayoutX(-2);
        else
            line.setLayoutX(line.getLayoutX()+1);
    }
    public void move2(Line line){
        if(line.getLayoutX()<=0)
            line.setLayoutX(440);
        else
            line.setLayoutX(line.getLayoutX()-1);
    }
}
