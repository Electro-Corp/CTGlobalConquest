package gd.rf.jsgames.units;
import gd.rf.jsgames.tiles.Tile;
public class unit{
  public float x,y;
  public Tile tileOn; 
  public String settlerImagePath = "src/main/resources/units/settler.png";

  public unit(float x, float y){
    this.x = x;
    this.y = y;
    
  }
  public void updateTile(Tile a){
    this.tileOn = a; 
  }
}
