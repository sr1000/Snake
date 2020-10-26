package com.company;

import java.util.ArrayList;

public class Snake {
  private Cell head;
  private Cell tail;
  private final ArrayList<Cell> bodyParts = new ArrayList<>();
  private final Board board;
  private Direction direction = Direction.EAST;

  public Snake(Board board) {
    this.board = board;
    this.initializeSnake();
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void initializeSnake() {
    initializeSnakeHead();
    initializeSnakeBody();
    initializeSnakeTail();
  }

  private void initializeSnakeHead() {
    this.head = this.board.getCell(0 , 2);
    this.head.setType(CellType.HEAD);
    this.head.setDirection(this.direction);
  }

  private void initializeSnakeBody() {
    Cell body = this.board.getCell(0, 1);
    body.setType(CellType.BODY);
    body.setDirection(this.direction);
    this.bodyParts.add(body);
  }

  private void initializeSnakeTail() {
    this.tail = this.board.getCell(0, 0);
    this.tail.setDirection(this.direction);
    this.tail.setType(CellType.TAIL);
  }

  public void moveSnake() {
    this.head = this.moveSingleSnakePart(this.head, CellType.HEAD);

    for (int i = 0; i < this.bodyParts.size(); i++) {
      Cell bodyPart = this.bodyParts.get(i);
      this.bodyParts.set(i, this.moveSingleSnakePart(bodyPart, CellType.BODY));
    }

    this.tail = this.moveSingleSnakePart(this.tail, CellType.TAIL);
  }

  private Cell moveSingleSnakePart(Cell cell, CellType type) {
    int cellRow = cell.getRow();
    int cellCol = cell.getCol();
    Direction dir = cell.getDirection();

    cell.setType(CellType.EMPTY);
    cell.setDirection(Direction.NONE);

    switch (dir) {
      case NORTH:
        cellRow--;
        break;
      case EAST:
        cellCol++;
        break;
      case WEST:
        cellCol--;
        break;
      case SOUTH:
        cellRow++;
        break;
      default:
        break;
    }

    if (!this.isOutOfBounds(cellRow, cellCol)) {
      Cell newCell = this.board.getCell(cellRow, cellCol);

      if (type == CellType.HEAD) {
        if (!this.isCollision(newCell)) {
          newCell.setType(CellType.HEAD);
        } else {
          System.out.println("Collision! Game over.");
          Game.setIsGameOver(true);
        }
      }
      newCell.setType(type);
      newCell.setDirection(dir);
      return newCell;
    } else {
      System.out.println("Out of bounds. Game over.");
      Game.setIsGameOver(true);
    }
    return null;
  }

  public void updateSnakeBodyPartsDirections() {
    Cell lastBodyCell = this.bodyParts.get(this.bodyParts.size() - 1);
    this.tail.setDirection(lastBodyCell.getDirection());

    for (int i = this.bodyParts.size() - 1; i > 0; i--) {
      Cell currentBodyCell = this.bodyParts.get(i);
      Direction leadingBodyCellDirection = this.bodyParts.get(i - 1).getDirection();

      currentBodyCell.setDirection(leadingBodyCellDirection);
    }
    this.bodyParts.get(0).setDirection(head.getDirection());

    head.setDirection(this.direction);
  }

  private boolean isCollision(Cell cell) {
    if (cell.getType() == CellType.FRUIT) {
      Game.setScore(Game.getScore() + 10);

      this.bodyParts.add(this.tail);
      this.board.generateFruit();

      return false;
    } else return cell.getType() != CellType.EMPTY;
  }

  private boolean isOutOfBounds(int row, int col) {
    return row == this.board.getRowCount() || col == this.board.getColCount() || row == -1 || col == -1;
  }
}
