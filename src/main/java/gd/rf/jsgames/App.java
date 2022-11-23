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
import gd.rf.jsgames.ObjectManager;
public final class App{
    private App() {
    }

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
        
        om = new ObjectManager();
        // render
        
        game.setBackground(Color.gray);
        // game.add(gb);
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
        layers.add(setTile, 1);
        render();
        // game.add(setTile);

        game.setContentPane(layers);
        game.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              int x=e.getX();
              int y=e.getY();
              System.out.println("Mouse clicked at: "+x/tileSize+","+y/tileSize);
              om.gb.lBoard = om.handleMouse(x/tileSize,y/tileSize);
              render();
            }
            @Override
            public void mousePressed(MouseEvent e){}
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mouseReleased(MouseEvent e){}
        });
        game.pack();

        System.out.println("Done.");
    }
    public static void render(){
      for (int height = 0; height < x; height++) {
            for (int width = 0; width < y; width++) {
                Tile cTile = om.gb.board[height][width];
                JLabel currentTile = om.gb.lBoard[height][width];
                currentTile.setBounds((int) cTile.x * tileSize, (int) cTile.y * tileSize, tileSize, tileSize);
                // currentTile.setBorder(BorderFactory.createStrokeBorder(new
                // BasicStroke(.5f)));
                layers.add(currentTile, 0);
                // game.add(currentTile);
            }
        }
      game.setContentPane(layers);
      game.pack();
    }
}