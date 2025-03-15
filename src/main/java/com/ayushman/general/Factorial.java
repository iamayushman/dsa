package com.ayushman.general;

import com.ayushman.utils.PrintUtils;

import java.util.stream.IntStream;

public interface Factorial {
    static void main(String[] args) {

        int num = 5;

        PrintUtils.divider("Loop");
        System.out.println(factorial(num));

        PrintUtils.divider("Recursion");
        System.out.println(factorialUsingRecursion(num));

        PrintUtils.divider("Recursion");
        System.out.println(factorialUsingIntStream(num));


    }

    static int factorial(int num) {
        int ans = 1;

        for (int i = 1; i <= num; i++) {
            ans *= i;
        }
        return ans;
    }


    static int factorialUsingRecursion(int num) {
        return num == 0 ? 1 : num * factorialUsingRecursion(num - 1);
    }


    static int factorialUsingIntStream(int num) {
        return IntStream.range(1, num + 1).reduce((accumulator, a) -> accumulator * a).orElse(1);
    }

}
