package com.luis.advent.code.day1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CaloriesReader
{
  private static final String FILE_PATH = "src/main/resources/day1/calories.txt";

  private final List<Integer> elvesCalories;

  CaloriesReader() {
    elvesCalories = new ArrayList<>();
    readFromFile(elvesCalories);
  }

  public List<Integer> getElvesCalories() {
    return elvesCalories;
  }

  private void readFromFile(final List<Integer> elvesCalories) {

    List<String> lines;
    try {
      lines = Files.readAllLines(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
      int calCounter = 0;

      for (String s: lines  ) {
        if(s.isBlank()){
          elvesCalories.add(calCounter);
          calCounter = 0;
          continue;
        }
        calCounter += Integer.parseInt(s);
      }
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public static void main(String[] args) {
    CaloriesReader caloriesReader = new CaloriesReader();
    List<Integer> cals = caloriesReader.getElvesCalories();
    System.out.println("Answer 1: " + cals.stream().max(Comparator.naturalOrder()).get());
    List<Integer> list = cals.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    int secondRes = list.get(0) + list.get(1) + list.get(2);
    System.out.println("Answer 2: " + secondRes);

  }
}