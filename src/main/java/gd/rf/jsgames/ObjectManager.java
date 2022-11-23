package gd.rf.jsgames;
import java.util.ArrayList;
import gd.rf.jsgames.structures.City;
import gd.rf.jsgames.units.Settler;
public class ObjectManager{
  public ArrayList<Settler> settlers = new ArrayList<Settler>();
  public ArrayList<City> cities = new ArrayList<City>();

  public ObjectManager(){
    
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
}