package gd.rf.jsgames.tiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import gd.rf.jsgames.Constants;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.image.Image;

/*
  TILE TYPES:
    [0] GRASS
    [1] DESERT
    [2] SNOW
    [3] RIVER
*/

public class Tile {
    private static final int TILE_SIZE = Constants.TILE_SIZE;
    private static final int BOARD_X = Constants.BOARD_X;
    private static final int BOARD_Y = Constants.BOARD_Y;

    public double x, y;
    // Size defaults to 30;
    public final double size;

    // Default icon is grass
    public String unSelectedPath = "tiles/grass.png";
    public String selectedPath = "tiles/grass_selected.png";
    public String path = selectedPath;
    // Defaults to grass icon
    public Node node = FXGL.getAssetLoader().loadTexture(path);
    public boolean selected = false;

    public Tile(double x, double y) {
        this.size = 30;
        this.x = x;
        this.y = y;
    }

    public String img() {
        return path;
    }

    public void setImg(String _p) {
        path = _p;
    }

    public void changeSelected() throws FileNotFoundException {
        if (selected) {
            selected = false;
            path = unSelectedPath;
        } else {
            selected = true;
            path = selectedPath;
        }
    }

    public Entity toEntity() {
        node = FXGL.getAssetLoader().loadTexture(path);
        return new EntityBuilder().at(Constants.TILE_SIZE * x, Constants.TILE_SIZE * y).view(node).build();
    }
}