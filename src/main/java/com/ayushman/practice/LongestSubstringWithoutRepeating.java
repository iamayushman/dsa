package com.ayushman.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.ayushman.utils.PrintUtils.print;
import static java.lang.Integer.MIN_VALUE;

/**
 * We own a Courier Company and own fleet of different kind of vehicle (Bike, Truck etc). We need to
 * deliver parcel weighing W kg from warehouse to destination which is D km away. In the beginning
 * each vehicle has L Liters of fuel. There are N fuel station between the source and destination,
 * each petrol station is situated at S km away from warehouse and has P Liter of Fuel available. We
 * want to deliver the parcel to destination with minimum number of stops possible. You can assume
 * to mileage to be 1L/km to begin with.
 *
 * <p>Example - W = 50kg, D = 15Km, L = 4L N = 4 Following represent the distance and amount of Fuel
 * available for each Fuel Station 4, 4 ----> 4km 4L 6, 8 ----> 8, 3 ----> 0f (7) 10, 5 ---> 1f +5l
 * > 5 Minimum number of stops needed in the above case is 2.
 *
 * <p>if(count > N){ return -1; } d = 15 l = 4 int[] arr = {{4,4}, {6, 8}, {8, 3}, {10,5}}
 *
 * <p>------------------------------------
 *
 * <p>Given a string s, find the length of the longest substring without duplicate characters.
 *
 * <p>Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3.
 *
 * <p>Example 2: Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 *
 * <p>abcefhjabcbb | |
 *
 * <p>public int longestSubString(String str){ Map<Character, Integer> map = new HashMap<>(); int
 * start = 0, end= 1, n = str.length(); if(n < 2){ return n; } while(end<n){ char c =
 * str.charAt(start) map.put(c, map.getOrDefault(c, 0) + 1); if(str.charAt(start) ==
 * str.charAt(end)){ start++; } else { end++; } } return str.subString(end - start + 1); }
 */
public class LongestSubstringWithoutRepeating {

  public static void main(String[] args) {

    print(longestSubstring("abrakadabra"));
    print(longestSubstring2("abrakadabra"));

    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstringOOn("abcabcbb"));

    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstringOOn("bbbbb"));
  }

  public static String longestSubstring2(String str) {
    int start = 0, end = 0, n = str.length(), startIndex = -1, maxLen = MIN_VALUE;
    Map<Character, Integer> map = new HashMap<>();
    while (end < n) {
      char c = str.charAt(end);
      if (map.getOrDefault(c, -1) >= start) {
        start = map.get(c) + 1;
      }
      int size = end - start + 1;
      if (size > maxLen) {
        maxLen = size;
        startIndex = start;
      }
      map.put(c, end);
      end++;
    }
    return maxLen == MIN_VALUE ? "" : str.substring(startIndex, startIndex + maxLen);
  }

  //  O(2n)
  public static String longestSubstring(String str) {
    int start = 0, end = 0, n = str.length(), maxLen = MIN_VALUE, startIndex = -1;
    Set<Character> set = new HashSet<>();
    while (end < n) {
      char c = str.charAt(end);
      while (set.contains(c)) {
        set.remove(str.charAt(start));
        start++;
      }
      set.add(c);
      int size = end - start + 1;
      if (size > maxLen) {
        maxLen = size;
        startIndex = start;
      }
      end++;
    }
    return maxLen == MIN_VALUE ? "" : str.substring(startIndex, maxLen + startIndex);
  }

  // O(n)
  public static String lengthOfLongestSubstringOOn(String str) {
    int start = 0, end = 0, maxStart = -1, maxLen = MIN_VALUE, n = str.length();
    Map<Character, Integer> map = new HashMap<>();
    while (end < n) {
      char c = str.charAt(end);
      if (map.getOrDefault(c, -1) >= start) {
        start = map.get(c) + 1;
      }
      int size = end - start + 1;
      if (size > maxLen) {
        maxLen = size;
        maxStart = start;
      }
      map.put(c, end);
      end++;
    }
    return maxLen == MIN_VALUE ? "" : str.substring(maxStart, maxStart + maxLen);
  }

  // O(2n)
  public static String lengthOfLongestSubstring(String str) {
    int start = 0, end = 0, maxStart = -1, maxLen = MIN_VALUE, n = str.length();
    Set<Character> set = new HashSet<>();
    while (end < n) {
      char c = str.charAt(end);
      while (set.contains(c)) {
        set.remove(str.charAt(start));
        start++;
      }
      set.add(c);
      int size = end - start + 1;
      if (size > maxLen) {
        maxLen = size;
        maxStart = start;
      }
      end++;
    }
    return maxLen == MIN_VALUE ? "" : str.substring(maxStart, maxStart + maxLen);
  }
}
