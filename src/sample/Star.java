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
    private transient Group grp;
//    transient Pane canvas;
    private transient ImageView imv;
    private Game game;
//    Ball ball;
    private double pos;
//    ArrayList<Star> strs;
//    ArrayList<Object> itms;
    private transient Timeline t;
    Star(double pos, Pane canvas,Ball ball,Game game,ArrayList<Star> strs,ArrayList<Object> itms){
        this.pos=pos;
//        this.canvas=canvas;
        grp=new Group();
        imv=new ImageView();
//        this.ball=ball;
        this.game=game;
//        this.strs=strs;
        this.t=new Timeline();
//        this.itms=itms;
    }

    public Group getGrp() {
        return grp;
    }

    public double getPos() {
        return pos;
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
        System.out.println(game.getBall().ball==null);
        t=new Timeline(new KeyFrame(Duration.millis(10),e->special(game.getBall().ball.getCenterY())));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    @Override
    public int special(double posY) {
//        System.out.println(this.canvas==null);
        if(posY>=this.imv.getY()+10 && posY<=this.imv.getY()+40){
            game.setScore(game.getScore()+1);
            Main.scr.setText(String.valueOf(game.getScore()));
            game.getCanvas().getChildren().remove(this.grp);
            Star x=this;
            this.game.getStars().remove(x);
            this.game.getItems().remove(x);
            t.stop();
        }

        return -1;
    }
}
