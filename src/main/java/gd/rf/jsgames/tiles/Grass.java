package gd.rf.jsgames.tiles;

public class Grass extends Tile {
    // Already has x and y

    public Grass(float x, float y) {
        super(x, y);
        iconPath = "src/main/resources/tiles/grass.png";
        unSelectedPath = "src/main/resources/tiles/grass.png";
        selectedPath = "src/main/resources/tiles/grass_selected.png";
    }
}
