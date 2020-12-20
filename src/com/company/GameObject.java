package com.company;

public abstract class GameObject {
  private Coordinate coordinate;
  private Board board;

  public GameObject(Coordinate coord) {
    this.coordinate = coord;
  }

  public Coordinate getCoord() {
    return coordinate;
  }

  public void setCoord(Coordinate coord) {
    this.coordinate = coord;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public boolean checkCollision(GameObject gameObject) {
    return this.coordinate.getX() == gameObject.getCoord().getX() && this.coordinate.getY() == gameObject.getCoord().getY();
  }

  public abstract void collide(GameObject gameObject);

  public abstract char getDisplay();
}
