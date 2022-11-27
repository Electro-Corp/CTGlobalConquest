package gd.rf.jsgames.tiles;

import java.io.FileNotFoundException;

public class Grass extends Tile {
    // Already has x and y

    public Grass(double x, double y) {
        super(x, y);

        setImg("tiles/grass.png");
        unSelectedPath = "tiles/grass.png";
        selectedPath = "tiles/grass_selected.png";
    }
} 