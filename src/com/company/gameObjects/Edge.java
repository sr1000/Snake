package com.company.gameObjects;

import com.company.Coordinate;
import com.company.GameObject;
import com.company.GameState;

public class Edge extends GameObject {
  public Edge() {
    super(new Coordinate(0, 0));
  }

  @Override
  public void collide(GameObject gameObject) {
    if (gameObject instanceof SnakeHead) {
      GameState.getInstance().setIsGameOver(true);
    }
  }

  @Override
  public char getDisplay() {
    return ' ';
  }
}
