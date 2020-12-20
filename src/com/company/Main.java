package com.company;

import com.company.gameObjects.Constants;
import com.company.gameObjects.SnakeBody;
import com.company.gameObjects.SnakeHead;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Direction direction;
    UserInput userInput = new UserInput();
    Board board = new Board(Constants.ROW_COUNT, Constants.COL_COUNT);
    SnakeHead snakeHead = new SnakeHead(new Coordinate(Constants.STARTING_ROW, Constants.STARTING_COL), new Direction(1, 0));

    startGame(board, snakeHead);

    while (!GameState.getInstance().getIsGameOver()) {
      direction = userInput.getNewDirection();

      if (direction == null) {
        continue;
      }

      snakeHead.setDirection(direction);
      snakeHead.move();

      board.update();
      board.printScoreAndBoard();
    }
  }

  private static void startGame(Board board, SnakeHead snakeHead) {
    board.addGameObject(snakeHead);
    snakeHead.extend(new SnakeBody(new Coordinate(Constants.STARTING_ROW, Constants.STARTING_COL + 1)));

    board.generateFruit();
    board.printScoreAndBoard();
  }
}
