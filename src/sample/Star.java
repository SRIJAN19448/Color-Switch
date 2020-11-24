package sample;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Star implements Special, Serializable {
Group grp;

    @Override
    public int special(double posY, Circle ball) {
        return 0;
    }
}
