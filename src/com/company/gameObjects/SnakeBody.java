package com.company.gameObjects;

import com.company.Coordinate;
import com.company.GameObject;
import com.company.GameState;

public class SnakeBody extends GameObject {
  private SnakeBody nextPart;

  public SnakeBody(Coordinate coord) {
    super(coord);
  }

  @Override
  public void collide(GameObject gameObject) {
    if (gameObject instanceof SnakeHead) {
      GameState.getInstance().setIsGameOver(true);
    }
  }

  @Override
  public char getDisplay() {
    return 'S';
  }

  public void move(Coordinate coordinate) {
    if (nextPart != null) {
      nextPart.move(this.getCoord());
    }
    this.setCoord(coordinate);
  }

  protected void extend() {
    if (nextPart != null) {
      nextPart.extend();
    } else {
      nextPart = (SnakeBody) getBoard().addGameObject(new SnakeBody(this.getCoord()));
    }
  }

  public void extend(SnakeBody snakeBody) {
    nextPart = (SnakeBody) getBoard().addGameObject(snakeBody);
  }
}
