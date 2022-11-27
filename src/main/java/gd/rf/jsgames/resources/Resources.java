package gd.rf.jsgames.resources;

public class Resources{
  public int amount;
  public int bonus;
  public String name = "DEFAULT_RESOURCE";
  public Resources(){
    
  }
  public int getAmount() {
  	return amount;
  }
  public void setAmount(int amount) {
  	this.amount = amount;
  }
  public int getBonus() {
  	return bonus;
  }
  public void setBonus(int bonus) {
  	this.bonus = bonus;
  }
  public String getName() {
  	return name;
  }
  public void setName(String name) {
  	this.name = name;
  }
}