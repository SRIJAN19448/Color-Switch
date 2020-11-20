package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameManager implements Initializable {

    @FXML
    Pane pane1;
    @FXML
    Button exit;
    @FXML
    Button load_game;
    @FXML
    Button new_game;
    @FXML
    Arc a1;
    @FXML
    Arc a2;
    @FXML
    Arc a3;
    @FXML
    Arc a4;
    @FXML
    Arc a5;
    @FXML
    Arc a6;
    @FXML
    Arc a7;
    @FXML
    Arc a8;
    @FXML
    Arc a9;
    @FXML
    Arc a10;
    @FXML
    Arc a11;
    @FXML
    Arc a12;
    @FXML
    Arc a13;
    @FXML
    Arc a14;
    @FXML
    Arc a15;
    @FXML
    Arc a16;
    @FXML
    Arc a17;
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Label l3;

    Game game;
    public void new_game(ActionEvent e){
        Pane canvas=new Pane();
        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        canvas.setBackground(background);
        Scene scene=new Scene(canvas, 300, 500);
        scene.setFill(Color.BLACK);
        Main.getStage().setScene(scene);
        SquareObs square=new SquareObs(250);
        square.create(canvas);
        ColorChanger clr=new ColorChanger(100,canvas);
        clr.create(canvas);
        RingObs ring=new RingObs(-50);
        ring.create(canvas);
        ColorChanger clr2=new ColorChanger(-200,canvas);
        clr2.create(canvas);
        CrossObs cross=new CrossObs(-350);
        cross.create(canvas);
        ColorChanger clr3=new ColorChanger(-500,canvas);
        clr3.create(canvas);
        LineObs line=new LineObs(-650,1);
        line.create(canvas);
        ColorChanger clr4=new ColorChanger(-800,canvas);
        clr4.create(canvas);

        ArrayList<ColorChanger> clrs=new ArrayList<>();
        clrs.add(clr);
        clrs.add(clr2);
        clrs.add(clr3);
        clrs.add(clr4);
        Ball ball=new Ball(150,490,10,canvas);
        ball.create(canvas,clrs);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                ball.make_jump();
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                ball.make_move();
            }
        });
    }
    public void load_game(Game g){

    }
    public void start_game(Stage primaryStage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene1 = new Scene(root1, 600, 600);
        scene1.setFill(Color.BLACK);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline timeline1=new Timeline(new KeyFrame(Duration.millis(10), this::rotate1), new KeyFrame(Duration.millis(10), this::rotate2),new KeyFrame(Duration.millis(10), this::rotate3), new KeyFrame(Duration.millis(10), this::rotate4));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();

        Timeline timeline2=new Timeline((new KeyFrame(Duration.millis(1000), this::change_label_colour)));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();
    }

    public void change_label_colour(ActionEvent e){
        double r=Math.random();
        double g=Math.random();
        double b=Math.random();

        l1.setTextFill(Color.color(r,g,b));
        l2.setTextFill(Color.color(r,g,b));
        l3.setTextFill(Color.color(r,g,b));
    }

    public void rotate1(ActionEvent e){
       if(a1.getStartAngle()>=360)
           a1.setStartAngle(0);
       else
           a1.setStartAngle(a1.getStartAngle()+1);

       if(a5.getStartAngle()>=360)
            a5.setStartAngle(0);
       else
            a5.setStartAngle(a5.getStartAngle()+1);

       if(a10.getStartAngle()<=0)
            a10.setStartAngle(360);
       else
            a10.setStartAngle(a10.getStartAngle()-1);

       if(a14.getStartAngle()>=360)
            a14.setStartAngle(0);
       else
            a14.setStartAngle(a14.getStartAngle()+1);
    }

    public void rotate2(ActionEvent e){
        if(a2.getStartAngle()>=360)
            a2.setStartAngle(0);
        else
            a2.setStartAngle(a2.getStartAngle()+1);
        if(a6.getStartAngle()>=360)
            a6.setStartAngle(0);
        else
            a6.setStartAngle(a6.getStartAngle()+1);

        if(a11.getStartAngle()<=0)
            a11.setStartAngle(360);
        else
            a11.setStartAngle(a11.getStartAngle()-1);

        if(a15.getStartAngle()>=360)
            a15.setStartAngle(0);
        else
            a15.setStartAngle(a15.getStartAngle()+1);
    }

    public void rotate3(ActionEvent e){
        if(a3.getStartAngle()>=360)
            a3.setStartAngle(0);
        else
            a3.setStartAngle(a3.getStartAngle()+1);
        if(a7.getStartAngle()>=360)
            a7.setStartAngle(0);
        else
            a7.setStartAngle(a7.getStartAngle()+1);

        if(a12.getStartAngle()<=0)
            a12.setStartAngle(360);
        else
            a12.setStartAngle(a12.getStartAngle()-1);

        if(a16.getStartAngle()>=360)
            a16.setStartAngle(0);
        else
            a16.setStartAngle(a16.getStartAngle()+1);
    }
    public void rotate4(ActionEvent e){
        if(a4.getStartAngle()>=360)
            a4.setStartAngle(0);
        else
            a4.setStartAngle(a4.getStartAngle()+1);
        if(a8.getStartAngle()>=360)
            a8.setStartAngle(0);
        else
            a8.setStartAngle(a8.getStartAngle()+1);

        if(a13.getStartAngle()<=0)
            a13.setStartAngle(360);
        else
            a13.setStartAngle(a13.getStartAngle()-1);

        if(a17.getStartAngle()>=360)
            a17.setStartAngle(0);
        else
            a17.setStartAngle(a17.getStartAngle()+1);
    }

    public void exit(ActionEvent e){
        System.exit(0);
    }



    public void load_game(ActionEvent e) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("save_screen.fxml"));
        Scene scene4=new Scene(root4, 600, 600);
        scene4.setFill(Color.BLACK);
        Main.getStage().setScene(scene4);
    }
}
