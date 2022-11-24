package gd.rf.jsgames;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Graphics;

import gd.rf.jsgames.datatypes.Point;
import gd.rf.jsgames.tiles.*;

public class Board {
    public Tile[][] board;
    public JLabel[][] lBoard;

    public int x, y;

    public ArrayList<Point> dots = new ArrayList<>();

    public Board(int _x, int _y) {
        x = _x;
        y = _y;
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

    public void addPoint(int x, int y) {
        dots.add(new Point(x, y));
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < dots.size(); i++) {
            g.drawOval(dots.get(i).x, dots.get(i).y, 2, 2);
        }
    }

    // public void updateLables() {
    // for (int height = 0; height < y; height++) {
    // for (int width = 0; width < x; width++) {
    // JLabel currentTile = new JLabel(new ImageIcon(board[height][width].img()));
    // this.lBoard[height][width] = currentTile;
    // }
    // }
    // }
}
