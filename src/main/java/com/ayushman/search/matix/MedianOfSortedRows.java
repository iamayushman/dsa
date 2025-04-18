package com.ayushman.search.matix;

import static com.ayushman.utils.PrintUtils.print;

public class MedianOfSortedRows {
  public static void main(String[] args) {
    int[][] arr = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
    int[][] arr2 = {{1, 16, 19}, {5, 12, 17}, {5, 27, 29}};
    //    print(findMedian(arr));
    print(Math.pow(10, 9));
//    print(median(arr2));
  }

  static int median(int[][] matrix) {
    // code here
    // total elements
    int N = matrix.length * matrix[0].length;
    int medianIndex = N / 2;
    int start = 1;
    int end = (int) Math.pow(10, 9);

    while (start <= end) {
      int assumedMedian = start + (end - start) / 2;
      // no of elements less than assumed median.
      // k -> lesserElements
      int lesserElements = findSmallerElements(matrix, assumedMedian);
      if (lesserElements <= medianIndex) {
        start = assumedMedian + 1;
      } else {
        end = assumedMedian - 1;
      }
    }
    return start;
  }

  static int findSmallerElements(int matrix[][], int assumedMedian) {
    int noOfSmallerElements = 0;
    // traverse row by row
    for (int i = 0; i < matrix.length; i++) {
      // matrix[i] -> 0,1,2
      // apply binary search on matrix[i]
      //            int arr[] = matrix[i];
      int start = 0;
      int end = matrix[i].length - 1;
      while (start <= end) {
        int mid = start + (end - start) / 2;
        if (matrix[i][mid] <= assumedMedian) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
      // start.
      noOfSmallerElements += start;
    }
    return noOfSmallerElements;
  }
}
