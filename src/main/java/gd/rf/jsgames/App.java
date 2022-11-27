package gd.rf.jsgames;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;

import gd.rf.jsgames.tiles.Grass;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.units.Settler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import static com.almasb.fxgl.dsl.FXGL.*;

import java.io.FileNotFoundException;
import java.util.*;

import java.util.Map;

public class App extends GameApplication {
    private static final int TILE_SIZE = Constants.TILE_SIZE;
    private static final int BOARD_X = Constants.BOARD_X;
    private static final int BOARD_Y = Constants.BOARD_Y;
    private static final int BOARD_THICK = Constants.BOARD_THICK;
    private static final int BOARD_SIZE = 2 * BOARD_THICK + 4 * TILE_SIZE;
    private static final int TOTAL_WIDTH = 2 * BOARD_X + BOARD_SIZE + 160;
    private static final int TOTAL_HEIGHT = 2 * BOARD_Y + BOARD_SIZE;
    private final int TILE_COUNT_X = 16;
    private final int TILE_COUNT_Y = 16;
    private final Tile[][] tiles = new Tile[TILE_COUNT_X][TILE_COUNT_Y];
    private GameWorld gw;
    private ObjectManager om;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Chinmay Tiwari's Global Conquest");
    }

    protected void initGame() {
        gw = getGameWorld();
        om = new ObjectManager();
        getGameScene().setBackgroundColor(Color.BLACK);
        om.units.add(new Settler(0,3));
        // createBoard();
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                tiles[j][i] = new Grass(j, i);
            }
        }
    }

    protected void initUI() {
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                gw.addEntity(tiles[j][i].toEntity());
            }
        }
    }

    protected void renderGame() {
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                tiles[j][i].toEntity();
            }
        }
    }

    private Entity createBoard() {
        return new EntityBuilder()
                .at(BOARD_X, BOARD_Y)
                .view(new Rectangle(BOARD_SIZE, BOARD_SIZE, Color.LIGHTGRAY))
                .buildAndAttach();
    }

    // private Entity createGrass(int x, int y) {
    // return new Grass(x, y);
    // }

    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Mouse Movement") {
            @Override
            protected void onAction() {
                double dy = input.getMouseYWorld();
                double dx = input.getMouseXWorld();
                try {
                    tiles[(int)dx/Constants.TILE_SIZE][(int)dy/Constants.TILE_SIZE].changeSelected();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                this.renderGame();
            }
        }, MouseButton.PRIMARY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}