package gd.rf.jsgames.units;

import gd.rf.jsgames.tiles.Tile;

public class Unit {
    public float x, y;
    public int toX, toY;
    public boolean isMoving = false;
    public Tile tileOn;
    public String iconPath = "src/main/resources/units/settler.png";
    public int health = 100;
    public int moveSpeed = 1;
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
        for(int i = 0; i < moveSpeed; i++){
          if(toX > x)
            x += (toX - x) - ((toX - x) -1);
          else
            x -= (toX - x) - ((toX - x) -1);
          if(toY > y)
            y += (toY - y) - ((toY - y) -1);
          else
            y -= (toY - y) - ((toY - y) -1);
  
          if(x == toX && y == toY)
            isMoving = false;          
          System.out.println(x+","+y);
        }
      }
    }
}
