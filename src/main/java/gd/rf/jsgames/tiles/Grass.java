package gd.rf.jsgames.tiles;

import java.io.FileNotFoundException;

public class Grass extends Tile {
    // Already has x and y

    public Grass(double x, double y) {
        super(x, y);

        setImg("src/main/resources/images/tiles/grass.png");
        unSelectedPath = "src/main/resources/images/tiles/grass.png";
        selectedPath = "src/main/resources/images/tiles/grass_selected.png";
    }
}