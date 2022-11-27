package gd.rf.jsgames.npc;
import gd.rf.jsgames.resources.Resources;
public class Npc{
  public Npc(){
    
  }
  public TradeHolder trade(Resources one, Resources two){
    String value = "This trade is unfair!";
    boolean willDo = false;
    // is it a stupidly easy good deal?
    if(one.bonus < two.bonus){
      value = "We accept. Thank you for the deal.";
      willDo = true;
    }else if(one.amount < two.amount && one.bonus <= two.bonus ){
      value = "We accept. Thank you for the deal.";
      willDo = true;
    }
    return new TradeHolder(value, willDo);
  }
  @Override
  public String toString() {
  	return "Npc []";
  }
}