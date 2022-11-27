package gd.rf.jsgames.tiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/*
  TILE TYPES:
    [0] GRASS
    [1] DESERT
    [2] SNOW
    [3] RIVER
*/

public class Tile {
    public double x, y;
    // Size defaults to 30;
    public final double size;

    // Default icon is grass
    public String unSelectedPath = "src/main/resources/images/tiles/grass.png";
    public String selectedPath = "src/main/resources/images/tiles/grass_selected.png";

    // Defaults to grass icon
    public Image icon;
    public ImageView iconV;
    public boolean selected = false;

    public Tile(double x, double y) throws FileNotFoundException {
        this.size = 30;
        this.x = x;
        this.y = y;
        this.icon = new Image(new FileInputStream(unSelectedPath));
        this.iconV = new ImageView(icon);
        this.update();
    }

    

    public Image img() {
        return icon;
    }

    public void setImg(String _p) throws FileNotFoundException {
        icon = new Image(new FileInputStream(_p));
    }

    public void changeSelected() throws FileNotFoundException {
        if (selected) {
            selected = false;
            icon = new Image(new FileInputStream(unSelectedPath));
        } else {
            selected = true;
            icon = new Image(new FileInputStream(selectedPath));
        }
    }

    public void update() {
        iconV.setX(x);
        iconV.setY(y);
    }
}