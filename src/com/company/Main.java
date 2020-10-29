package com.company;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Direction direction;
    int rowCount = 10;
    int colCount = 20;
    Board board = new Board(rowCount, colCount);
    Snake snake = new Snake(board);

    board.generateFruit();
    printScoreAndBoard(board);

    while (!Game.getIsGameOver()) {
      direction = getUserInput();

      if (direction == null) {
        continue;
      }

      snake.setDirection(direction);
      snake.updateSnakeBodyPartsDirections();
      snake.moveSnake();

      printScoreAndBoard(board);
    }
  }

  public static Direction getUserInput() throws IOException {
    System.out.println("Enter a direction (WASD) and press enter: ");
    int userInput = System.in.read();
    if (userInput == 68 || userInput == 100) {
      return Direction.EAST;
    } else if (userInput == 65 || userInput == 97) {
      return Direction.WEST;
    } else if (userInput == 119 || userInput == 87) {
      return Direction.NORTH;
    } else if (userInput == 115 || userInput == 83) {
      return Direction.SOUTH;
    } else {
      return null;
    }
  }

  public static void printScoreAndBoard(Board board) {
    System.out.println("Score: " + Game.getScore());
    board.printBoard();
  }
}
