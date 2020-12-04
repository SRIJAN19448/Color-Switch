package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Game implements Serializable {
    transient static Scene scene;
    transient static Pane canvas;
    double translate;
    ArrayList<Obstacle> obstacles;
    Ball ball;
    ArrayList<ColorChanger> clrs;
    ArrayList<Star> stars;
    int pause_stat;
    Integer score;
    int clr_pos;
    int obstacle_pos;
    int str_pos;
    ArrayList<Object> items;
//    int flag=1;
    public Game() throws IOException {
//        this.translate=0;
        this.score=0;
        this.obstacle_pos=250;
        this.clr_pos=100;
        this.str_pos=225;
        this.canvas=Main.play;
        this.ball=new Ball(150,490,10,this.canvas,0,this);
        this.pause_stat=0;
        this.scene=Main.play_screen;
        this.obstacles=new ArrayList<>();
        this.clrs=new ArrayList<>();
        this.stars=new ArrayList<>();
        this.items=new ArrayList<>();

    }
    public Game(int score,ArrayList<ColorChanger> clrs,ArrayList<Star> stars,ArrayList<Obstacle> obstacles,ArrayList<Object> item,double centY,double trans,double base,int ob_ps,int cl_ps,int st_ps){
        this.score=score;
        this.translate=trans;
        this.obstacle_pos=ob_ps;
        this.clr_pos=cl_ps;
        this.str_pos=st_ps;
        this.canvas=Main.play;
        this.ball=new Ball(150,centY,10,this.canvas,base,this);
        this.pause_stat=0;
        this.scene=Main.play_screen;
        this.clrs=clrs;
        this.stars=stars;
        this.obstacles=obstacles;
        this.items=item;
    }

    public void new_game() throws IOException {

        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        canvas.setBackground(background);
        Main.getStage().setScene(scene);

        SquareObs square=new SquareObs(this.obstacle_pos,this.ball,this);
        square.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,square.grp);
        this.obstacle_pos-=300;
        Star st=new Star(225,canvas,ball,this,this.stars,this.items);
        st.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,st.grp);
        this.str_pos-=300;
        ColorChanger clr=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
        clr.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,clr.g);
        this.clr_pos-=300;
        RingObs ring=new RingObs(this.obstacle_pos,this.ball,this);
        ring.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,ring.grp);
        this.obstacle_pos-=300;
        Star st1=new Star(-75,canvas,ball,this,this.stars,this.items);
        st1.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,st1.grp);
        this.str_pos-=300;
        ColorChanger clr2=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
        clr2.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,clr2.g);
        this.clr_pos-=300;
        CrossObs cross=new CrossObs(this.obstacle_pos,this.ball,this);
        cross.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,cross.grp);
        this.obstacle_pos-=300;
        Star st2=new Star(-375,canvas,ball,this,this.stars,this.items);
        st2.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,st2.grp);
        this.str_pos-=300;
        ColorChanger clr3=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
        clr3.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,clr3.g);
        this.clr_pos-=300;
        LineObs line=new LineObs(this.obstacle_pos,1,this.ball,this);
        line.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,line.grp);
        this.obstacle_pos-=300;
        Star st3=new Star(-675,canvas,ball,this,this.stars,this.items);
        st3.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,st3.grp);
        this.str_pos-=300;
        ColorChanger clr4=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
        clr4.create();
        canvas.getChildren().add(canvas.getChildren().size()-2,clr4.g);
        this.clr_pos-=300;
        System.out.println("->");


        items.add(square);
        items.add(clr);
        items.add(ring);
        items.add(clr2);
        items.add(cross);
        items.add(clr3);
        items.add(line);
        items.add(clr4);
        items.add(st);
        items.add(st1);
        items.add(st2);
        items.add(st3);


        obstacles.add(square);
        obstacles.add(ring);
        obstacles.add(cross);
        obstacles.add(line);


        clrs.add(clr);
        clrs.add(clr2);
        clrs.add(clr3);
        clrs.add(clr4);

        stars.add(st);
        stars.add(st1);
        stars.add(st2);
        stars.add(st3);
        ball.create(canvas);
        for(Node n:canvas.getChildren()){

            Bounds s=n.getBoundsInLocal();
            System.out.println((double)(((s.getMinY()+s.getMaxY())/2)+canvas.getTranslateY()));
        }
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(pause_stat==0)
                    ball.make_jump();
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(pause_stat==0)
                    ball.make_move();
            }
        });
        Main.pausebtn.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                for (Obstacle i:obstacles){
                    i.animation_pause();
                }
                pause_stat=1;
                ball.up.pause();
                ball.down.pause();
