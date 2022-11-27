package gd.rf.jsgames.structures;
import gd.rf.jsgames.tiles.Tile;
public class City extends Structure{
  Tile base;
  int level;
  boolean inProduction;
  // base level image
  public String iconPath = "src/main/resources/structures/city.png";
  public City(float x, float y){
    super(x,y);
  }

  public void update(){
    
  }
}