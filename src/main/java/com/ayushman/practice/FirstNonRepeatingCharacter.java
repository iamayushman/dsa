package com.ayushman.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.ayushman.utils.PrintUtils.print;

public class FirstNonRepeatingCharacter {
  public static void main(String[] args) {
    String str = "apple";
    print(firstNonRepeatingCharacter(str));
    firstNonRepeatingCharacterStream(str);
  }

  private static char firstNonRepeatingCharacter(String str) {

    int[] freq = new int[256];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      freq[c]++;
    }
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (freq[c] == 1) {
        return c;
      }
    }
    return '\0';
  }

  private static void firstNonRepeatingCharacterStream(String str) {
    str
        .chars()
        .mapToObj(i -> (char) i)
        .map(Character::toLowerCase)
        .collect(
            Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .ifPresent(System.out::println);
  }
}
