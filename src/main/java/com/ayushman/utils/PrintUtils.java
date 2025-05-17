package com.ayushman.utils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;

public interface PrintUtils {
  String ANSI_RESET = "\u001B[0m";
  String ANSI_RED = "\u001B[31m";
  String ANSI_GREEN = "\u001B[32m";
  String ANSI_BLUE = "\u001B[34m";
  String ANSI_TEAL = "\u001B[36m";

  static void divider() {
    System.out.println("============================");
  }

  static void divider(int tag) {
    divider(String.valueOf(tag));
  }

  static void divider(String tag) {
    System.out.printf(ANSI_TEAL + "%s :============================%n" + ANSI_RESET, tag);
  }

  static void print(int i) {
    System.out.println(i);
  }

  static void print(double i) {
    System.out.println(i);
  }

  static void print(boolean i) {
    System.out.println(i);
  }

  static void print(char i) {
    System.out.println(i);
  }

  static void print(long i) {
    System.out.println(i);
  }

  static void print(String i) {
    System.out.println(i);
  }

  static void print(int i, int j) {
    System.out.println(MessageFormat.format("[{0}, {1}]", i, j));
  }

  static void print(int[] arr) {
    print(null, arr);
  }

  static void print(String[] arr) {
    print(null, arr);
  }

  static void print(int[][] arr, String tag) {
    for (int i = 0; i < arr.length; i++) {
      print(tag, arr[i]);
    }
  }

  static void print(int[][] arr) {
    print(arr, null);
  }

  static void print(String tag, int[] arr) {
    System.out.println((tag != null ? (tag + ":") : ("")) + Arrays.toString(arr));
  }

  static void print(String tag, String[] arr) {
    System.out.println((tag != null ? (tag + ":") : ("")) + Arrays.toString(arr));
  }

  static void print(String tag, int[] arr, int num) {
    System.out.println(
        ANSI_RED
            + (tag != null ? (tag + ":") : (""))
            + ANSI_RESET
            + " in array : "
            + ANSI_GREEN
            + Arrays.toString(arr)
            + ANSI_RESET
            + " is: "
            + ANSI_RED
            + num
            + ANSI_RESET);
  }

  static void print(String tag, int[] arr, int num1, boolean num) {
    print(tag, arr, num1, String.valueOf(num));
  }

  static void print(String tag, int[] arr, int num1, int num) {
    print(tag, arr, num1, String.valueOf(num));
  }

  static void print(String tag, int[] arr, int num1, String num) {
    System.out.println(
        ANSI_RED
            + (tag != null ? (tag + ":") : (""))
            + ANSI_RESET
            + " in array : "
            + ANSI_GREEN
            + Arrays.toString(arr)
            + ANSI_RESET
            + " for "
            + ANSI_TEAL
            + num1
            + ANSI_RESET
            + " is: "
            + ANSI_RED
            + num
            + ANSI_RESET);
  }

  static void print(String s, double j) {
    print(s, String.valueOf(j));
  }

  static void print(String s, int j) {
    System.out.println(MessageFormat.format("[{0}, {1}]", s, j));
  }

  static void printString(String s, Object... params) {
    System.out.println(MessageFormat.format(s, params));
  }

  static void print(String s, long j) {
    System.out.println(MessageFormat.format("[{0}, {1}]", s, j));
  }

  static void print(String s, boolean test) {
    System.out.println(MessageFormat.format("[{0}, {1}]", s, String.valueOf(test)));
  }

  static void print(String s1, String s2) {
    System.out.println(MessageFormat.format("[{0}, {1}]", s1, s2));
  }

  static void print(String s1, int s2, int s3) {
    print(s1, String.valueOf(s2), String.valueOf(s3));
  }

  static void print(String s1, String s2, String s3) {
    System.out.println(MessageFormat.format("[{0}, {1}, {2}]", s1, s2, s3));
  }

  static void print(String s1, int s2, String s3, int s4) {
    System.out.println(MessageFormat.format("[{0}, {1}, {2}, {3}]", s1, s2, s3, s4));
  }

  static void print(String s1, String s2, String s3, String s4) {
    System.out.println(MessageFormat.format("[{0}, {1}, {2}, {3}]", s1, s2, s3, s4));
  }

  static <K, V> void print(Map<K, V> map) {
    System.out.print("[");
    map.forEach((k, v) -> System.out.print(MessageFormat.format("{0}->{1}, ", k, v)));
    System.out.print("]");
    print();
  }

  static void print() {
    System.out.println();
  }

  static void print(String s, char c, boolean test) {
    print(s, String.valueOf(c), String.valueOf(test));
  }

  static void print(int s, int c, int test) {
    print(String.valueOf(s), String.valueOf(c), String.valueOf(test));
  }

  static void print(int s, int c, boolean test) {
    print(String.valueOf(s), String.valueOf(c), String.valueOf(test));
  }
}
