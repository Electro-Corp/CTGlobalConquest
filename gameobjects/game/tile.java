package gameobjects.game;
/*
  TILE TYPES:
    [0] GRASS
    [1] DESERT
    [2] SNOW
    [3] RIVER
*/
public class tile{
  float x, y;
  int tileType; 
  public tile(float x, float y, int tileType){
    this.x = x;
    this.y = y;
    this.tileType = tileType;
  }
}