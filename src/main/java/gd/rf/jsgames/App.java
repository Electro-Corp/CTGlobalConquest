package gd.rf.jsgames;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputModifier;
import com.almasb.fxgl.input.UserAction;

import gd.rf.jsgames.datatypes.Point;
import gd.rf.jsgames.tiles.Grass;
import gd.rf.jsgames.tiles.Tile;
import gd.rf.jsgames.ui.ui;
import gd.rf.jsgames.units.Settler;
import gd.rf.jsgames.units.Unit;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static com.almasb.fxgl.dsl.FXGL.*;
import java.util.*;

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
    private Tile cTile;
    private ArrayList<Tile> sTiles;
    ui mainUI;

    @Override
    protected void initSettings(GameSettings settings) {
        // Set the width and height of the game window
        settings.setWidth(1024);
        settings.setHeight(720);

        // Set the title of the game
        settings.setTitle("Chinmay Tiwari's Global Conquest");

        // Enable or disable the intro screen
        // settings.setIntroEnabled(true);

        // Set the factory used to create new scenes
        settings.setSceneFactory(new SceneFactory() {
            @Override
            public IntroS newIntro() {
                return new IntroS();
            }
        });
    }

    protected void initGame() {
        // Create new instances of the game world and object manager
        gw = getGameWorld();
        om = new ObjectManager();

        // Set the background color of the game scene to black
        getGameScene().setBackgroundColor(Color.BLACK);

        // Add a new Settler to the list of units managed by the object manager
        // and move it to the specified coordinates
        om.units.add(new Settler(0, 3));
        om.units.get(0).moveTo(6, 5);

        // Initialize the main user interface
        mainUI = new ui(this);

        // Create a new tile for each coordinate on the game board
        // and set its type to Grass
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                tiles[j][i] = new Grass(j, i);
            }
        }

        // Add the main user interface to the game scene
        getGameScene().addUINode(mainUI);

        // Advance to the next turn in the game
        nextTurn();

        // Initialize the current tile and list of selected tiles
        cTile = new Tile();
        sTiles = new ArrayList<>();

        // Set the application icon
        settings.setAppIcon("icon.png");
    }

    // This method initializes the user interface by adding the tiles and units to
    // the game world.
    protected void initUI() {
        // Get the list of units from the game world.
        List<Unit> units = om.units;

        // Loop through the rows of the tiles array.
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            // Loop through the columns of the tiles array.
            for (int j = 0; j < TILE_COUNT_X; j++) {
                // Add the current tile to the game world.
                gw.addEntity(tiles[j][i].toEntity());
            }
        }

        // Loop through the list of units.
        for (int i = 0; i < units.size(); i++) {
            // Add the current unit to the game world.
            gw.addEntity(units.get(i).toEntity());
        }
    }

    static void renderGame() {
        // First, create a list to store the entities that need to be rendered
        List<Entity> entities = new ArrayList<>();
    
        // Loop through the tiles array and add each tile to the list of entities
        for (int i = 0; i < TILE_COUNT_Y; i++) {
            for (int j = 0; j < TILE_COUNT_X; j++) {
                entities.add(tiles[j][i].toEntity());
            }
        }
    
        // Loop through the units in the om object and add each unit to the list of entities
        for (int i = 0; i < om.units.size(); i++) {
            entities.add(om.units.get(i).toEntity());
        }
    
        // Add all of the entities to the gw object in one go, which is more efficient than adding them one at a time
        gw.addEntities(entities.toArray(new Entity[0]));
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
    public static void nextTurn() {
        om.updateObjects(tiles);
        renderGame();
    }

    protected void initInput() {
        Input input = getInput();
        UserAction leftClick = new UserAction("LeftClick") {
            @Override
            protected void onActionBegin() {
                clearSTiles();
                sTiles.clear();
                int dy = (int) (input.getMouseYWorld() + MOUSE_OFFSET.y) / (TILE_SIZE + BORDER_WIDTH);
                int dx = (int) (input.getMouseXWorld() + MOUSE_OFFSET.x) / (TILE_SIZE + BORDER_WIDTH);
                try {
                    cTile.changeSelected();
                    cTile = tiles[(int) dx][(int) dy];
                    sTiles.add(cTile);
                    tiles[(int) dx][(int) dy].changeSelected();
                    // if (tiles[dx][dy].unitOn != null) {
                    // System.out.println("There is a unit here!");
                    // }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                updateTiles();
            }
        };
        // TODO: Implement
        // FUNCITON: From Current pos -> Clicked Tile
        UserAction shiftLeftClick = new UserAction("ShiftLeftClick") {
            @Override
            protected void onActionBegin() {

                int dy = (int) (input.getMouseYWorld() + MOUSE_OFFSET.y) / (TILE_SIZE + BORDER_WIDTH);
                int dx = (int) (input.getMouseXWorld() + MOUSE_OFFSET.x) / (TILE_SIZE + BORDER_WIDTH);
                try {
                    // NOTHING HERE
                } catch (Exception e) {
                    e.printStackTrace();
                }

                updateTiles();
            }
        };
        // Adds clicked tile
        UserAction ctrlLeftClick = new UserAction("ctrlLeftClick") {
            @Override
            protected void onActionBegin() {

                int dy = (int) (input.getMouseYWorld() + MOUSE_OFFSET.y) / (TILE_SIZE + BORDER_WIDTH);
                int dx = (int) (input.getMouseXWorld() + MOUSE_OFFSET.x) / (TILE_SIZE + BORDER_WIDTH);
                try {
                    cTile = tiles[(int) dx][(int) dy];
                    sTiles.add(cTile);
                    tiles[(int) dx][(int) dy].changeSelected();
                    if (tiles[dx][dy].unitOn != null) {
                        System.out.println("There is a unit here!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                updateTiles();
            }
        };

        input.addAction(leftClick, MouseButton.PRIMARY);
        input.addAction(shiftLeftClick, MouseButton.PRIMARY, InputModifier.SHIFT);
        input.addAction(ctrlLeftClick, MouseButton.PRIMARY, InputModifier.CTRL);
    }
/*// This method has been modified to reduce the amount of code duplication and improve readability.
protected void initInput() {
    // The Input object is now stored in a local variable.
    Input input = getInput();
    
    // Instead of defining anonymous inner classes, the UserAction objects are now defined as separate classes
    // that can be easily referenced and re-used.
    UserAction leftClick = new LeftClickAction();
    UserAction shiftLeftClick = new ShiftLeftClickAction();
    UserAction ctrlLeftClick = new CtrlLeftClickAction();
    
    // The action objects are now added to the input object using the addAction() method.
    input.addAction(leftClick, MouseButton.PRIMARY);
    input.addAction(shiftLeftClick, MouseButton.PRIMARY, InputModifier.SHIFT);
    input.addAction(ctrlLeftClick, MouseButton.PRIMARY, InputModifier.CTRL);
}

// This class extends the UserAction class and defines the behavior for the left click action.
class LeftClickAction extends UserAction {
    public LeftClickAction() {
        super("LeftClick");
    }
    
    @Override
    protected void onActionBegin() {
        // The clearSTiles() method is called to clear the sTiles list.
        clearSTiles();
        // The sTiles list is cleared using the clear() method.
        sTiles.clear();
        
        // The dx and dy values are calculated by dividing the mouse coordinates by the tile size and border width.
        int dy = (int) (input.getMouseYWorld() + MOUSE_OFFSET.y) / (TILE_SIZE + BORDER_WIDTH);
        int dx = (int) (input.getMouseXWorld() + MOUSE_OFFSET.x) / (TILE_SIZE + BORDER_WIDTH);
        try {
            // The selected state of the current tile is toggled using the changeSelected() method.
            cTile.changeSelected();
            // The current tile is updated to the tile at the specified coordinates.
            cTile = tiles[(int) dx][(int) dy];
            // The updated tile is added to the sTiles list.
            sTiles.add(cTile);
            // The selected state of the tile at the specified coordinates is toggled.
            tiles[(int) dx][(int) dy].changeSelected();
            // The presence of a unit on the selected tile is checked and a message is printed to the console if necessary.
            // if (tiles[dx][dy].unitOn != null) {
            //     System.out.println("There is a unit here!");
            // }
        } catch (Exception e) {
            // Any exceptions thrown in the try block are caught and printed to the console.
            e.printStackTrace();
        }
        // The updateTiles() method is called to update the state of the tiles.
        updateTiles();
    }
}

// This class extends the UserAction class and defines the behavior for the shift left click action.
class ShiftLeftClickAction extends UserAction {
    public ShiftLeftClickAction() {
        super("ShiftLeftClick");
    }
 */
    // TODO: Implement a change tile states method to change all selected tiles so
    // that they are selected
    public void updateTiles() {
        for (int index = 0; index < sTiles.size(); index++) {
            int x = (int) sTiles.get(index).x;
            int y = (int) sTiles.get(index).y;
            if (!sTiles.get(index).selected)
                sTiles.get(index).changeSelected();
            // System.out.println(sTiles.get(index));
            tiles[x][y] = sTiles.get(index);
        }
        renderGame();
    }

    public void clearSTiles() {
        // System.out.println(sTiles.size());
        for (int i = 0; i < sTiles.size(); i++) {
            // System.out.println(sTiles.get(i));
            int x = (int) sTiles.get(i).x;
            int y = (int) sTiles.get(i).y;
            if (sTiles.get(i).selected) {
                sTiles.get(i).changeSelected();
                System.out.println(sTiles.get(i));
            }
            tiles[x][y] = sTiles.get(i);
            System.out.println(tiles[x][y]);
        }
        sTiles.clear();
        // System.out.println(sTiles.size());
        // updateTiles();
    }

    public static void main(String[] args) {
        launch(args);
    }
}