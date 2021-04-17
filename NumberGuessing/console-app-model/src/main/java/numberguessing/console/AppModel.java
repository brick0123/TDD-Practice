package numberguessing.console;

import numberguessing.PositiveIntegerGenerator;

public final class AppModel {

  private final static String NEW_LINE = System.lineSeparator();

  private int answer;
  private int triesCount;
  private String output;
  private boolean completed;
  private boolean singlePlayerMode;

  public AppModel(PositiveIntegerGenerator generator) {
    completed = false;
    output =
        "1: Single player game" + NEW_LINE +
            "2: Multiplayer game" + NEW_LINE +
            "3: Exit" + NEW_LINE + "Enter selection: ";

    answer = generator.generateLessThanOrEqualToHundred();
    singlePlayerMode = false;
  }

  public boolean isCompleted() {
    return completed;
  }

  public String flushOutput() {
    return output;
  }

  public void processInput(String input) {
    if (singlePlayerMode) {
      singlePlayMode(input);
    } else {
      processModeSelection(input);
    }
  }

  private void singlePlayMode(String input) {
    triesCount++;

    int guess = Integer.parseInt(input);
    if (guess < answer) {
      output = "Your guess is too low." + NEW_LINE + "Enter your guess: ";
    } else if (guess > answer) {
      output = "Your guess is too high." + NEW_LINE + "Enter your guess: ";
    } else {
      output = "Correct! " + triesCount + " guesses." + NEW_LINE;
    }
  }

  private void processModeSelection(String input) {
    if ("1".equals(input)) {
      output = "Single player game" + NEW_LINE + "I'm thinking of a number between 1 and 100."
          + NEW_LINE + "Enter your guess: ";
      singlePlayerMode = true;
    } else {
      completed = true;
    }
  }
}
