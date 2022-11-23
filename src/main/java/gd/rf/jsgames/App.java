/*
 * Main Class
 */

package gd.rf.jsgames;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.BasicStroke;
import java.awt.Color;
//import javax.swing.ImageIcon;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.units.Settler;

public final class App {
    private App() {
    }

    static JLayeredPane layers = new JLayeredPane();

    private final static int tileSize = 33;

    /**
     * @param args The arguments
     */
    public static void main(String[] args) {
        int x = 16, y = 16;
        Board gb = new Board(x, y);

        // render
        Frame game = new Frame(460, 380, "Global Conquest I");
        game.setBackground(Color.gray);
        // game.add(gb);
        game.setLayout(null);
        System.out.println("Loading, please wait.");
        // Path path = Paths.get("src/main/resources/tiles/grass.png");
        // if (Files.exists(path))
        // System.out.println("Grass found!");
        // else
        // System.out.println("Grass not found!");
        for (int height = 0; height < x; height++) {
            for (int width = 0; width < y; width++) {
                Tile cTile = gb.board[height][width];
                JLabel currentTile = gb.lBoard[height][width];
                currentTile.setBounds((int) cTile.x * tileSize, (int) cTile.y * tileSize, tileSize, tileSize);
                // currentTile.setBorder(BorderFactory.createStrokeBorder(new
                // BasicStroke(.5f)));
                layers.add(currentTile, 0);
                // game.add(currentTile);
            }
        }
        // Layer 0
        // generate settler
        Settler set = new Settler(0, 0);
        JLabel setTile = new JLabel(new ImageIcon(set.iconPath));
        setTile.setBounds((int) set.x * tileSize, (int) set.y * tileSize, tileSize, tileSize);
        layers.add(setTile, 1);
        // game.add(setTile);

        game.setContentPane(layers);
        game.pack();

        System.out.println("Done.");
    }
}