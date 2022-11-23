package gd.rf.jsgames;
import java.util.ArrayList;
import gd.rf.jsgames.structures.City;
import gd.rf.jsgames.units.Settler;
import gd.rf.jsgames.tiles.Tile;
public class ObjectManager{
  public ArrayList<Settler> settlers = new ArrayList<Settler>();
  public ArrayList<City> cities = new ArrayList<City>();
  public Tile[][] omBoard;
  public ObjectManager(Tile[][] omBoard){
    this.omBoard = omBoard;
  }
  public void updateObjects(){
    // update settlers
    for(int i = 0; i < settlers.size(); i++){
      this.settlers.get(i).update();
    }
    // update cites
    for(int i = 0; i < cities.size(); i++){
      this.cities.get(i).update();
    }
  }
  public void handleMouse(int x, int y){
    for(int height = 0; height < 16; height++){
      for(int width = 0; width < 16; width++){
        if(omBoard[height][width].x == x && omBoard[height][width].y == y)
          System.out.println(omBoard[height][width]);
      }
    }
  }
}