package gd.rf.jsgames.units;
import gd.rf.jsgames.structures.City;
import gd.rf.jsgames.ObjectManager;

public class Settler extends Unit {
    public Settler(float x, float y) {
        super(x, y);
        iconPath = "src/main/resources/units/settler.png";
    }
    @Override
    public void action(ObjectManager om){
      City tmp = new City(this.x, this.y);
      om.cities.add(tmp);
      this.iconPath = "";
      this.x = -1;
      this.y = -1;
    }
    // public void update(){
      
    // }
}
