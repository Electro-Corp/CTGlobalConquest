/*
 * Main Class
 */

package gd.rf.jsgames;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

//import javax.swing.ImageIcon;
import gd.rf.jsgames.tiles.Tile;

public final class App {
    private App() {
    }

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

                JLabel currentTile = new JLabel(cTile.img());
                currentTile.setBounds((int) cTile.x, (int) cTile.y, 10, 10);
                game.add(currentTile);
            }
        }
        System.out.println("Done.");
    }
}