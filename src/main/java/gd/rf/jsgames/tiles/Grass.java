package gd.rf.jsgames.tiles;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Grass extends Tile {
    // Already has x and y

    public Grass(float x, float y) {
        super(x, y);
        // this.setImg("src/main/resources/tiles/grass.png");
        this.setImg("src/main/resources/units/settler.png");
    }
}
