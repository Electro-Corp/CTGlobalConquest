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
import gd.rf.jsgames.units.unit;
public final class App {
    private App() {
    }

    private final static int tileSize = 10;

    /**
     * @param args The arguments
     */
    public static void main(String[] args) {
        int x = 30, y = 30;
        Board gb = new Board(x, y);

        // render
        Frame game = new Frame(480, 360, "Global Conquest I");
        // game.add(gb);
        game.setLayout(null);
        System.out.println("Loading, please wait.");
        Path path = Paths.get("src/main/resources/tiles/grass.png");
        if (Files.exists(path))
            System.out.println("Grass found!");
        else
            System.out.println("Grass not found!");
        for (int height = 0; height < x; height++) {
            for (int width = 0; width < y; width++) {
                Tile cTile = gb.board[height][width];
                // System.out.println("Loaded tile at X: "+cTile.x + " Y: "+cTile.y);

                JLabel currentTile = new JLabel(new ImageIcon(cTile.img()));
                currentTile.setBounds((int) cTile.x * tileSize, (int) cTile.y * tileSize, tileSize, tileSize);
                currentTile.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(.5f)));
                game.add(currentTile);
            }
        }
        // generate settler
        unit set = new unit(0,0);
        JLabel setTile = new JLabel(new ImageIcon(set.settlerImagePath));
        setTile.setBounds((int) set.x * tileSize, (int) set.y * tileSize, tileSize, tileSize);
        game.add(setTile);
        game.pack();
        System.out.println("Done.");
    }
}