package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class LineObs extends Obstacle {
    Line line[];
    int orientation;
    int pos;
    LineObs(int pos,int orientation){
        this.pos=pos;
        this.orientation=orientation;
    }
    @Override
    public void passThrough() {

    }
    public void create(Pane canvas){
        line=new Line[8];
        line[0]=new Line(-440,pos,-330,pos);
        line[0].setStrokeWidth(15);
        line[0].setStroke(Color.YELLOW);

        line[1]=new Line(-330,pos,-220,pos);
        line[1].setStrokeWidth(15);
        line[1].setStroke(Color.DARKVIOLET);

        line[2]=new Line(-220,pos,-110,pos);
        line[2].setStrokeWidth(15);
        line[2].setStroke(Color.DARKMAGENTA);

        line[3]=new Line(-110,pos,0,pos);
        line[3].setStrokeWidth(15);
        line[3].setStroke(Color.CYAN);

        line[4]=new Line(0,pos,110,pos);
        line[4].setStrokeWidth(15);
        line[4].setStroke(Color.YELLOW);

        line[5]=new Line(110,pos,220,pos);
        line[5].setStrokeWidth(15);
        line[5].setStroke(Color.DARKVIOLET);

        line[6]=new Line(220,pos,330,pos);
        line[6].setStrokeWidth(15);
        line[6].setStroke(Color.DARKMAGENTA);

        line[7]=new Line(330,pos,440,pos);
        line[7].setStrokeWidth(15);
        line[7].setStroke(Color.CYAN);
        Timeline timeline;
        if(orientation==1)
            timeline=new Timeline(new KeyFrame(Duration.millis(10),e -> move(line[7])),new KeyFrame(Duration.millis(10),e1 -> move(line[6])),new KeyFrame(Duration.millis(10),e2 -> move(line[5])),new KeyFrame(Duration.millis(10),e3 -> move(line[4])),new KeyFrame(Duration.millis(10),e4 -> move(line[3])),new KeyFrame(Duration.millis(10),e5 -> move(line[2])),new KeyFrame(Duration.millis(10),e6 -> move(line[1])),new KeyFrame(Duration.millis(10),e7 -> move(line[0])));
        else
            timeline=new Timeline(new KeyFrame(Duration.millis(10),e -> move2(line[0])),new KeyFrame(Duration.millis(10),e1 -> move2(line[1])),new KeyFrame(Duration.millis(10),e2 -> move2(line[2])),new KeyFrame(Duration.millis(10),e3 -> move2(line[3])),new KeyFrame(Duration.millis(10),e4 -> move2(line[4])),new KeyFrame(Duration.millis(10),e5 -> move2(line[5])),new KeyFrame(Duration.millis(10),e6 -> move2(line[6])),new KeyFrame(Duration.millis(10),e7 -> move2(line[7])));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Group g=new Group();
        g.getChildren().addAll(line);
        canvas.getChildren().addAll(g);
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
