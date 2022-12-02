package com.luis.advent.code.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class RockPaperScissors
{
  private static final String FILE_PATH = "src/main/resources/day2/strategy.txt";

  private static final Map<String, Integer> rulesPart1 = Map.of(
      "A X", 3,
      "A Y", 6,
      "A Z", 0,
      "B X", 0,
      "B Y", 3,
      "B Z", 6,
      "C X", 6,
      "C Y", 0,
      "C Z", 3
  );

  private static final Map<String, String> rulesPart2 = Map.of(
      "A X", "A Z",
      "A Y", "A X",
      "A Z", "A Y",
      "C X", "C Y",
      "C Y", "C Z",
      "C Z", "C X"
  );

  public static void main(String[] args) {
    runDay2();
  }

  private static void runDay2(){
    try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
      String line;
      int scorePart1 = 0;
      int scorePart2 = 0;
      while((line = br.readLine()) != null){
        scorePart1 += getResultPart1(line);
        scorePart2 += getResultPart2(line);
      }
      System.out.println("The total score of part one is:" + scorePart1);
      System.out.println("The total score of part two is:" + scorePart2);
    }
    catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static int getResultPart2(final String s) {
    return getPointsShapeSelected(rulesPart2.get(s) == null ? s.charAt(2):rulesPart2.get(s).charAt(2)) +
        rulesPart1.get(rulesPart2.get(s) == null ? s:rulesPart2.get(s));
  }

  private static int getResultPart1(final String s) {
    return getPointsShapeSelected(s.charAt(2)) + rulesPart1.get(s);
  }

  private static int getPointsShapeSelected(final char s) {
    switch(s){
      case 'X':
        return 1;
      case 'Y':
        return 2;
      case 'Z':
        return 3;
      default:
        return 0;
    }
  }
}
