package gd.rf.jsgames;

import gd.rf.jsgames.datatypes.Point;

public class AppSettings {
    public static final int TILE_SIZE = 30;
    public static final int BOARD_X = 50;
    public static final int BOARD_Y = 50;
    public static final int BOARD_THICK = 10;
    public static final int BOARD_SIZE = 2 * BOARD_THICK + 4 * TILE_SIZE;
    public static final int TOTAL_WIDTH = 2 * BOARD_X + BOARD_SIZE + 160;
    public static final int TOTAL_HEIGHT = 2 * BOARD_Y + BOARD_SIZE;
    public static final int TILE_COUNT_X = 16;
    public static final int TILE_COUNT_Y = 16;
    public static final Point MOUSE_OFFSET = new Point(-5, -5);
    public static final int BORDER_WIDTH = 3;
}
