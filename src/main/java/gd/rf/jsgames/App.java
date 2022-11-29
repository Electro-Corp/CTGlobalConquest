package gd.rf.jsgames;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;

import gd.rf.jsgames.datatypes.Point;
import gd.rf.jsgames.tiles.Grass;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.ui.ui;
import gd.rf.jsgames.units.Settler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import com.almasb.fxgl.ui.*;
import static com.almasb.fxgl.dsl.FXGL.*;
import java.io.FileNotFoundException;
import java.util.*;

import java.util.Map;
//https://github.com/AlmasB/FXGL/issues/526
public class App extends GameApplication {
    private static final int TILE_SIZE = AppSettings.TILE_SIZE;
    private static final int BOARD_X = AppSettings.BOARD_X;
    private static final int BOARD_Y = AppSettings.BOARD_Y;
    private static final int BOARD_THICK = AppSettings.BOARD_THICK;
    private static final int BOARD_SIZE = 2 * BOARD_THICK + 4 * TILE_SIZE;
    private static final int TOTAL_WIDTH = 2 * BOARD_X + BOARD_SIZE + 160;
    private static final int TOTAL_HEIGHT = 2 * BOARD_Y + BOARD_SIZE;
    private final static int TILE_COUNT_X = 16;
    private final static int TILE_COUNT_Y = 16;
    private final Point MOUSE_OFFSET = AppSettings.MOUSE_OFFSET;
    private final static Tile[][] tiles = new Tile[TILE_COUNT_X][TILE_COUNT_Y];
    private final int BORDER_WIDTH = AppSettings.BORDER_WIDTH;
    private static GameWorld gw;
    private static ObjectManager om;
    private SceneFactory sf = new SceneFactory();
    GameSettings settings = new GameSettings();
    ui mainUI;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1024);
        settings.setHeight(720);
        settings.setTitle("Chinmay Tiwari's Global Conquest");
        //settings.setIntroEnabled(true);
        settings.setSceneFactory(new SceneFactory() {
            @Override
            public IntroS newIntro() {
                return new IntroS();
            }
        });
    }

    protected void initGame() {
        gw = getGameWorld();
        om = new ObjectManager();

        getGameScene().setBackgroundColor(Color.BLACK);
        om.units.add(new Settler(0, 3));
        om.units.get(0).moveTo(6, 5);
        // createBoard();
        mainUI = new ui(this);
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                tiles[j][i] = new Grass(j, i);
            }
        }
    
        getGameScene().addUINode(mainUI);
        nextTurn();
        settings.setAppIcon("icon.png");
    }

    protected void initUI() {
        
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                gw.addEntity(tiles[j][i].toEntity());
            }
        }
        for (int i = 0; i < om.units.size(); i++) {
            gw.addEntity(om.units.get(i).toEntity());
        }
        
    }

    static void renderGame() {
        
        //System.out.println("RENDER CALLED!!!");
        // System.out.println("RENDER CALLED!!!");
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                gw.addEntity(tiles[j][i].toEntity());
            }
        }
        for (int i = 0; i < om.units.size(); i++) {
            gw.addEntity(om.units.get(i).toEntity());
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
    public static void nextTurn(){
        om.updateObjects(tiles);
        renderGame();
    }
    protected void initInput() {
        Input input = getInput();

        UserAction LeftClick = new UserAction("LeftClick") {
            @Override
            protected void onActionBegin() {
                
                int dy = (int)(input.getMouseYWorld() + MOUSE_OFFSET.y) / (TILE_SIZE + BORDER_WIDTH);
                int dx = (int)(input.getMouseXWorld() + MOUSE_OFFSET.x) / (TILE_SIZE + BORDER_WIDTH);
                try {
                    tiles[(int) dx ][(int) dy ].changeSelected();
                    if(tiles[dx][dy].unitOn != null){
                        System.out.println("There is a unit here!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                initUI();
            }
        };
        FXGL.getInput().addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() { 
                
            }
        }, KeyCode.A);
        input.addAction(LeftClick, MouseButton.PRIMARY);
    }


    public static void update() {
        //nextTurn();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
}