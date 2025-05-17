package com.ayushman.practice;

import com.ayushman.data.types.Characters;

import java.util.HashMap;
import java.util.Map;

import static com.ayushman.utils.PrintUtils.print;

public class AnagramStrings {
  public static void main(String[] args) {
    String str1 = "Listen", str2 = "Silent";
    print(isAnagram(str1, str2));
    String str3 = "1Listen", str4 = "Silent";
    print(isAnagram(str3, str4));
  }

  private static boolean isAnagram(String str1, String str2) {
    int n1 = str1.length(), n2 = str2.length();
    if (n1 != n2) {
      return false;
    }

    Map<Character, Integer> frq1 = new HashMap<>();
    Map<Character, Integer> frq2 = new HashMap<>();

    for (int i = 0; i < n1; i++) {
      char c1 = Character.toLowerCase(str1.charAt(i));
      char c2 = Character.toLowerCase(str2.charAt(i));
      frq1.put(c1, frq1.getOrDefault(c1, 0) + 1);
      frq2.put(c2, frq2.getOrDefault(c2, 0) + 1);
    }
    for (var e : frq1.entrySet()) {
      if (!frq2.getOrDefault(e.getKey(), -1).equals(e.getValue())) {
        return false;
      }
    }

    return true;
  }
}
