package gd.rf.jsgames.tiles;

/*
  TILE TYPES:
    [0] GRASS
    [1] DESERT
    [2] SNOW
    [3] RIVER
*/

public class Tile {
    public float x, y;
    // Default icon is grass
    public String unSelectedPath = "src/main/resources/tiles/grass.png";
    public String selectedPath = "src/main/resources/tiles/grass_selected.png";

    // Defaults to grass icon
    public String iconPath = "src/main/resources/tiles/grass.png";
    public boolean selected = false;

    public Tile(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String img() {
        return iconPath;
    }

    public void setImg(String _p) {
        iconPath = _p;
    }

    public void changeSelected() {
        if (selected) {
            selected = false;
            iconPath = unSelectedPath;
        } else {
            selected = true;
            iconPath = selectedPath;
        }
    }
}
