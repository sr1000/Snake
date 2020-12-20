package com.company;

import com.company.gameObjects.SnakeBody;
import com.company.gameObjects.SnakeHead;
import com.company.gameObjects.Teleporter;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Direction direction;
    int rowCount = 10;
    int colCount = 20;
    Board board = new Board(rowCount, colCount);
    Teleporter teleporter = new Teleporter(new Coordinate(8, 8));
    board.addGameObject(teleporter);
    SnakeHead snakeHead = new SnakeHead(new Coordinate(5, 5), new Direction(1, 0));
    board.addGameObject(snakeHead);
    snakeHead.extend(new SnakeBody(new Coordinate(5, 6)));
    snakeHead.extend();
    snakeHead.extend();

    board.generateFruit();
    printScoreAndBoard(board);

    while (!GameState.getInstance().getIsGameOver()) {
      direction = getUserInput();

      if (direction == null) {
        continue;
      }

      snakeHead.setDirection(direction);
      snakeHead.move();

      board.update();
      printScoreAndBoard(board);
    }
  }

  public static Direction getUserInput() throws IOException {
    System.out.println("Enter a direction (WASD) and press enter: ");
    char userInput = (char) Character.toLowerCase(System.in.read());
    if (userInput == 'w') {
      return new Direction(0, -1);
    } else if (userInput == 'a') {
      return new Direction(-1, 0);
    } else if (userInput == 's') {
      return new Direction(0, 1);
    } else if (userInput == 'd') {
      return new Direction(1, 0);
    } else {
      return null;
    }
  }

  public static void printScoreAndBoard(Board board) {
    System.out.println("Score: " + GameState.getInstance().getScore());
    board.printBoard();
  }
}
