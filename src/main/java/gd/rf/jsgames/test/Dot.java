package gd.rf.jsgames.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gd.rf.jsgames.datatypes.Point;

public class Dot extends JLabel {
    public static final String iconPath = "src/main/resources/test-dot.png";

    public Dot(Point p) {
        super(new ImageIcon(iconPath));
        this.setBounds(p.x, p.y, 5, 5);
    }
}
