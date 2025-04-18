package com.ayushman.arithmetic;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.Predicate;

import static com.ayushman.arithmetic.InfixToPostfix.*;

public class InfixToPrefix {

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)";
        String rev1 = reverse(str);
        String infixToPostfix = infixToPostfix(rev1);
        System.out.println(reverse(infixToPostfix));

    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            char tmp = chars[end];
            chars[end] = chars[start];
            chars[start] = tmp;

            if (chars[end] == OPEN_BRACKET) {
                chars[end] = CLOSE_BRACKET;
            }
            if (chars[start] == OPEN_BRACKET) {
                chars[start] = CLOSE_BRACKET;
            }
            if (chars[start] == CLOSE_BRACKET) {
                chars[start] = OPEN_BRACKET;
            }
            if (chars[end] == CLOSE_BRACKET) {
                chars[end] = OPEN_BRACKET;
            }

            start++;
            end--;

        }
        return String.valueOf(chars);
    }
}
