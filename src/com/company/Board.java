package com.company;

import com.company.gameObjects.Edge;
import com.company.gameObjects.Fruit;

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
    int fruitCol = ThreadLocalRandom.current().nextInt(1, colCount);
    int fruitRow = ThreadLocalRandom.current().nextInt(1, rowCount);

    addGameObject(new Fruit(new Coordinate(fruitCol, fruitRow)));
  }

  public int getRowCount() {
    return rowCount;
  }

  public int getColCount() {
    return colCount;
  }

  public void printScoreAndBoard() {
    System.out.println("Score: " + GameState.getInstance().getScore());
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        boolean isPrinted = false;
        for (GameObject gameObject : grid) {
          if (gameObject.getCoordinate().getX() == j && gameObject.getCoordinate().getY() == i) {
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
    List<GameObject> gridCopy = new ArrayList<>(grid);
    for (GameObject outer : gridCopy) {
      for (GameObject inner : gridCopy) {
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
    return gameObject.getCoordinate().getX() >= getColCount()
            || gameObject.getCoordinate().getY() >= getRowCount()
            || gameObject.getCoordinate().getX() <= -1
            || gameObject.getCoordinate().getY() <= -1;
  }

  public GameObject addGameObject(GameObject gameObject) {
    gameObject.setBoard(this);
    grid.add(gameObject);
    return gameObject;
  }

  public void removeGameObject(GameObject gameObject) {
    grid.remove(gameObject);
    gameObject.setBoard(null);
  }
}
