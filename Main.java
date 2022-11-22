import gameobjects.game.gameboard;
// rendering
import javax.swing.JFrame;

public class Main{
  public static void main(String[] args){
    gameboard gb = new gameboard();

    // render
    JFrame game = new JFrame("Global Conquest I");
    game.setSize(480,360);
    game.setVisible(true);

  }
}