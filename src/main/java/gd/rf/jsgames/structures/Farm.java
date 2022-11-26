package gd.rf.jsgames.structures;
import gd.rf.jsgames.tiles.Tile;
public class Farm{
  public float x, y;
  Tile base;
  int level;
  // base level image
  public String iconPath = "src/main/resources/structures/farm.png";
  public Farm(float x, float y){
    this.x = x;
    this.y = y;
  }

  public void update(){
    
  }
}