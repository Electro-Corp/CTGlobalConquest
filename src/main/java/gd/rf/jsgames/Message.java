package gd.rf.jsgames;

import java.awt.event.*;
import javax.swing.*;

public class Message extends JFrame implements WindowListener {
  public Message() {
    this.setSize(500, 100);
    this.setTitle("Message");
    this.addWindowListener(this);
  }

  @Override
  public void windowClosing(WindowEvent e) {
    this.setVisible(false);
  }

  public void windowActivated(WindowEvent e) {
    System.out.println(" activated ");
  }

  public void windowClosed(WindowEvent e) {
    System.out.println(" closed ");
  }

  public void windowDeactivated(WindowEvent e) {
    System.out.println(" deactivated ");
  }

  public void windowDeiconified(WindowEvent e) {
    System.out.println(" deiconified ");
  }

  public void windowIconified(WindowEvent e) {
    System.out.println(" iconified ");
  }

  public void windowOpened(WindowEvent e) {
    System.out.println(" opened ");
  }

  public void dispMsg(String msg) {
    this.setVisible(true);
    this.add(new JLabel(msg));
  }
}