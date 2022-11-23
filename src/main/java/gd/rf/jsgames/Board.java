package gd.rf.jsgames;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gd.rf.jsgames.tiles.*;

public class Board {
    public Tile[][] board;
    public JLabel[][] lBoard;

    public Board(int x, int y) {
        this.board = new Tile[y][x];
        this.lBoard = new JLabel[y][x];
        for (int height = 0; height < y; height++) {
            for (int width = 0; width < x; width++) {
                this.board[height][width] = new Grass((float) width, (float) height);
                JLabel currentTile = new JLabel(new ImageIcon(board[height][width].img()));
                this.lBoard[height][width] = currentTile;
            }
        }
    }
}
