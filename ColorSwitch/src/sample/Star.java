package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class Star implements Special, Serializable {
    private transient Group grp;
    private transient ImageView imv;
    private Game game;
    private double pos;
    private transient Timeline t;
    Star(double pos,Game game){
        this.pos=pos;
        grp=new Group();
        imv=new ImageView();
        this.game=game;
        this.t=new Timeline();
    }

    public Group getGrp() {
        return grp;
    }

    public double getPos() {
        return pos;
    }

    public void create() throws FileNotFoundException {
        FileInputStream path=new FileInputStream("src/sample/images/stars.png");
        Image img=new Image(path);
        imv.setImage(img);
        imv.setPreserveRatio(true);
        imv.setFitHeight(50);
        imv.setFitWidth(50);
        imv.setX(125);
        imv.setY(pos);
        grp.getChildren().add(imv);
        t=new Timeline(new KeyFrame(Duration.millis(10),e->special(game.getBall().getBall().getCenterY())));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    @Override
    public void special(double posY) {
        if(posY>=this.imv.getY()+10 && posY<=this.imv.getY()+40){
            game.setScore(game.getScore()+1);
            GameManager.getScr().setText(String.valueOf(game.getScore()));
            game.getCanvas().getChildren().remove(this.grp);
            Star x=this;
            this.game.getStars().remove(x);
            this.game.getItems().remove(x);
            t.stop();
        }

    }
}
