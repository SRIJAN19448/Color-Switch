package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

public class Star implements Special, Serializable {
    transient Group grp;
    transient Pane canvas;
    transient ImageView imv;
    Game g;
    Ball ball;
    double pos;
    ArrayList<Star> strs;
    ArrayList<Object> itms;
    Timeline t;
    Star(double pos, Pane canvas,Ball ball,Game g,ArrayList<Star> strs,ArrayList<Object> itms){
        this.pos=pos;
        this.canvas=canvas;
        grp=new Group();
        imv=new ImageView();
        this.ball=ball;
        this.g=g;
        this.strs=strs;
        this.t=new Timeline();
        this.itms=itms;
    }

    public void create() throws FileNotFoundException {
        FileInputStream path=new FileInputStream("C:\\Users\\srija\\IdeaProjects\\ColorSwitch\\src\\sample\\stars.png");
        Image img=new Image(path);
        imv.setImage(img);
        imv.setPreserveRatio(true);
        imv.setFitHeight(50);
        imv.setFitWidth(50);
        imv.setX(125);
        imv.setY(pos);
        grp.getChildren().add(imv);
        t=new Timeline(new KeyFrame(Duration.millis(10),e->special(ball.ball.getCenterY())));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    @Override
    public int special(double posY) {
//        System.out.println(this.canvas==null);
        if(posY>=this.imv.getY()+canvas.getTranslateY()+10 && posY<=this.imv.getY()+canvas.getTranslateY()+40){
            Main.scr.setText(String.valueOf(++g.score));
            canvas.getChildren().remove(strs.get(0).grp);
            Star x=this.strs.get(0);
            this.strs.remove(x);
            this.itms.remove(x);
            t.stop();
        }

        return -1;
    }
}
