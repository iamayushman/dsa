package com.ayushman.stacks;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String name = "Ayushman";
        String name2 = "Naman";

        System.out.println(reverse(name));
        System.out.println(reverse(name2));
    }

    private static String reverse(String name) {

        Stack<Character> stack = new Stack<>();
        for (char c : name.toCharArray()) {
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
