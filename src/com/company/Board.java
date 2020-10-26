package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
  private final int rowCount;
  private final int colCount;
  private final Cell[][] grid;

  public Board(int rowCount, int colCount) {
    this.rowCount = rowCount;
    this.colCount = colCount;

    this.grid = initializeBoard(rowCount, colCount);
  }

  public void generateFruit() {
    int fruitCol = ThreadLocalRandom.current().nextInt(1, this.colCount);
    int fruitRow = ThreadLocalRandom.current().nextInt(1, this.rowCount);

    this.grid[fruitRow][fruitCol].setType(CellType.FRUIT);
  }

  public Cell getCell(int row, int col) {
    return this.grid[row][col];
  }

  public int getRowCount() {
    return rowCount;
  }

  public int getColCount() {
    return colCount;
  }

  public void printBoard() {
    for (Cell[] row : grid) {
      for (Cell col : row) {
        col.printCell();
      }
      System.out.println();
    }
  }

  private Cell[][] initializeBoard(int rowCount, int colCount) {
    Cell[][] grid = new Cell[rowCount][colCount];
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        grid[i][j] = new Cell(i, j);
      }
    }
    return grid;
  }
}
