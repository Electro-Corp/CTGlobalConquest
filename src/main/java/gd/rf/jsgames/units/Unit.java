package gd.rf.jsgames.units;

import gd.rf.jsgames.tiles.Tile;

public class Unit {
    public float x, y;
    public int toX, toY;
    public boolean isMoving = false;
    public Tile tileOn;
    public String iconPath = "src/main/resources/units/settler.png";
    public int health = 100;
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

    public void takeDamage(int m){
      this.health -= 2 * m;
    }

    public void moveTo(int x, int y){
      isMoving = true;
      toX = x;
      toY = y;
    }
    public void update(){
      if(isMoving){
        // do something
      }
    }
}
