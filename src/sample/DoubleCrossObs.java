package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class DoubleCrossObs extends Obstacle{

    private int length;
    private int degree1[],degree2[];
    private transient Line line[];
    private transient Circle pivot[];
    public DoubleCrossObs(double pos,Ball ball,Game g){
        super(ball,g,pos);
        this.degree1=new int[4];
        this.degree2=new int[4];
        this.line=new Line[8];
        this.pivot=new Circle[2];
    }

    @Override
    public void create() {
        length=80;
        for(int i=0;i<4;i++){
            degree1[i]=i*90;
            degree2[i]=i*90;
        }
        for(int i=0;i<2;i++) {
            pivot[i] = new Circle(9);
            pivot[i].setCenterY(pos);
            pivot[i].setFill(Color.WHITE);
        }
        pivot[0].setCenterX(80);
        pivot[1].setCenterX(220);

        line[0]=new Line(80,pos,80+length ,pos);
        line[0].setStrokeWidth(10);
        line[0].setStroke(Color.YELLOW);
        line[0].setStrokeLineCap(StrokeLineCap.ROUND);

        line[1]=new Line(80,pos,80 ,pos-length);
        line[1].setStrokeWidth(10);
        line[1].setStroke(Color.DARKVIOLET);
        line[1].setStrokeLineCap(StrokeLineCap.ROUND);

        line[2]=new Line(80,pos,80-length ,pos);
        line[2].setStrokeWidth(10);
        line[2].setStroke(Color.DARKMAGENTA);
        line[2].setStrokeLineCap(StrokeLineCap.ROUND);

        line[3]=new Line(80,pos,80 ,pos+length);
        line[3].setStrokeWidth(10);
        line[3].setStroke(Color.CYAN);
        line[3].setStrokeLineCap(StrokeLineCap.ROUND);

        line[4]=new Line(220,pos,220+length ,pos);
        line[4].setStrokeWidth(10);
        line[4].setStroke(Color.DARKMAGENTA);
        line[4].setStrokeLineCap(StrokeLineCap.ROUND);

        line[5]=new Line(220,pos,220 ,pos-length);
        line[5].setStrokeWidth(10);
        line[5].setStroke(Color.DARKVIOLET);
        line[5].setStrokeLineCap(StrokeLineCap.ROUND);

        line[6]=new Line(220,pos,220-length ,pos);
        line[6].setStrokeWidth(10);
        line[6].setStroke(Color.YELLOW);
        line[6].setStrokeLineCap(StrokeLineCap.ROUND);

        line[7]=new Line(220,pos,220 ,pos+length);
        line[7].setStrokeWidth(10);
        line[7].setStroke(Color.CYAN);
        line[7].setStrokeLineCap(StrokeLineCap.ROUND);

        timeline=new Timeline(new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateL(line[0],0)),new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateL(line[1],1)),new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateL(line[2],2)),new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateL(line[3],3)),new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateR(line[4],4)),new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateR(line[5],5)),new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateR(line[6],6)),new KeyFrame(Duration.millis(20-g.getDifficulty()),e->rotateR(line[7],7)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        hit=new Timeline(new KeyFrame(Duration.millis(10),e-> {
            try {
                detect_hit();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }));
        hit.setCycleCount(Timeline.INDEFINITE);
        hit.play();
        grp.getChildren().addAll(line);
        grp.getChildren().addAll(pivot);
    }

    @Override
    public void detect_hit() throws InterruptedException {
        for(int i=0;i<4;i++) {
            Shape shape = Shape.intersect(ball.getBall(), line[i]);
            if(shape.getBoundsInLocal().getWidth()!=-1 && line[i].getStroke()!=ball.getBall().getFill()){
                System.out.println("Collision detected");
                System.out.println("CROSSOBS");
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
    public void rotateL(Line line, int number){

        if(number==0) {
            degree1[0] = (degree1[0] + 1) % 360;
            line.setEndX(80+ length * Math.cos(Math.toRadians(degree1[0])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree1[0])));
        }
        else if(number==1) {
            degree1[1] = (degree1[1] + 1) % 360;
            line.setEndX(80+ length * Math.cos(Math.toRadians(degree1[1])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree1[1])));

        }
        else if(number==2){
            degree1[2] = (degree1[2] + 1) % 360;
            line.setEndX(80+ length * Math.cos(Math.toRadians(degree1[2])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree1[2])));


        }
        else if(number==3){
            degree1[3] = (degree1[3] + 1) % 360;
            line.setEndX(80+ length * Math.cos(Math.toRadians(degree1[3])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree1[3])));


        }
        
    }
    public void rotateR(Line line, int number){

        if(number==4) {
            degree2[0] = (degree2[0] - 1) % 360;
            line.setEndX(220+ length * Math.cos(Math.toRadians(degree2[0])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree2[0])));
        }
        else if(number==5) {
            degree2[1] = (degree2[1] - 1) % 360;
            line.setEndX(220+ length * Math.cos(Math.toRadians(degree2[1])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree2[1])));

        }
        else if(number==6){
            degree2[2] = (degree2[2] - 1) % 360;
            line.setEndX(220+ length * Math.cos(Math.toRadians(degree2[2])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree2[2])));


        }
        else if(number==7){
            degree2[3] = (degree2[3] - 1) % 360;
            line.setEndX(220+ length * Math.cos(Math.toRadians(degree2[3])));
            line.setEndY(line.getStartY()- length * Math.sin(Math.toRadians(degree2[3])));


        }

    }
}
