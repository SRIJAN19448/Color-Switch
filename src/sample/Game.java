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
    int score=0;
    int clr_pos;
    int obstacle_pos;
    ArrayList<Object> items;
    int flag=1;
    public Game() throws IOException {
//        this.translate=0;
        this.obstacle_pos=250;
        this.clr_pos=100;
        this.canvas=Main.play;
        this.ball=new Ball(150,490,10,this.canvas,0);
        this.pause_stat=0;
        this.scene=Main.play_screen;
        this.obstacles=new ArrayList<>();
        this.clrs=new ArrayList<>();
        this.stars=new ArrayList<>();
        this.items=new ArrayList<>();

    }
    public Game(ArrayList<ColorChanger> clrs,ArrayList<Star> stars,ArrayList<Obstacle> obstacles,ArrayList<Object> item,double centY,double trans,double base,int ob_ps,int cl_ps){
        this.translate=trans;
        this.obstacle_pos=ob_ps;
        this.clr_pos=cl_ps;
        this.canvas=Main.play;
        this.ball=new Ball(150,centY,10,this.canvas,base);
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

        SquareObs square=new SquareObs(this.obstacle_pos,this.ball);
        square.create();
        canvas.getChildren().add(square.grp);
        this.obstacle_pos-=300;
        ColorChanger clr=new ColorChanger(this.clr_pos,canvas);
        clr.create();
        canvas.getChildren().add(clr.g);
        this.clr_pos-=300;
        RingObs ring=new RingObs(this.obstacle_pos,this.ball);
        ring.create();
        canvas.getChildren().add(ring.grp);
        this.obstacle_pos-=300;
        ColorChanger clr2=new ColorChanger(this.clr_pos,canvas);
        clr2.create();
        canvas.getChildren().add(clr2.g);
        this.clr_pos-=300;
        CrossObs cross=new CrossObs(this.obstacle_pos,this.ball);
        cross.create();
        canvas.getChildren().add(cross.grp);
        this.obstacle_pos-=300;
        ColorChanger clr3=new ColorChanger(this.clr_pos,canvas);
        clr3.create();
        canvas.getChildren().add(clr3.g);
        this.clr_pos-=300;
        LineObs line=new LineObs(this.obstacle_pos,1,this.ball);
        line.create();
        canvas.getChildren().add(line.grp);
        this.obstacle_pos-=300;
        ColorChanger clr4=new ColorChanger(this.clr_pos,canvas);
        clr4.create();
        canvas.getChildren().add(clr4.g);
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


        obstacles.add(square);
        obstacles.add(ring);
        obstacles.add(cross);
        obstacles.add(line);


        clrs.add(clr);
        clrs.add(clr2);
        clrs.add(clr3);
        clrs.add(clr4);
        ball.create(canvas,clrs);
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
        Timeline add=new Timeline(new KeyFrame(Duration.millis(10),e->play_game()));
        add.setCycleCount(Timeline.INDEFINITE);
        add.play();
    }
    public void play_game(){
        Node n=canvas.getChildren().get(2);
        Bounds s=n.getBoundsInLocal();
        if((double)(((s.getMinY()+s.getMaxY())/2)+canvas.getTranslateY())>=(double)600){
            canvas.getChildren().remove(n);
            this.items.remove(0);
            System.out.println(this.items.size());

        }
            if(this.items.size()!=8){
                if(this.flag==1){
                    SquareObs sq=new SquareObs(this.obstacle_pos,this.ball);
                    sq.create();
                    this.obstacle_pos-=300;
                    System.out.println("index: "+canvas.getChildren().indexOf(sq.grp));
                    canvas.getChildren().add(canvas.getChildren().size()-2,sq.grp);
                    items.add(sq);
                    obstacles.add(sq);
                    this.flag=0;
                }
                else{
                    ColorChanger clr=new ColorChanger(this.clr_pos,canvas);
                    clr.create();
                    this.clr_pos-=300;
                    canvas.getChildren().add(canvas.getChildren().size()-2,clr.g);
                    items.add(clr);
                    clrs.add(clr);
                    this.flag=1;
                }
            }
    }

    public void load_game(){
        ArrayList<Obstacle> obs=new ArrayList<>();
        ArrayList<Star> strs=new ArrayList<>();
        ArrayList<ColorChanger> cls=new ArrayList<>();

        for(Object i:this.items){
            if(i instanceof SquareObs) {
                i=new SquareObs(((SquareObs) i).pos,((SquareObs)i).ball);
                ((SquareObs)i).create();
                obs.add(((SquareObs)i));
                Game.canvas.getChildren().add(((SquareObs)i).grp);
            }
            else if(i instanceof RingObs){
                i=new RingObs((((RingObs) i).pos), ((RingObs) i).ball);
                ((RingObs) i).create();
                obs.add(((RingObs) i));
                Game.canvas.getChildren().add(((RingObs) i).grp);
            }
            else if(i instanceof CrossObs){
                i=new CrossObs((((CrossObs) i).pos), ((CrossObs) i).ball);
                ((CrossObs) i).create();
                obs.add(((CrossObs) i));
                Game.canvas.getChildren().add(((CrossObs) i).grp);
            }
            else if(i instanceof LineObs){
                i=new LineObs((((LineObs) i).pos),((LineObs) i).orientation, ((LineObs) i).ball);
                ((LineObs) i).create();
                obs.add(((LineObs) i));
                Game.canvas.getChildren().add(((LineObs) i).grp);
            }
            else if(i instanceof ColorChanger){

                i=new ColorChanger(((ColorChanger) i).pos, this.canvas);
                ((ColorChanger) i).create();
                cls.add(((ColorChanger) i));
                Game.canvas.getChildren().add(((ColorChanger) i).g);
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
        Timeline add=new Timeline(new KeyFrame(Duration.millis(10),e->play_game()));
        add.setCycleCount(Timeline.INDEFINITE);
        add.play();
        this.clrs=cls;
        this.obstacles=obs;
        this.ball=new Ball(this.ball.centerX,this.ball.centerY,this.ball.radius,Main.play,this.ball.base);
        this.ball.create(Game.canvas,this.clrs);
        this.ball.ball.setTranslateY(-this.translate);
        System.out.println(this.ball.centerY);
        Game.canvas.setTranslateY(this.translate);
        Main.play.getChildren().get(0).setTranslateY(-this.translate);
        Main.play.getChildren().get(1).setTranslateY(-this.translate);
        Main.getStage().setScene(Main.play_screen);
        this.ball.down.play();
    }
    public void pause_game() throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("pause_screen.fxml"));
        Scene scene2=new Scene(root, 300, 500);
        scene2.setFill(Color.BLACK);
        Main.getStage().setScene(scene2);

    }
    public void back(ActionEvent e) {

    }
    public void detetct_hit(){

    }

    public void save_game() throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("saves.txt"));
        this.translate=canvas.getTranslateY();
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
