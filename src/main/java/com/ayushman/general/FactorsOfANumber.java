package com.ayushman.general;

public interface FactorsOfANumber {
    static void main(String[] args) {
        factorsOfANumber(10);
    }

    static void factorsOfANumber(int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = 1; i < sqrt; i++) {
            if (number % i == 0) {
                if (number / i == i) {
                    System.out.println(i);
                } else {
                    System.out.println(number / i);
                }
            }
        }
    }
}
