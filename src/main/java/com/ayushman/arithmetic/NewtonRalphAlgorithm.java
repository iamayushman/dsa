package com.ayushman.arithmetic;

import static com.ayushman.utils.PrintUtils.print;

public class NewtonRalphAlgorithm {
  public static void main(String[] args) {
    print("Sqrt of 4 is", sqrt(4));
    print("Sqrt of 16 is", sqrt(16));
    print("Sqrt of 17 is", sqrt(17));
  }

  private static double sqrt(int num) {
    double tolerance = 0.0001;
    double root;
    double x = num;
    while (true) {
      root = 0.5 * (x + (num / x));
      double ans = x - root;
      if (ans < tolerance) {
        break;
      }
      x = root;
    }
    return root;
  }
}
