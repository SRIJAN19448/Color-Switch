package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;


public class Main extends Application {
    private static Stage guiStage;

    public static Stage getStage() {
        return guiStage;
    }
    public void jump(Bounds bounds){
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(0.75),new KeyValue(circle.layoutYProperty(),bounds.getMinY()+circle.getRadius())));
        //timeline.setCycleCount(1);
        timeline.play();
    }
    public void move_ball(Bounds bounds){
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(3),new KeyValue(circle.layoutYProperty(),bounds.getMaxY()-circle.getRadius())));
        //timeline.setCycleCount(1);
        timeline.play();
    }

    public static Circle circle;
    public static Arc arc[];
    public static Rectangle rectangle;
    public static Pane canvas;
    public static Bounds bounds;
    @Override
    public void start(Stage primaryStage) throws Exception{

        GameManager gm=new GameManager();
        gm.start_game(primaryStage);


//        canvas = new Pane();
//        Scene scene=new Scene(canvas, 300, 500);
//        scene.setFill(Color.BLACK);
//
//        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
//        Background background=new Background(background_fill);
//        canvas.setBackground(background);
//        primaryStage.setTitle("Color Switch");
//        primaryStage.setScene(scene);
//        primaryStage.show();

//        SquareObs square=new SquareObs(250);
//        square.create(canvas);
//        ColorChanger clr=new ColorChanger(100,canvas);
//        clr.create(canvas);
//        RingObs ring=new RingObs(-50);
//        ring.create(canvas);
//        ColorChanger clr2=new ColorChanger(-200,canvas);
//        clr2.create(canvas);
//        CrossObs cross=new CrossObs(-350);
//        cross.create(canvas);
//        ColorChanger clr3=new ColorChanger(-500,canvas);
//        clr3.create(canvas);
//        LineObs line=new LineObs(-650,1);
//        line.create(canvas);
//        ColorChanger clr4=new ColorChanger(-800,canvas);
//        clr4.create(canvas);
//
//        ArrayList<ColorChanger> clrs=new ArrayList<>();
//        clrs.add(clr);
//        clrs.add(clr2);
//        clrs.add(clr3);
//        clrs.add(clr4);
//        Ball ball=new Ball(150,490,10,canvas);
//        ball.create(canvas,clrs);
//
//        bounds=canvas.getBoundsInLocal();
//
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                ball.make_jump();
//            }
//        });
//        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//
//                ball.make_move();
//            }
//        });

    }



    public static void main(String[] args) {
        launch(args);
    }


}
