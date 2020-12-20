package com.company;

public final class GameState {
  private int score = 0;
  private boolean isGameOver = false;
  private static GameState instance;

  private GameState() {
  }

  public synchronized static GameState getInstance() {
    if (instance == null) {
      instance = new GameState();
    }
    return instance;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public boolean getIsGameOver() {
    return isGameOver;
  }

  public void setIsGameOver(boolean isGameOver) {
    this.isGameOver = isGameOver;
  }
}
