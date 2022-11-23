package gd.rf.jsgames;
import java.util.ArrayList;
import gd.rf.jsgames.structures.City;
import gd.rf.jsgames.units.Settler;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.Board;
import javax.swing.*;

public class ObjectManager{
  public ArrayList<Settler> settlers = new ArrayList<Settler>();
  public ArrayList<City> cities = new ArrayList<City>();
  public JLabel[][] omBoard;
  Board gb = new Board(16, 16);
  public ObjectManager(){
    this.omBoard = gb.lBoard;
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
  public JLabel[][] handleMouse(int x, int y){
    for(int height = 0; height < 16; height++){
      for(int width = 0; width < 16; width++){
        if(gb.board[height][width].x == x && gb.board[height][width].y == y)
          System.out.println(omBoard[height][width]);
          omBoard[height][width] = new JLabel(new ImageIcon("src/main/resources/tiles/grass_selected.png"));
      }
    }
    return omBoard;
  }
}