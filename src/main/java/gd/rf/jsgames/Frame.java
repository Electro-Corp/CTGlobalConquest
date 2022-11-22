package gd.rf.jsgames;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Frame extends JFrame {
    private Dimension d = new Dimension();

    public Frame(int _frameVert, int _frameHor, String _frameName) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(_frameName);
        this.setSize(_frameHor, _frameVert);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        d = new Dimension(_frameHor, _frameVert);
    }

    public Frame(Dimension _d, String _frameName) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(_frameName);
        this.setSize(_d);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        d = new Dimension(_d);
    }

    public void pack() {
        super.pack();
        this.setSize(d);
        this.setVisible(true);
    }

    public void pack(Dimension _d) {
        super.pack();
        this.setSize(_d);
        this.setVisible(true);
    }
}