//                obstacles.get(1).animation_pause();
                Main.getStage().setScene(Main.pause_screen);
            }
        });
        Main.back.setOnMouseClicked(new EventHandler<MouseEvent>(){
            int var=3;
            Label timer;
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().setScene(Main.play_screen);
                timer=new Label("3");
                timer.setTextFill(Color.WHITE);
                timer.setFont(new Font("System Bold Italic",50));
                timer.setLayoutX(133);
                timer.setLayoutY(220-canvas.getTranslateY());
                Main.play.getChildren().add(timer);

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
                    Main.play.getChildren().removeAll(timer);
                    for(Obstacle i:obstacles){
                        i.animation_play();
                    }
                    ball.down.play();
                    pause_stat=0;
//                    obstacles.get(0).animation_play();
                }
            }
        });
        Main.save_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    save_game();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
    public void play_game() throws FileNotFoundException {
//        System.out.println("size : "+this.items.size());
        Node n=canvas.getChildren().get(0);
        Bounds s=n.getBoundsInLocal();
        Object rem=new Object();
        if((double)(((s.getMinY()+s.getMaxY())/2)+canvas.getLayoutY())>=(double)600){
            canvas.getChildren().remove(n);
            rem=this.items.get(0);
            this.items.remove(0);
            this.obstacles.remove((Obstacle)rem);

        }
//        if(this.items.size()!=8){
            if(rem instanceof SquareObs){
                ((SquareObs)rem).hit.stop();
                SquareObs sq=new SquareObs(this.obstacle_pos,this.ball,this);
                sq.create();
                this.obstacle_pos-=300;
//                System.out.println("index: "+canvas.getChildren().indexOf(sq.grp));
                canvas.getChildren().add(canvas.getChildren().size()-3,sq.grp);
                items.add(sq);
                obstacles.add(sq);
                Star st=new Star(this.str_pos,this.canvas,this.ball,this,this.stars,this.items);
                st.create();
                this.str_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,st.grp);
                items.add(st);
                stars.add(st);
                ColorChanger clr=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
                clr.create();
                this.clr_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,clr.g);
                items.add(clr);
                clrs.add(clr);
            }
            else if(rem instanceof RingObs){
                ((RingObs)rem).hit.stop();
                RingObs ri=new RingObs(this.obstacle_pos,this.ball,this);
                ri.create();
                this.obstacle_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,ri.grp);
                items.add(ri);
                obstacles.add(ri);
                Star st=new Star(this.str_pos,this.canvas,this.ball,this,this.stars,this.items);
                st.create();
                this.str_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,st.grp);
                items.add(st);
                stars.add(st);
                ColorChanger clr=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
                clr.create();
                this.clr_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,clr.g);
                items.add(clr);
                clrs.add(clr);
            }
            else if(rem instanceof CrossObs){
                ((CrossObs)rem).hit.stop();
                CrossObs cr=new CrossObs(this.obstacle_pos,this.ball,this);
                cr.create();
                this.obstacle_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,cr.grp);
                items.add(cr);
                obstacles.add(cr);
                Star st=new Star(this.str_pos,this.canvas,this.ball,this,this.stars,this.items);
                st.create();
                this.str_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,st.grp);
                items.add(st);
                stars.add(st);
                ColorChanger clr=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
                clr.create();
                this.clr_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,clr.g);
                items.add(clr);
                clrs.add(clr);
            }
            else if(rem instanceof LineObs){
                ((LineObs)rem).hit.stop();
                LineObs li=new LineObs(this.obstacle_pos,1,this.ball,this);
                li.create();
                this.obstacle_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,li.grp);
                items.add(li);
                obstacles.add(li);
                Star st=new Star(this.str_pos,this.canvas,this.ball,this,this.stars,this.items);
                st.create();
                this.str_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,st.grp);
                items.add(st);
                stars.add(st);
                ColorChanger clr=new ColorChanger(this.clr_pos,this.ball,this,this.clrs,this.items);
                clr.create();
                this.clr_pos-=300;
                canvas.getChildren().add(canvas.getChildren().size()-3,clr.g);
                items.add(clr);
                clrs.add(clr);
            }
    }

    public void load_game() throws FileNotFoundException {
        Game.canvas.setLayoutY(this.translate);
        ArrayList<Obstacle> obs=new ArrayList<>();
        ArrayList<Star> strs=new ArrayList<>();
        ArrayList<ColorChanger> cls=new ArrayList<>();
        ArrayList<Object> itms=new ArrayList<>();
        this.ball=new Ball(this.ball.centerX,this.ball.centerY,this.ball.radius,Main.play,this.ball.base,this);
        this.ball.create(Game.canvas);
//        this.ball.ball.setTranslateY(-this.translate);
        for(Object i:this.items){
            if(i instanceof SquareObs) {
                i=new SquareObs(((SquareObs) i).pos,this.ball,this);
                ((SquareObs)i).create();
                obs.add(((SquareObs)i));
                itms.add(i);
                Game.canvas.getChildren().add(canvas.getChildren().size()-3,((SquareObs)i).grp);
            }
            else if(i instanceof RingObs){
                i=new RingObs((((RingObs) i).pos), this.ball,this);
                ((RingObs) i).create();
                obs.add(((RingObs) i));
                itms.add(i);
                Game.canvas.getChildren().add(canvas.getChildren().size()-3,((RingObs) i).grp);
            }
            else if(i instanceof CrossObs){
                i=new CrossObs((((CrossObs) i).pos), this.ball,this);
                ((CrossObs) i).create();
                obs.add(((CrossObs) i));
                itms.add(i);
                Game.canvas.getChildren().add(canvas.getChildren().size()-3,((CrossObs) i).grp);
            }
            else if(i instanceof LineObs){
                i=new LineObs((((LineObs) i).pos),((LineObs) i).orientation, this.ball,this);
                ((LineObs) i).create();
                obs.add(((LineObs) i));
                itms.add(i);
                Game.canvas.getChildren().add(canvas.getChildren().size()-3,((LineObs) i).grp);
            }
            else if(i instanceof ColorChanger){

                i=new ColorChanger(((ColorChanger) i).pos, this.ball,this,this.clrs,this.items);
                ((ColorChanger) i).create();
                cls.add(((ColorChanger) i));
                itms.add(i);
                Game.canvas.getChildren().add(canvas.getChildren().size()-3,((ColorChanger) i).g);
            }
            else if(i instanceof Star){
                i=new Star(((Star) i).pos,canvas,this.ball,this,this.stars,this.items);
                ((Star) i).create();
                strs.add(((Star) i));
                itms.add(i);
                Game.canvas.getChildren().add(canvas.getChildren().size()-3,((Star) i).grp);
            }

        }
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(pause_stat==0)
                    ball.make_jump();
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(pause_stat==0)
                    ball.make_move();
            }
        });
        Main.pausebtn.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                for (Obstacle i:obstacles){
                    i.animation_pause();
                }
                pause_stat=1;
                ball.up.pause();
                ball.down.pause();
