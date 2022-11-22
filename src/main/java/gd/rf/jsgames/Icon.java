package gd.rf.jsgames;

import java.nio.file.Path;

import javax.swing.ImageIcon;

public class Icon extends ImageIcon {
    Icon(Path p) {
        super(p.toString());
    }
}
