package gd.rf.jsgames.tiles;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
  TILE TYPES:
    [0] GRASS
    [1] DESERT
    [2] SNOW
    [3] RIVER
*/

public class Tile {
    public float x, y;

    public String icon = "src/main/resources/tiles/grass.png";

    public Tile(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String img() {
        return icon;
    }

    public void setImg(String _p) {
        icon = _p;
    }
}
