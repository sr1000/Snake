package com.company;

public final class GameState {
  private static int score = 0;
  private static boolean isGameOver = false;

  public static int getScore() {
    return score;
  }

  public static void setScore(int score) {
    GameState.score = score;
  }

  public static boolean getIsGameOver() {
    return isGameOver;
  }

  public static void setIsGameOver(boolean isGameOver) {
    GameState.isGameOver = isGameOver;
  }
}
