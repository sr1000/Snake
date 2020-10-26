package com.company;

public final class Game {
  private static int score = 0;
  private static boolean isGameOver = false;

  public static int getScore() {
    return score;
  }

  public static void setScore(int score) {
    Game.score = score;
  }

  public static boolean getIsGameOver() {
    return isGameOver;
  }

  public static void setIsGameOver(boolean isGameOver) {
    Game.isGameOver = isGameOver;
  }
}
