package gd.rf.jsgames.structures;
import gd.rf.jsgames.tiles.Tile;
public class City{
  public float x, y;
  Tile base;
  int level;
  boolean inProduction;
  // base level image
  public String img = "src/main/resources/structures/city.png";
  public City(float x, float y){
    this.x = x;
    this.y = y;
  }

  public void update(){
    
  }
}