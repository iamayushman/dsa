package com.ayushman.general;

public interface SquareRootOfANumber {
    static void main(String[] args) {
        System.out.println((int) sqrt(16));
    }

    static double sqrt(double number) {
        double x = number;
        double root;

        while (true) {
            root = 0.5 * (x + (number / x));
            if (Math.abs(root - x) < 1) {
                break;
            } else x = root;
        }
        return root;
    }

}
