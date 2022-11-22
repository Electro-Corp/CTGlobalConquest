package gd.rf.jsgames;

import javax.swing.JPanel;
import gd.rf.jsgames.tiles.*;

public class Board extends JPanel {
    public Tile[][] board;

    public Board(int x, int y) {
        this.board = new Tile[y][x];
        for (int height = 0; height < y; height++) {
            for (int width = 0; width < x; width++) {
                this.board[height][width] = new Tile((float) width, (float) height);
            }
        }
    }
}