//                obstacles.get(1).animation_pause();
                Main.getStage().setScene(Main.pause_screen);
            }
        });
        Main.back.setOnMouseClicked(new EventHandler<MouseEvent>(){
            int var=3;
            Label timer;
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().setScene(Main.play_screen);
                timer=new Label("3");
                timer.setTextFill(Color.WHITE);
                timer.setFont(new Font("System Bold Italic",50));
                timer.setLayoutX(133);
                timer.setLayoutY(220-translate);
                Main.play.getChildren().add(timer);

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
                    Main.play.getChildren().removeAll(timer);
                    for(Obstacle i:obstacles){
                        i.animation_play();
                    }
                    ball.down.play();
                    pause_stat=0;
//                    obstacles.get(0).animation_play();
                }
            }
        });
        Main.save_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    save_game();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        this.clrs=cls;
        this.obstacles=obs;
        this.stars=strs;
        this.items=itms;
        for(ColorChanger i:clrs){
            i.itms=itms;
            i.clrs=cls;
        }
        for(Star i:stars){
            i.itms=itms;
            i.strs=strs;
        }
        System.out.println(this.ball.centerY);
        Main.scr.setText(String.valueOf(this.score));
        Main.getStage().setScene(Main.play_screen);
        this.ball.down.play();
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
    public void pause_game() throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("pause_screen.fxml"));
        Scene scene2=new Scene(root, 300, 500);
        scene2.setFill(Color.BLACK);
        Main.getStage().setScene(scene2);

    }
    public void back(ActionEvent e) {

    }
    public void hit_detected() throws InterruptedException {
        for (Obstacle i:obstacles){
            i.animation_pause();
        }

        Label over=new Label("Game over");
        over.setTextFill(Color.WHITE);
        over.setFont(new Font("System Bold Italic",50));
        over.setLayoutX(133);
        over.setLayoutY(300);
        Main.play.getChildren().add(over);
        TimeUnit.SECONDS.sleep(2);
        Main.play.getChildren().remove(over);
        Main.getStage().setScene(Main.hit_screen);
    }

    public void save_game() throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("saves.txt"));
        System.out.println(canvas.getLayoutY());
//        this.translate=canvas.getLayoutY();
        System.out.println(this.ball.ball.getCenterY());
        this.ball.centerY=this.ball.ball.getCenterY();
        out.writeObject(this);
    }
    public void restart_game(ActionEvent e){

    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
    }

    public void jump(Bounds bounds){
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(0.75),new KeyValue(ball.ball.layoutYProperty(),bounds.getMinY()+ball.ball.getRadius())));
        //timeline.setCycleCount(1);
        timeline.play();
    }
    public void move_ball(Bounds bounds){
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(3),new KeyValue(ball.ball.layoutYProperty(),bounds.getMaxY()-ball.ball.getRadius())));
        //timeline.setCycleCount(1);
        timeline.play();
    }
}
