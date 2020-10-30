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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    public static Rectangle rectangle;
    public static Pane canvas;
    public static Bounds bounds;
    @Override
    public void start(Stage primaryStage) throws Exception{
        canvas = new Pane();
        Scene scene=new Scene(canvas, 300, 500);

        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        canvas.setBackground(background);
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
        circle= new Circle(15);
        circle.setFill(Color.BLUE);
        circle.relocate(135,450);
        rectangle=new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(100);
        rectangle.setX(100);
        rectangle.setY(200);
        rectangle.setStroke(Color.RED);
        RotateTransition r=new RotateTransition();
        r.setAxis(Rotate.Z_AXIS);
        r.setByAngle(360);
        r.setCycleCount(Timeline.INDEFINITE);
        r.setDuration(Duration.millis(4000));
        r.setNode(rectangle);
        r.play();
        canvas.getChildren().addAll(rectangle);
        canvas.getChildren().addAll(circle);

        bounds=canvas.getBoundsInLocal();
        //move_ball(bounds);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.SPACE)
                    jump(bounds);
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.SPACE)
                    move_ball(bounds);
            }
        });
    }



    public static void main(String[] args) {
        launch(args);
    }


}
