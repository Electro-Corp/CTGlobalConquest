package gd.rf.jsgames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.image.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import gd.rf.jsgames.datatypes.Point;
import gd.rf.jsgames.tiles.Grass;
import gd.rf.jsgames.tiles.Tile;
import javafx.scene.text.Text;

public class App extends Application {
    private static Stage stage;
    private static Scene scene;
    public static Group group = new Group();
    public static final int tileSize = 30;
    public static final String goodError = "ERROR AT LINE 4";
    public static int x, y = 16;
    // TEST THINGS
    public ArrayList<Point> testPoints = new ArrayList<>();
    public ArrayList<>
    public void addPoint(int x, int y) {
        testPoints.add(new Point(x, y));
    }

    // END OF TEST THINGS

    public static Tile[][] board;

    @Override
    public void start(Stage _stage) throws Exception {
        stage = _stage;
        stage.setScene(scene);
        stage.show();
    }

    public void generateBoard() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                try {
                    board[x][y] = new Grass(i * tileSize, j * tileSize);
                } catch (Exception e) {
                    System.out.println(goodError);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void render() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                Group.add(board[x][y].iconV);
            }
        }
    }
}
