package gd.rf.jsgames.ui;

import gd.rf.jsgames.App;
import javafx.scene.layout.VBox;

public class ui extends VBox {
    GoodButton nextTurn;
    public static final double WIDTH = 100;
    public static final double HEIGHT = 500;

    public ui(App am) {
        this.setPrefSize(WIDTH, HEIGHT);
        this.setStyle("-fx-background-color: rgba(138, 109, 98, 0.35);");
        this.setSpacing(0);
        this.setTranslateX(900);
        this.setTranslateY(0);
        nextTurn = new GoodButton("Next Turn");
        initUI();
    }

    private void initUI() {
        this.getChildren().add(this.nextTurn);
    }
}