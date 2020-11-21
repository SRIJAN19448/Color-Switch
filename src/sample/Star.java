package sample;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class Star implements Special{
Group grp;

    @Override
    public int special(double posY, Circle ball) {
        return 0;
    }
}
