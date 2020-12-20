package com.company.gameObjects;

import com.company.Coordinate;
import com.company.GameObject;

public class Food extends GameObject {

  public Food(Coordinate coord) {
    super(coord);
  }

  public void collide(GameObject gameObject) {
    if (gameObject instanceof Extendable) {
      Extendable ext = (Extendable) gameObject;
      ext.extend();
      getBoard().generateFruit();
      getBoard().removeGameObject(this);
    }
  }

  @Override
  public char getDisplay() {
    return 'F';
  }
}
