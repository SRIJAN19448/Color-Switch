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
        canvas = new Pane();
        Scene scene=new Scene(canvas, 300, 500);
        scene.setFill(Color.BLACK);

        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        canvas.setBackground(background);
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        primaryStage.show();

//        circle= new Circle(10);
//        circle.setFill(Color.DARKMAGENTA);
//        circle.relocate(150-circle.getRadius(),450-circle.getRadius());
//        arc=new Arc[4];
//        arc[0]=new Arc(150,250,70,70,0,78);
//        arc[0].setStrokeWidth(15);
//        arc[0].setType(ArcType.OPEN);
//        arc[0].setStroke(Color.DARKVIOLET);
//
//        arc[1]=new Arc(150,250,70,70,90,78);
//        arc[1].setStrokeWidth(15);
//        arc[1].setType(ArcType.OPEN);
//        arc[1].setStroke(Color.YELLOW);
//
//        arc[2]=new Arc(150,250,70,70,180,78);
//        arc[2].setStrokeWidth(15);
//        arc[2].setType(ArcType.OPEN);
//        arc[2].setStroke(Color.CYAN);
//
//        arc[3]=new Arc(150,250,70,70,270,78);
//        arc[3].setStrokeWidth(15);
//        arc[3].setType(ArcType.OPEN);
//        arc[3].setStroke(Color.DARKMAGENTA);
//
//        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(5),new KeyValue(arc[0].startAngleProperty(),360),new KeyValue(arc[1].startAngleProperty(),450),new KeyValue(arc[2].startAngleProperty(),540),new KeyValue(arc[3].startAngleProperty(),630)));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//        canvas.getChildren().addAll(arc[0],arc[1],arc[2],arc[3]);

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

//        LineObs line2=new LineObs(350,-1);
//        line2.create(canvas);


//        TriangleObs tri=new TriangleObs();
//        tri.create(canvas);

        


        ArrayList<ColorChanger> clrs=new ArrayList<>();
        clrs.add(clr);
        clrs.add(clr2);
        clrs.add(clr3);
        clrs.add(clr4);
        Ball ball=new Ball(150,490,10,canvas);
        ball.create(canvas,clrs);

        bounds=canvas.getBoundsInLocal();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
//                ball.down.pause();
                ball.make_jump();
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
//                ball.up.pause();
//                ball.down.play();
                ball.make_move();
            }
        });

    }



    public static void main(String[] args) {
        launch(args);
    }


}
