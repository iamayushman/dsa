package com.ayushman.practice;

import static com.ayushman.utils.PrintUtils.print;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentIpAddresses {
  public static void main(String[] args) {
    String[] str = {
      "10.0.0.1 - GET 2020-08-24",
      "10.0.0.1 - GET 2020-08-24",
      "10.0.0.2 - GET 2020-08-20",
      "10.0.0.2 - GET 2020-08-20"
    };

    print(getMostFrequentIpAddress(str));
  }

  private static String[] getMostFrequentIpAddress(String[] str) {
    Arrays.stream(str)
        .map(i -> i.split(" - "))
        .map(i -> i[0])
        .map(String::trim)
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .ifPresent(System.out::println);
    return null;
  }
}
