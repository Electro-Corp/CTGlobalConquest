module gd.rf.jsgames {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens gd.rf.jsgames to javafx.fxml;
    exports gd.rf.jsgames;
}