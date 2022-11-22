package gd.rf.jsgames.tiles;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Grass extends Tile {
    // Already has x and y

    public Grass(float x, float y) {
        super(x, y);
        super.setImg("src/main/resources/tiles/grass.png");
    }
}
