package com.company;

public class Cell {
  private final int row, col;
  private CellType type;
  private Direction direction = Direction.NONE;

  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
    this.type = CellType.EMPTY;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public CellType getType() {
    return type;
  }

  public void setType(CellType type) {
    this.type = type;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void printCell() {
    switch (this.type) {
      case EMPTY:
        System.out.print(".");
        break;
      case FRUIT:
        System.out.print("F");
        break;
      case HEAD:
      case BODY:
      case TAIL:
        System.out.print("S");
        break;
      default:
        break;
    }
  }
}
