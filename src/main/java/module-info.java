module gd.rf.jsgames {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens gd.rf.jsgames to javafx.fxml;
    opens assets.textures;

    exports gd.rf.jsgames;

    requires com.almasb.fxgl.all;
}