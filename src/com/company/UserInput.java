package com.company;

import java.io.IOException;

public class UserInput {

  public UserInput() {
  }

  public Direction getNewDirection() throws IOException {
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
}
