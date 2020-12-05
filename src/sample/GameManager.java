package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.*;

public class GameManager {



    private static Game game;
    GameManager() throws IOException {
        game=new Game();
    }
    public static void new_game() throws IOException {
        game=new Game();
        game.new_game();

    }
    public void start_game(Stage primaryStage){
        primaryStage.setScene(Main.main_screen);
        primaryStage.show();
        Main.new_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Main.make_play();
                    new_game();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Main.load_game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.getStage().setScene(Main.load_screen);
                try {
                    load_game();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        Main.exit.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });
    }





    public static void load_game() throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("saves.txt"));
        game=(Game)in.readObject();
        double t=game.getTranslate();
        System.out.println(game.getBall().getCenterY());
        double cent=game.getBall().getCenterY();
        game=new Game(game.getScore(),game.getClrs(),game.getStars(),game.getObstacles(),game.getItems(),cent,game.getTranslate(),game.getObstacle_pos(),game.getClr_pos(),game.getStr_pos());
        game.setTranslate(t);
        game.load_game();
//        ArrayList<Obstacle> obs=new ArrayList<>();
//        ArrayList<Star> strs=new ArrayList<>();
//        ArrayList<ColorChanger> cls=new ArrayList<>();
//        ArrayList<Object> itms=new ArrayList<>();
//        if(game.items==null){
//            System.out.println("NULL");
//        }


    }
}
