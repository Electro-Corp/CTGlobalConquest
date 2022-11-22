package gd.rf.jsgames;

import javax.swing.JPanel;
import gd.rf.jsgames.tiles.*;

public class Board extends JPanel {
    public Tile[][] board;

    public Board(int x, int y) {
        board = new Tile[x][y];
        for (int height = 0; height < y; height++) {
            for (int width = 0; width < x; width++) {
                this.board[height][width] = new Grass((float) height, (float) width);
            }
        }
    }
}
