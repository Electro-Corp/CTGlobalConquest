package gd.rf.jsgames.units;

import gd.rf.jsgames.ObjectManager;
import gd.rf.jsgames.structures.Farm;

public class Builder extends Unit {
  public Builder(float x, float y) {
    super(x, y);
    iconPath = "src/main/resources/units/builder.png";
  }

  @Override
  public void action(ObjectManager om) {
    Farm tmp = new Farm(this.x, this.y);
    om.farms.add(tmp);
    this.iconPath = "";
    this.x = -1;
    this.y = -1;
  }
  // public void update(){

  // }
}
