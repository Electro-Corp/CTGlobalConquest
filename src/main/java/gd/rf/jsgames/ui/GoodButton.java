package gd.rf.jsgames.ui;

import gd.rf.jsgames.App;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class GoodButton extends Button implements EventHandler {
    public GoodButton(App ap) {
        this.setOnMouseEntered(mouseEvent -> this.setTextFill(Color.rgb(180, 180, 180)));
        this.setOnMouseExited(mouseEvent -> this.setTextFill(Color.WHITE));

        this.setTooltip(new Tooltip("Next Turn"));

        this.setOnAction(this);
    }

    @Override
    public void handle(Event event) {
        App.nextTurn();
    }

    private class GoodLabel extends Label {

    }
}
