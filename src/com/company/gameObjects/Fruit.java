package com.company.gameObjects;

import com.company.Coordinate;
import com.company.GameObject;
import com.company.GameState;

public class Fruit extends GameObject {

  public Fruit(Coordinate coordinate) {
    super(coordinate);
  }

  public void collide(GameObject gameObject) {
    if (gameObject instanceof Extendable) {
      Extendable ext = (Extendable) gameObject;
      ext.extend();
      GameState.getInstance().addScore(10);
      getBoard().generateFruit();
      getBoard().removeGameObject(this);
    }
  }

  @Override
  public char getDisplay() {
    return 'F';
  }
}
