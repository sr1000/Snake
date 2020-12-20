package com.company.gameObjects;

import com.company.Coordinate;
import com.company.GameObject;

public class Teleporter extends GameObject {

  public Teleporter(Coordinate coord) {
    super(coord);
  }

  @Override
  public void collide(GameObject gameObject) {
    if (gameObject instanceof SnakeHead) {
      SnakeHead snakeHead = (SnakeHead) gameObject;
      snakeHead.move(new Coordinate(0, 0));
    }
  }

  @Override
  public char getDisplay() {
    return 'T';
  }
}
