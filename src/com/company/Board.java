package com.company;

import com.company.gameObjects.Edge;
import com.company.gameObjects.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
  private static final Edge edge = new Edge();
  private final int rowCount;
  private final int colCount;
  private final List<GameObject> grid;

  public Board(int rowCount, int colCount) {
    this.rowCount = rowCount;
    this.colCount = colCount;

    this.grid = new ArrayList<>();
  }

  public void generateFruit() {
    int fruitCol = ThreadLocalRandom.current().nextInt(1, this.colCount);
    int fruitRow = ThreadLocalRandom.current().nextInt(1, this.rowCount);

    addGameObject(new Food(new Coordinate(fruitCol, fruitRow)));
  }

  public int getRowCount() {
    return rowCount;
  }

  public int getColCount() {
    return colCount;
  }

  public void printBoard() {
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        boolean isPrinted = false;
        for (GameObject gameObject : grid) {
          if (gameObject.getCoord().getY() == i && gameObject.getCoord().getX() == j) {
            System.out.print(gameObject.getDisplay());
            isPrinted = true;
            break;
          }
        }
        if (!isPrinted) {
          System.out.print('.');
        }
      }
      System.out.println();
    }
  }

  public void update() {
    List<GameObject> grid2 = new ArrayList<>(grid);
    for (GameObject outer : grid2) {
      for (GameObject inner : grid2) {
        if (outer == inner) {
          continue;
        }
        if (outer.checkCollision(inner)) {
          outer.collide(inner);
        }
        if (isOutOfBounds(outer)) {
          edge.collide(outer);
        }
      }
    }
  }

  private boolean isOutOfBounds(GameObject gameObject) {
    return gameObject.getCoord().getX() >= this.getColCount()
            || gameObject.getCoord().getY() >= this.getRowCount()
            || gameObject.getCoord().getX() <= -1
            || gameObject.getCoord().getY() <= -1;
  }

  public GameObject addGameObject(GameObject gameObject) {
    gameObject.setBoard(this);
    this.grid.add(gameObject);
    return gameObject;
  }

  public void removeGameObject(GameObject gameObject) {
    grid.remove(gameObject);
    gameObject.setBoard(null);
  }
}
