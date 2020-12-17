package sample;

import java.io.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Game implements Serializable {
    private transient Scene scene;
    private transient Pane canvas;
    private double translate;
    private ArrayList<Obstacle> obstacles;
    private Ball ball;
    private ArrayList<ColorChanger> clrs;
    private ArrayList<Star> stars;
    private int pause_stat;
    private Integer score;
    private int clr_pos;
    private int obstacle_pos;
    private int str_pos;
    private ArrayList<Object> items;
    private int ran;
    private int count;
    private int difficulty;
    private String gameName;
    public Game(){
        this.score=0;
        this.obstacle_pos=250;
        this.clr_pos=100;
        this.str_pos=225;
        this.canvas=GameManager.getPlay();
        this.ball=new Ball(150,490,10,this);
        this.pause_stat=0;
        this.scene=GameManager.getPlay_screen();
        this.obstacles=new ArrayList<>();
        this.clrs=new ArrayList<>();
        this.stars=new ArrayList<>();
        this.items=new ArrayList<>();
        this.ran=3;
        this.gameName="";

    }
    public Game(int score,ArrayList<ColorChanger> clrs,ArrayList<Star> stars,ArrayList<Obstacle> obstacles,ArrayList<Object> item,double centY,double trans,int ob_ps,int cl_ps,int st_ps,int difficulty){
        this.score=score;
        this.translate=trans;
        this.obstacle_pos=ob_ps;
        this.clr_pos=cl_ps;
        this.str_pos=st_ps;
        this.canvas=GameManager.getPlay();
        this.ball=new Ball(150,centY,10,this);
        this.pause_stat=0;
        this.scene=GameManager.getPlay_screen();
        this.clrs=clrs;
        this.stars=stars;
        this.obstacles=obstacles;
        this.items=item;
        this.difficulty=difficulty;
    }

    public Pane getCanvas() {
        return canvas;
    }

    public double getTranslate() {
        return translate;
    }

    public void setTranslate(double translate) {
        this.translate = translate;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public Ball getBall() {
        return ball;
    }

    public ArrayList<ColorChanger> getClrs() {
        return clrs;
    }

    public ArrayList<Star> getStars() {
        return stars;
    }

    public int getPause_stat() {
        return pause_stat;
    }

    public void setPause_stat(int pause_stat) {
        this.pause_stat = pause_stat;
    }

    public int getClr_pos() {
        return clr_pos;
    }

    public int getObstacle_pos() {
        return obstacle_pos;
    }

    public int getStr_pos() {
        return str_pos;
    }

    public ArrayList<Object> getItems() {
        return items;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score=score;
    }

    public String getGameName() {
        return gameName;
    }

    public void new_game() throws IOException {

        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        canvas.setBackground(background);
        GameManager.getGuiStage().setScene(scene);

        SquareObs square=new SquareObs(this.obstacle_pos,this.ball,this);
        square.create();
        canvas.getChildren().add(canvas.getChildren().size()-2, square.getGrp());
        this.obstacle_pos-=300;
        Star st=new Star(225,this);
        st.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,st.getGrp());
        this.str_pos-=300;
        ColorChanger clr=new ColorChanger(this.clr_pos,this);
        clr.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,clr.getGrp());
        this.clr_pos-=300;
        RingObs ring=new RingObs(this.obstacle_pos,this.ball,this);
        ring.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,ring.getGrp());
        this.obstacle_pos-=300;
        Star st1=new Star(-75,this);
        st1.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,st1.getGrp());
        this.str_pos-=300;
        ColorChanger clr2=new ColorChanger(this.clr_pos,this);
        clr2.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,clr2.getGrp());
        this.clr_pos-=300;
        LineObs line=new LineObs(this.obstacle_pos,1,this.ball,this);
        line.create();
        canvas.getChildren().add(canvas.getChildren().size()-2, line.getGrp());
        this.obstacle_pos-=300;
        Star st3=new Star(-675,this);
        st3.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,st3.getGrp());
        this.str_pos-=300;
        ColorChanger clr4=new ColorChanger(this.clr_pos,this);
        clr4.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,clr4.getGrp());
        this.clr_pos-=300;


        items.add(square);
        items.add(clr);
        items.add(ring);
        items.add(clr2);
        items.add(line);
        items.add(clr4);
        items.add(st);
        items.add(st1);
        items.add(st3);


        obstacles.add(square);
        obstacles.add(ring);
        obstacles.add(line);


        clrs.add(clr);
        clrs.add(clr2);
        clrs.add(clr4);

        stars.add(st);
        stars.add(st1);
        stars.add(st3);
        ball.create(canvas);
        activate_event_handlers();
    }
    public void play_game() throws FileNotFoundException {
        Node n=canvas.getChildren().get(0);
        Bounds s=n.getBoundsInLocal();
        Object rem=new Object();
        if((double)(((s.getMinY()+s.getMaxY())/2)+canvas.getLayoutY())>=(double)600){
            canvas.getChildren().remove(n);
            rem=this.items.get(0);
            this.items.remove(rem);
            this.obstacles.remove((Obstacle)rem);
            if(count<4){
                count++;
            }
            else if(count==4){
                count=0;
                difficulty+=3;
            }

        }

        if(rem instanceof Obstacle) {
            ((Obstacle)rem).getHit().stop();
            Random r=new Random();
            int random=r.nextInt(6);
            while(random==ran){
                random=r.nextInt(6);
            }
            ran=random;
            if (random==0) {
                SquareObs sq = new SquareObs(this.obstacle_pos, this.ball, this);
                sq.create();
                this.obstacle_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, sq.getGrp());
                items.add(sq);
                obstacles.add(sq);
                Star st = new Star(this.str_pos,this);
                st.create();
                this.str_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, st.getGrp());
                items.add(st);
                stars.add(st);
                ColorChanger clr = new ColorChanger(this.clr_pos, this);
                clr.create();
                this.clr_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, clr.getGrp());
                items.add(clr);
                clrs.add(clr);
            } else if (random==1) {
                RingObs ri = new RingObs(this.obstacle_pos, this.ball, this);
                ri.create();
                this.obstacle_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, ri.getGrp());
                items.add(ri);
                obstacles.add(ri);
                Star st = new Star(this.str_pos,this);
                st.create();
                this.str_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, st.getGrp());
                items.add(st);
                stars.add(st);
                ColorChanger clr = new ColorChanger(this.clr_pos, this);
                clr.create();
                this.clr_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, clr.getGrp());
                items.add(clr);
                clrs.add(clr);
            } else if (random==2) {
                CrossObs cr = new CrossObs(this.obstacle_pos, this.ball, this);
                cr.create();
                this.obstacle_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, cr.getGrp());
                items.add(cr);
                obstacles.add(cr);
                Star st = new Star(this.str_pos,this);
                st.create();
                this.str_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, st.getGrp());
                items.add(st);
                stars.add(st);
                ColorChanger clr = new ColorChanger(this.clr_pos, this);
                clr.create();
                this.clr_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, clr.getGrp());
                items.add(clr);
                clrs.add(clr);
            } else if (random==3) {
                LineObs li = new LineObs(this.obstacle_pos, 1, this.ball, this);
                li.create();
                this.obstacle_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, li.getGrp());
                items.add(li);
                obstacles.add(li);
                Star st = new Star(this.str_pos, this);
                st.create();
                this.str_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, st.getGrp());
                items.add(st);
                stars.add(st);
                ColorChanger clr = new ColorChanger(this.clr_pos, this);
                clr.create();
                this.clr_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, clr.getGrp());
                items.add(clr);
                clrs.add(clr);
            }
            else if(random==4){
                DoubleCrossObs dc=new DoubleCrossObs(this.obstacle_pos, this.ball, this);
                dc.create();
                this.obstacle_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, dc.getGrp());
                items.add(dc);
                obstacles.add(dc);
                Star st = new Star(this.str_pos, this);
                st.create();
                this.str_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, st.getGrp());
                items.add(st);
                stars.add(st);
                ColorChanger clr = new ColorChanger(this.clr_pos, this);
                clr.create();
                this.clr_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, clr.getGrp());
                items.add(clr);
                clrs.add(clr);
            }
            else if(random==5){
                DoubleRingObs dr=new DoubleRingObs(this.obstacle_pos, this.ball, this);
                dr.create();
                this.obstacle_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, dr.getGrp());
                items.add(dr);
                obstacles.add(dr);
                Star st = new Star(this.str_pos, this);
                st.create();
                this.str_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, st.getGrp());
                items.add(st);
                stars.add(st);
                ColorChanger clr = new ColorChanger(this.clr_pos, this);
                clr.create();
                this.clr_pos -= 300;
                canvas.getChildren().add(canvas.getChildren().size() - 3, clr.getGrp());
                items.add(clr);
                clrs.add(clr);
            }
        }
    }

    public void load_game() throws FileNotFoundException {
        canvas.setLayoutY(this.translate);
        ArrayList<Obstacle> obs=new ArrayList<>();
        ArrayList<Star> strs=new ArrayList<>();
        ArrayList<ColorChanger> cls=new ArrayList<>();
        ArrayList<Object> itms=new ArrayList<>();
        this.ball=new Ball(this.ball.getCenterX(),this.ball.getCenterY(),this.ball.getRadius(),this);
        this.ball.create(canvas);
        for(Object i:this.items){
            if(i instanceof SquareObs) {
                i=new SquareObs(((SquareObs) i).getPos(),this.ball,this);
                ((SquareObs)i).create();
                obs.add(((SquareObs)i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((SquareObs)i).getGrp());
            }
            else if(i instanceof RingObs){
                i=new RingObs((((RingObs) i).getPos()), this.ball,this);
                ((RingObs) i).create();
                obs.add(((RingObs) i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((RingObs) i).getGrp());
            }
            else if(i instanceof CrossObs){
                i=new CrossObs((((CrossObs) i).getPos()), this.ball,this);
                ((CrossObs) i).create();
                obs.add(((CrossObs) i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((CrossObs) i).getGrp());
            }
            else if(i instanceof LineObs){
                i=new LineObs((((LineObs) i).getPos()),((LineObs) i).getOrientation(), this.ball,this);
                ((LineObs) i).create();
                obs.add(((LineObs) i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((LineObs) i).getGrp());
            }
            else if(i instanceof DoubleRingObs){
                i=new DoubleRingObs((((DoubleRingObs) i).getPos()), this.ball,this);
                ((DoubleRingObs) i).create();
                obs.add(((DoubleRingObs) i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((DoubleRingObs) i).getGrp());
            }
            else if(i instanceof DoubleCrossObs){
                i=new DoubleCrossObs((((DoubleCrossObs) i).getPos()), this.ball,this);
                ((DoubleCrossObs) i).create();
                obs.add(((DoubleCrossObs) i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((DoubleCrossObs) i).getGrp());
            }
            else if(i instanceof ColorChanger){

                i=new ColorChanger(((ColorChanger) i).getPos(),this);
                ((ColorChanger) i).create();
                cls.add(((ColorChanger) i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((ColorChanger) i).getGrp());
            }
            else if(i instanceof Star){
                i=new Star(((Star) i).getPos(),this);
                ((Star) i).create();
                strs.add(((Star) i));
                itms.add(i);
                canvas.getChildren().add(canvas.getChildren().size()-3,((Star) i).getGrp());
            }

        }
        activate_event_handlers();
        this.clrs=cls;
        this.obstacles=obs;
        this.stars=strs;
        this.items=itms;
        GameManager.getScr().setText(String.valueOf(this.score));
        GameManager.getGuiStage().setScene(GameManager.getPlay_screen());
        Timeline add2=new Timeline(new KeyFrame(Duration.millis(10),e-> {
            try {
                play_game();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }));
        add2.setCycleCount(Timeline.INDEFINITE);
        add2.play();
    }
    public void activate_event_handlers(){
        scene.setOnKeyPressed(keyEvent -> {
            if(pause_stat==0)
                ball.make_jump();
        });
        scene.setOnKeyReleased(keyEvent -> {
            if(pause_stat==0)
                ball.make_move();
        });
        GameManager.getPausebtn().setOnMouseClicked(mouseEvent -> {
            for (Obstacle i:obstacles){
                i.animation_pause();
            }
            pause_stat=1;
            ball.getUp().pause();
            ball.getDown().pause();
            GameManager.getGuiStage().setScene(GameManager.getPause_screen());
        });
        GameManager.getPausebtn().setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode()== KeyCode.P){
                for (Obstacle i:obstacles){
                    i.animation_pause();
                }
                pause_stat=1;
                ball.getUp().pause();
                ball.getDown().pause();
                GameManager.getGuiStage().setScene(GameManager.getPause_screen());
            }
        });
        GameManager.getBack().setOnMouseClicked(new EventHandler<MouseEvent>(){
            int var=3;
            Label timer;
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameManager.getGuiStage().setScene(GameManager.getPlay_screen());
                timer=new Label("3");
                timer.setTextFill(Color.WHITE);
                timer.setFont(new Font("System Bold Italic",50));
                timer.setLayoutX(133);
                timer.setLayoutY(220-translate);
                GameManager.getPlay().getChildren().add(timer);

                Timeline t=new Timeline(new KeyFrame(Duration.millis(1000),e->times()));
                t.setCycleCount(3);
                t.play();

            }

            public void times() {
                if(var!=1){
                    var--;
                    timer.setText(String.valueOf(var));

                }
                else{
                    var=3;
                    GameManager.getPlay().getChildren().removeAll(timer);
                    for(Obstacle i:obstacles){
                        i.animation_play();
                    }
                    ball.getDown().play();
                    pause_stat=0;
                }
            }
        });

        GameManager.getSave_game().setOnMouseClicked(mouseEvent -> {
            try {
                save_game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Timeline add=new Timeline(new KeyFrame(Duration.millis(10),e-> {
            try {
                play_game();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }));
        add.setCycleCount(Timeline.INDEFINITE);
        add.play();
    }
    public void hit_detected(){
        for (Obstacle i:obstacles){
            i.animation_pause();
        }

        Label over=new Label("Game over");
        over.setTextFill(Color.WHITE);
        over.setFont(new Font("System Bold Italic",50));
        over.setLayoutX(25);
        over.setLayoutY(220-translate);
        GameManager.getPlay().getChildren().add(over);
        Timeline t=new Timeline(new KeyFrame(Duration.millis(1500)));
        t.setCycleCount(1);
        t.play();
        t.setOnFinished(actionEvent -> {
            GameManager.getPlay().getChildren().remove(over);
            GameManager.getGuiStage().setScene(GameManager.getHit_screen());
        });


        GameManager.getUse().setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if(score>=5) {
                    score -= 5;
                    GameManager.getScr().setText(String.valueOf(score));
                    ball.getBall().setCenterY(ball.getBall().getCenterY() + 50);
                    for (Obstacle i : obstacles) {
                        i.animation_play();
                        i.getHit().play();
                    }
                    GameManager.getGuiStage().setScene(GameManager.getPlay_screen());
                    pause_stat = 0;
                }
                else{
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    ImageView icon=new ImageView("sample/images/insuf.png");
                    icon.setFitHeight(48);
                    icon.setFitWidth(48);
                    alert.getDialogPane().setGraphic(icon);
                    alert.setHeaderText("Insufficient stars!!!");
                    alert.setContentText("You should have atleast 5 stars to use this feature.");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
                    alert.show();
                }

            }
        });
    }

    public void save_game() throws IOException {
        Date d1=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        this.gameName=formatter.format(d1);
        this.translate=canvas.getLayoutY();
        this.ball.setCenterY(this.ball.getBall().getCenterY());
        GameManager.getSave_games().add(this);
        if(GameManager.getSave_games().size()>6)
            GameManager.getSave_games().remove(0);
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("src/sample/saved_games/savegames.txt"));
        out.writeObject(GameManager.getSave_games());
        out.close();
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        ImageView icon=new ImageView("sample/images/save_icon.png");
        icon.setFitHeight(48);
        icon.setFitWidth(48);
        alert.getDialogPane().setGraphic(icon);
        alert.setHeaderText("Game saved");
        alert.setContentText("Your current game has been saved.");
        alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
        alert.show();
    }

}
