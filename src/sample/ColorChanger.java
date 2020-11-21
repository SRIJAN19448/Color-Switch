package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;

public class ColorChanger implements Special{
    Group g;
    Pane canvas;
    int pos;
    Arc arc[];
    ColorChanger(int pos, Pane canvas){
        this.pos=pos;
        this.canvas=canvas;
        arc=new Arc[4];
    }
    public void create(Pane canvas){
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
        g=new Group();
        g.getChildren().addAll(arc);
        canvas.getChildren().addAll(g);
    }

    @Override
    public int special(double posY, Circle ball) {

        if(posY>=this.arc[0].getCenterY()+canvas.getTranslateY()-this.arc[0].getRadiusY()/4 && posY<=this.arc[0].getCenterY()+canvas.getTranslateY()+this.arc[0].getRadiusY()/4) {
            System.out.println("BYUV");
            if (ball.getFill().equals(Color.YELLOW))
                ball.setFill(Color.DARKVIOLET);
            else if (ball.getFill().equals(Color.DARKVIOLET))
                ball.setFill(Color.DARKMAGENTA);
            else if (ball.getFill().equals(Color.DARKMAGENTA)) {
                System.out.println("UDIKVJ HJDK");
                ball.setFill(Color.CYAN);
            } else if (ball.getFill().equals(Color.CYAN))
                ball.setFill(Color.YELLOW);
            return 1;
        }
        return -1;
    }
}
