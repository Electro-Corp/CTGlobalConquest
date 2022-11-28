package gd.rf.jsgames.units;

import gd.rf.jsgames.tiles.Tile;
// import gd.rf.jsgames.ObjectManager;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import gd.rf.jsgames.AppSettings;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.image.Image;

public class Unit {
  public float x, y;
  public int toX, toY;
  public boolean isMoving = false;
  public Tile tileOn;
  public String iconPath = "units/settler.png";
  public int health = 100;
  public int moveSpeed = 1;
  public Node node = FXGL.getAssetLoader().loadTexture(iconPath);

  public Unit(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public void updateTile(Tile a) {
    this.tileOn = a;
  }

  public double x() {
    return tileOn.x;
  }

  public double y() {
    return tileOn.y;
  }

  public void setIcon(String s) {
    iconPath = s;
  }

  public void takeDamage(int m) {
    this.health -= 2 * m;
  }

  public void moveTo(int x, int y) {
    isMoving = true;
    toX = x;
    toY = y;
  }

  public void update() {
    if (isMoving) {
      // do something
      for (int i = 0; i < moveSpeed; i++) {
        if (toX > x)
          x += (toX - x) - ((toX - x) - 1);
        else
          x -= (toX - x) - ((toX - x) - 1);
        if (toY > y)
          y += (toY - y) - ((toY - y) - 1);
        else
          y -= (toY - y) - ((toY - y) - 1);

        if (x == toX && y == toY)
          isMoving = false;
        System.out.println(x + "," + y);
      }
    }
  }

  // public void action(ObjectManager om){
  // System.out.println("Unit has not been configured correctly, there is no
  // override for action!");
  // }
  public Entity toEntity() {
    node = FXGL.getAssetLoader().loadTexture(iconPath);
    return new EntityBuilder().at((AppSettings.TILE_SIZE + AppSettings.BORDER_WIDTH) * x,
        (AppSettings.TILE_SIZE + AppSettings.BORDER_WIDTH) * y).view(node).build();
  }
}
