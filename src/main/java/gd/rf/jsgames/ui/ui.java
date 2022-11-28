package gd.rf.jsgames.ui;
import javafx.scene.layout.VBox;

public class ui extends VBox{
    GoodButton nextTurn = new GoodButton();
    public static final double WIDTH = 100;
    public static final double HEIGHT = 500;
    public ui(){
        this.setPrefSize(WIDTH, HEIGHT);
        this.setStyle("-fx-background-color: rgba(138, 109, 98, 0.35);");
        this.setSpacing(0);
        this.setTranslateX(900);
        this.setTranslateY(0);
    }
}
