package com.ayushman.general;

public interface FactorsOfANumber {
    static void main(String[] args) {
        factorsOfANumberSimple(100);
        factorsOfANumber(100);
        factorsOfANumberOrdered(100);
        factorsOfANegativeNumber(-100);
    }

    // un-ordered
    static void factorsOfANumberSimple(int number) {
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    // un-ordered
    static void factorsOfANumber(int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                if (i == number / i) System.out.print(i + ", ");
                else System.out.print(i + ", " + number / i + ", ");
            }
        }
        System.out.println();
    }

    // ordered
    static void factorsOfANumberOrdered(int number) {
        int sqrt = (int) Math.sqrt(number);
        boolean flag = false;
        int i;
        for (i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                if (i == number / i) flag = true;
            }
        }

        if (flag) i -= 2;


        for (; i >= 1; i--) {
            if (number % i == 0) System.out.print(number / i + " ");
        }

        System.out.println();
    }

    static void factorsOfANegativeNumber(int number) {
        int num = Math.abs(number);
        for (int i = number; i < num; i++) {
            if (i == 0) {
                continue;
            }
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
