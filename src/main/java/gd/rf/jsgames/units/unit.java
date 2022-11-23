package gd.rf.jsgames.units;

import gd.rf.jsgames.tiles.Tile;

public class Unit {
    public float x, y;
    public Tile tileOn;
    public String iconPath = "src/main/resources/units/settler.png";

    public Unit(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void updateTile(Tile a) {
        this.tileOn = a;
    }

    public float x() {
        return tileOn.x;
    }

    public float y() {
        return tileOn.y;
    }

    public void setIcon(String s) {
        iconPath = s;
    }
}
