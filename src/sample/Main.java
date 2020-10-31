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

        BackgroundFill background_fill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background=new Background(background_fill);
        canvas.setBackground(background);
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
        circle= new Circle(10);
        circle.setFill(Color.BLUE);
        circle.relocate(135,450);
        arc=new Arc[4];
        arc[0]=new Arc(150,250,70,70,0,90);
        arc[0].setStrokeWidth(10);
        arc[0].setType(ArcType.OPEN);
        arc[0].setStroke(Color.RED);

        arc[1]=new Arc(150,250,70,70,90,90);
        arc[1].setStrokeWidth(10);
        arc[1].setType(ArcType.OPEN);
        arc[1].setStroke(Color.GREEN);
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(1),new KeyValue(arc[0].startAngleProperty(),360)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Timeline timeline1=new Timeline(new KeyFrame(Duration.seconds(1),new KeyValue(arc[1].startAngleProperty(),450)));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
        canvas.getChildren().addAll(arc[0],arc[1]);
        canvas.getChildren().addAll(circle);

        bounds=canvas.getBoundsInLocal();
        //move_ball(bounds);
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent keyEvent) {
                jump(bounds);
            }
        });
        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                move_ball(bounds);
            }
        });

    }



    public static void main(String[] args) {
        launch(args);
    }


}
