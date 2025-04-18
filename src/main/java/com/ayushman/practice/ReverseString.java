package com.ayushman.practice;

import java.util.Collections;
import java.util.Stack;

public class ReverseString {
  public static void main(String[] args) {
    String str = "myNameIsKhan";
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      s.push(str.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < str.length(); j++) {
      sb.append(s.pop());
    }
    System.out.println(sb);
  }
}
