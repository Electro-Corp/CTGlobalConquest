package gd.rf.jsgames.structures;
import gd.rf.jsgames.tiles.Tile;
public class Farm extends Structure{
  //public float x, y;
  Tile base;
  int level;
  // base level image
  public String iconPath = "src/main/resources/structures/farm.png";
  public Farm(float x, float y){
    super(x, y);
  }

  public void update(){
    
  }
}