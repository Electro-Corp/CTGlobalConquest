package gameobjects.game;

public class gameboard{
  public tile[][] board = new tile[30][30];

  public gameboard(){
    for(int height = 0; height < 30; height++){
      for(int width = 0; width < 30; width++){
        this.board[height][width] = new tile((float)height,(float)width,0);
      }
    }
  }
}