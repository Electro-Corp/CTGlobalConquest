package gd.rf.jsgames;

import java.util.ArrayList;
import gd.rf.jsgames.structures.City;
import gd.rf.jsgames.units.Settler;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.Board;
import javax.swing.*;

public class ObjectManager {
    public ArrayList<Settler> settlers = new ArrayList<Settler>();
    public ArrayList<City> cities = new ArrayList<City>();
    public JLabel[][] omLBoard;
    public Tile[][] omBoard;
    Board gb = new Board(16, 16);

    public ObjectManager() {
        this.omLBoard = gb.lBoard;
        this.omBoard = gb.board;
    }

    public void updateObjects() {
        // update settlers
        for (int i = 0; i < settlers.size(); i++) {
            this.settlers.get(i).update();
        }
        // update cites
        for (int i = 0; i < cities.size(); i++) {
            this.cities.get(i).update();
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
        } else {
            omBoard[y][x].changeSelected();
            updateLables();
        }
        return omLBoard;
    }
}