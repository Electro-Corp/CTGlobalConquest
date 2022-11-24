/*
 * Main Class
 */

package gd.rf.jsgames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.ImageIcon;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.units.Settler;
import gd.rf.jsgames.structures.City;
import gd.rf.jsgames.test.Dot;
import gd.rf.jsgames.ObjectManager;

public final class App {
  private App() {
  }

  /*
   * Layers Structure
   * Layers has a length of n
   * [0] = GROUND
   * [1] = STRUCTURES
   * [2] = UNITS
   * [n] = TEST POINTS
   */

  static JLayeredPane layers = new JLayeredPane();
  public static int x = 16, y = 16;
  private static Frame game;
  private final static int tileSize = 33;
  public static ObjectManager om;

  /**
   * @param args The arguments
   */
  public static void main(String[] args) {
    game = new Frame(460, 380, "Global Conquest I");
    game.setCursor(null);
    om = new ObjectManager();
    // render

    game.setBackground(Color.gray);
    game.setLayout(null);
    System.out.println("Loading, please wait.");
    // Path path = Paths.get("src/main/resources/tiles/grass.png");
    // if (Files.exists(path))
    // System.out.println("Grass found!");
    // else
    // System.out.println("Grass not found!");

    // Layer 0
    // generate settler
    Settler set = new Settler(0, 0);
    JLabel setTile = new JLabel(new ImageIcon(set.iconPath));
    setTile.setBounds((int) set.x * tileSize, (int) set.y * tileSize, tileSize, tileSize);
    layers.add(setTile, 2);
    render();
    // game.add(setTile);

    game.setContentPane(layers);
    game.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int x = e.getX() - 10;
        int y = e.getY() - 32;
        om.gb.addPoint(x, y);
        // System.out.println("Mouse clicked at: " + x / tileSize + "," + y / tileSize);
        om.gb.lBoard = om.handleMouse(x / tileSize, y / tileSize);
        render();
        renderTestPoints();
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }
    });
    game.pack();

    System.out.println("Done.");
  }

  public static void render() {
    layers.remove(0);
    for (int height = 0; height < x; height++) {
      for (int width = 0; width < y; width++) {
        Tile cTile = om.gb.board[height][width];
        JLabel currentTile = om.gb.lBoard[height][width];
        currentTile.setBounds((int) cTile.x * tileSize, (int) cTile.y * tileSize, tileSize, tileSize);

        layers.add(currentTile, 0);
      }
    }

    game.setContentPane(layers);
    game.pack();
  }

  public static void renderTestPoints() {
    if (om.gb.dots.size() > 0) {
      for (int i = 0; i < om.gb.dots.size(); i++) {
        Dot currentPoint = new Dot(om.gb.dots.get(i));
        layers.add(currentPoint, 3);
      }
      game.setContentPane(layers);
      game.pack();
    }
  }
}