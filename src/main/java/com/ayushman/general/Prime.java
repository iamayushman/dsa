package com.ayushman.general;

import com.ayushman.utils.PrintUtils;

public interface Prime {
    static void main(String[] args) {

        for (int i = -3; i < 10; i++) {
            PrintUtils.divider();
            System.out.println(i + " is " + (isPrime(i) ? "" : "NOT ") + "prime.");
            System.out.println(i + " is " + (isPrimeHalf(i) ? "" : "NOT ") + "prime.");
            System.out.println(i + " is " + (isPrimeSqrtOfN(i) ? "" : "NOT ") + "prime.");
            System.out.println(i + " is " + (isPrime6KPlusMinus1(i) ? "" : "NOT ") + "prime.");
        }
    }

    static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    static boolean isPrimeHalf(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    static boolean isPrimeSqrtOfN(int number) {
        if (number <= 1) return false;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /* 6k+-1*/
    static boolean isPrime6KPlusMinus1(int number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3)
            return true;
        if (number % 2 == 0 || number % 3 == 0)
            return false;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i = i + 6) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
