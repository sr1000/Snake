package com.company;

public abstract class GameObject {
  private Coordinate coordinate;
  private Board board;

  public GameObject(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public boolean checkCollision(GameObject gameObject) {
    return coordinate.getX() == gameObject.getCoordinate().getX() && coordinate.getY() == gameObject.getCoordinate().getY();
  }

  public abstract void collide(GameObject gameObject);

  public abstract char getDisplay();
}
