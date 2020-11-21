package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Ball {
    int color=0;
    int trans=1;
    double prevpos;
    double newpos;
    double diff=0;
    double base=0;
    Pane canvas;
    Timeline up;
    Timeline down;
    Circle ball;

    Ball(int centerx, int centery, int radius,Pane canvas){
        this.canvas=canvas;
        ball=new Circle(centerx,centery,radius);
        prevpos=ball.getCenterY();
        newpos=ball.getCenterY();


    }
    public void create(Pane canvas, ArrayList<ColorChanger> clrs){
        ball.setFill(Color.DARKMAGENTA);
        up=new Timeline(new KeyFrame(Duration.millis(10),e->jump(clrs)));
        down=new Timeline(new KeyFrame(Duration.millis(10),e->move_ball()));
        up.setCycleCount(Timeline.INDEFINITE);
        down.setCycleCount(Timeline.INDEFINITE);
        canvas.getChildren().addAll(ball);
    }
    public void make_jump(){
        down.pause();
        up.play();
    }
    public void make_move(){
        up.pause();
        down.play();
    }
    public void jump(ArrayList<ColorChanger> clrs){
//        down.pause();
//        up.play();
        if(ball.getCenterY()<=10)
            up.pause();
        else
            ball.setCenterY(ball.getCenterY()-3);
        if(clrs.size()!=0)
            if(clrs.get(0).special(ball.getCenterY(),ball)==1) {
                ColorChanger c=clrs.get(0);
                clrs.remove(0);
                clrs.add(c);
            }
//        System.out.println   ("curr: "+ball.getCenterY());
//        System.out.println("prev: " + Double.toString(prevpos));
//        System.out.println("new: " + Double.toString(newpos));
        if(ball.getCenterY()<=170 && newpos<=prevpos) {
//            if(ball.getCenterY()==170) {
//                Random r = new Random();
//                int r_no = r.nextInt(4) + 1;
//                System.out.println("color: "+r_no);
//                if (r_no == 0)
//                    ball.setFill(Color.YELLOW);
//                else if (r_no == 1)
//                    ball.setFill(Color.DARKVIOLET);
//                else if (r_no == 2)
//                    ball.setFill(Color.DARKMAGENTA);
//                else if(r_no==3)
//                    ball.setFill(Color.CYAN);
//            }
            newpos = ball.getCenterY();
            base += 3;
            System.out.println("base: "+base);
            canvas.setTranslateY(base);
            if(canvas.getTranslateY()>=150*trans)
            {
                Node n=canvas.getChildren().get(0);
                canvas.getChildren().remove(n);
                n.setTranslateY(-canvas.getTranslateY()-250-650);
                canvas.getChildren().add(n);
                canvas.getChildren().remove(this.ball);
                canvas.getChildren().add(this.ball);
                trans++;
            }
            ball.setTranslateY(-base);

//            if (170 - newpos > diff) {
//                diff = 170 - newpos;
//                for (Node n : canvas.getChildren()) {
//
//                    if (!(n.getClass() == new Circle(10).getClass() && ((Circle) n).getRadius() == 10))
//                        n.setTranslateY(base);
//                    else if ((n.getClass() == new Arc().getClass() && ((Arc) n).getRadiusX() == 12))
//                        ((Arc) n).setCenterY(((Arc)n).getCenterY()+base);
//
//                }

                prevpos = newpos;
//            }
        }
    }
    public void move_ball(){
//        up.pause();
//        down.play();
        if(ball.getCenterY()==490)
            down.pause();
        else
            ball.setCenterY(ball.getCenterY()+1);

    }
}
