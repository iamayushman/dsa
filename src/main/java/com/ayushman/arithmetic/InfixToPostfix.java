package com.ayushman.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Predicate;

public class InfixToPostfix {
    static final Map<Character, Integer> priority = Map.of('^', 3, '*', 2, '/', 2, '+', 1, '-', 1);
    static final Predicate<Character> isOperand = a -> (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z') || (a >= '0' && a <= '9');
    static final Predicate<Character> isOperand2 = Character::isLetterOrDigit;
    static final char OPEN_BRACKET = '(';
    static final char CLOSE_BRACKET = ')';

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)";
        System.out.println(infixToPostfix(str));
    }

    public static String infixToPostfix(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        char[] chars = str.toCharArray();
        int n = chars.length;
        int i = 0;
        while (i < n) {
            char curr = chars[i];
            if (isOperand2.test(curr)) {
                ans.append(curr);
            } else {
                if (curr == OPEN_BRACKET) {
                    stack.push(curr);
                } else if (curr == CLOSE_BRACKET) {
                    while (!stack.empty() && stack.peek() != OPEN_BRACKET) {
                        ans.append(stack.pop());
                    }
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else if (!stack.isEmpty() && priority.getOrDefault(curr, -1) > priority.getOrDefault(stack.peek(), -1)) {
                    stack.push(curr);
                } else if (!stack.isEmpty() && priority.getOrDefault(curr, -1) < priority.getOrDefault(stack.peek(), -1)) {
                    ans.append(stack.pop());
                    stack.push(curr);
                } else {
                    stack.push(curr);
                }
            }
            i++;
        }
        while (!stack.empty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}
