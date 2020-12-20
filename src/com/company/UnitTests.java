package com.company;

import com.company.gameObjects.Edge;
import com.company.gameObjects.Fruit;
import com.company.gameObjects.SnakeBody;
import com.company.gameObjects.SnakeHead;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTests {

  @Test
  public void testSnakeBodyCollision() {
    // Given
    SnakeHead snakeHead = new SnakeHead(new Coordinate(5, 5), new Direction(0, 1));
    SnakeBody snakeBody = new SnakeBody(new Coordinate(5, 4));

    // When
    snakeBody.collide(snakeHead);

    // Then
    assertTrue(GameState.getInstance().getIsGameOver());
  }

  @Test
  public void testFruitCollision() {
    // Given
    Board board = new Board(10, 10);
    SnakeHead snakeHead = new SnakeHead(new Coordinate(5, 5), new Direction(1, 0));
    Fruit fruit = new Fruit(new Coordinate(5, 5));
    board.addGameObject(snakeHead);
    board.addGameObject(fruit);
    snakeHead.extend(new SnakeBody(new Coordinate(5, 6)));

    // When
    fruit.collide(snakeHead);

    // Then
    assertEquals(10, GameState.getInstance().getScore());
  }

  @Test
  public void testEdgeCollision() {
    // Given
    Edge edge = new Edge();
    SnakeHead snakeHead = new SnakeHead(new Coordinate(5, 5), new Direction(1, 0));

    // When
    edge.collide(snakeHead);

    // Then
    assertTrue(GameState.getInstance().getIsGameOver());
  }
}
