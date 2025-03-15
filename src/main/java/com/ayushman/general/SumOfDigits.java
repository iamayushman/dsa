package com.ayushman.general;

import com.ayushman.utils.PrintUtils;

public interface SumOfDigits {
    static void main(String[] args) {
        System.out.println("Digit sum of '123' is: " + sumOfDigits(123));
        System.out.println("Digit sum of '-123' is: " + sumOfDigits(-123));
        PrintUtils.divider("Single line for loop");
        System.out.println("Digit sum of '123' is: " + sumOfDigitsSingleLine(123));
        System.out.println("Digit sum of '-123' is: " + sumOfDigitsSingleLine(-123));
        PrintUtils.divider("Recursion");
        System.out.println("Digit sum of '123' is: " + sumOfDigitsRecursion(123));
        System.out.println("Digit sum of '-123' is: " + sumOfDigitsRecursion(-123));
    }


    static int sumOfDigits(int number) {
        int ans = 0;
        number = Math.abs(number);
        while (number > 0) {
            ans += number % 10;
            number /= 10;
        }
        return ans;
    }

    static int sumOfDigitsSingleLine(int number) {
        int sum;
        number = Math.abs(number);

        for (sum = 0; number > 0; sum += number % 10, number /= 10) ;
        return sum;
    }

    static int sumOfDigitsRecursion(int number) {
        number = Math.abs(number);
        return number == 0 ? 0 : number % 10 + sumOfDigitsRecursion(number / 10);
    }
}
