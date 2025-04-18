package com.ayushman.search.linear;

import java.text.MessageFormat;
import java.util.Optional;

public interface TwoDArray {
    static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Optional<Pair<Integer>> res1 = indexOf(matrix, 8);
        Optional<Pair<Integer>> res2 = indexOf(matrix, 10);

    }

    static Optional<Pair<Integer>> indexOf(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == target) {
                    System.out.println(MessageFormat.format("Found {0} at {1} row, {2} column", target, row + 1, column + 1));
                    return Optional.of(new Pair<>(row, column));
                }
            }
        }
        System.out.println(MessageFormat.format("Cannot find {0}", target));
        return Optional.empty();
    }

    class Pair<T> {
        T first;
        T second;

        Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }
}
