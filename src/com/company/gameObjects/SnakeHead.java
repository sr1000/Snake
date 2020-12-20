package com.company.gameObjects;

import com.company.Coordinate;
import com.company.Direction;

public class SnakeHead extends SnakeBody implements Extendable {
  private Direction direction;

  public SnakeHead(Coordinate coordinate, Direction direction) {
    super(coordinate);
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  @Override
  public void extend() {
    super.extend();
  }

  @Override
  public char getDisplay() {
    return 'H';
  }

  public void move() {
    super.move(getCoordinate().move(direction));
  }
}
