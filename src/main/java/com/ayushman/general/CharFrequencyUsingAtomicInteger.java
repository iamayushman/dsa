package com.ayushman.general;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CharFrequencyUsingAtomicInteger {

  public static void main(String[] args) {
    System.out.println(charFrequencyWithGetAndIncrementComputeIfAbsent("sentence"));
  }

  public static Map<Character, AtomicInteger> charFrequencyWithGetAndIncrementComputeIfAbsent(
      String sentence) {
    Map<Character, AtomicInteger> charMap = new HashMap<>();
    for (int c = 0; c < sentence.length(); c++) {
      charMap.computeIfAbsent(sentence.charAt(c), k -> new AtomicInteger(0)).incrementAndGet();
    }
    return charMap;
  }
}
