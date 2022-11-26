package gd.rf.jsgames;

import java.util.ArrayList;
import gd.rf.jsgames.structures.*;
import gd.rf.jsgames.units.*;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.Board;
import javax.swing.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ObjectManager {
  public ArrayList<Settler> settlers = new ArrayList<Settler>();
  public ArrayList<Warrior> warriors = new ArrayList<Warrior>();
  public ArrayList<Builder> builders = new ArrayList<Builder>();
  public ArrayList<City> cities = new ArrayList<City>();
  public ArrayList<Farm> farms = new ArrayList<Farm>();
  public JLabel[][] omLBoard;
  public Tile[][] omBoard;
  Board gb = new Board(16, 16);
  public Unit selectedUnit;
  public boolean unitMove = false;
  public int mX, mY;
  public final JList<String> listDisplay = new JList<>();
  public DefaultListModel<String> log = new DefaultListModel<>();

  public ObjectManager() {
    this.omLBoard = gb.lBoard;
    this.omBoard = gb.board;
  }

  public void addSettler(float x, float y) {
    this.settlers.add(new Settler(x, y));
  }

  public void addBuilder(float x, float y) {
    this.builders.add(new Builder(x, y));
  }

  // next-turn
  public void updateObjects() {
    // update settlers
    for (int i = 0; i < settlers.size(); i++) {
      this.settlers.get(i).update();
    }
    // update warriors
    for (int i = 0; i < warriors.size(); i++) {
      this.warriors.get(i).update();
    }
    // update builders
    for (int i = 0; i < builders.size(); i++) {
      this.builders.get(i).update();
    }
    // update cites
    for (int i = 0; i < cities.size(); i++) {
      this.cities.get(i).update();
    }
    // update farms
    for (int i = 0; i < farms.size(); i++) {
      this.farms.get(i).update();
    }
  }

  public void updateLables() {
    for (int height = 0; height < gb.y; height++) {
      for (int width = 0; width < gb.x; width++) {
        JLabel currentTile = new JLabel(new ImageIcon(omBoard[height][width].img()));
        this.omLBoard[height][width] = currentTile;
      }
    }
  }

  public JLabel[][] handleMouse(int x, int y) {
    // for (int height = 0; height < 16; height++) {
    // for (int width = 0; width < 16; width++) {
    // if (gb.board[height][width].x == x && gb.board[height][width].y == y) {
    // omBoard[height][width].selected = !omBoard[height][width].selected;
    // boolean tileSelected = omBoard[height][width].selected;
    // // System.out.println(omBoard[height][width]);
    // if(tileSelected)
    // omLBoard[height][width] = new JLabel(new
    // ImageIcon("src/main/resources/tiles/grass_selected.png"));
    // else
    // break;
    // }
    // }
    // }
    if (omBoard[y][x].selected) {
      omBoard[y][x].changeSelected();
      updateLables();
    }

    else {

      omBoard[y][x].changeSelected();
      updateLables();
    }

    if (!unitMove) {
      selectedUnit = null;
    }
    for (int i = 0; i < settlers.size(); i++) {
      if (this.settlers.get(i).x == x && this.settlers.get(i).y == y) {
        selectedUnit = settlers.get(i);
        break;
      }
    }
    for (int i = 0; i < builders.size(); i++) {
      if (this.builders.get(i).x == x && this.builders.get(i).y == y) {
        selectedUnit = builders.get(i);
        break;
      }
    }
    return omLBoard;

  }
}