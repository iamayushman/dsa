package com.ayushman.array;

import java.util.Arrays;
import java.util.Scanner;

import static com.ayushman.utils.PrintUtils.*;

public class BasicArrayOperation {
  public static void main(String[] args) {
    // create array
    //    creatingArray();

    // input array item
    //    inputArrayItems();

    // insert into array
    //    insertIntoArray();

    // delete from array
    //        deleteFromArray();

    // 2d array [[1,2], [3,4], [5,6]]

    // create array
    //    creating2dArray();

    // input array item
    //    input2dArrayItems();

    // insert into array
    //    insertInto2dArray();

    // delete from array
    deleteFrom2dArray();
  }

  private static void deleteFrom2dArray() {
    int[][] nums = create(5, 3, 2);
    printArray(nums);
    divider();
    for (int i = 0; i < nums.length; i++) {
      deleteAt(nums[i], 2);
    }
    printArray(nums);
  }

  private static void insertInto2dArray() {
    int[][] nums = create(5, 3, 2);
    printArray(nums);
    divider();
    for (int i = 0; i < nums.length; i++) {
      insertAt(nums[i], 2, 1);
    }
    printArray(nums);
  }

  private static void creating2dArray() {
    int[][] arr = new int[3][2];
    int[][] arr1 = new int[1][];
    int[][] arr2 = {
      {1, 2},
      {3, 4},
      {5, 6, 7}, // jacked array
      {8, 9}
    };
    int[][] arr3 = create(3, 2, -1);
    int[][] arr4 = create(3, 2, 0);
    printArray(arr4);
  }

  public static int[][] create(int size1, int size2, int initialValue) {
    int[][] arr = new int[size1][size2];
    for (int i = 0; i < arr.length; i++) {
      Arrays.fill(arr[i], initialValue);
    }
    return arr;
  }

  private static void deleteFromArray() {
    int[] arr = new int[] {1, 2, 3, 4, 5};
    printArray(arr);
    deleteAt(arr, 0);
    deleteAt(arr, 2);
    printArray(arr);
  }

  private static void deleteAt(int[] arr, int position) {
    int n = arr.length;

    for (int i = position; i < n - 2; i++) {
      arr[i] = arr[i + 1];
    }
    arr[n - 1] = 0;
  }

  private static void insertIntoArray() {
    int[] arr = new int[5];
    printArray(arr);
    insertAt(arr, 0, 1);
    insertAt(arr, 1, 88);
    printArray(arr);
    insertAt(arr, 2, 44);
    printArray(arr);
    insertAt(arr, 3, 33);
    printArray(arr);
    insertAt(arr, arr.length - 1, 9);
    printArray(arr);
  }

  private static void insertAt(int[] arr, int position, int value) {
    int n = arr.length;

    if (position < 0 || position > n - 1) {
      printString("Cannot insert at {0}", position);
    }

    for (int i = n - 2; i >= position; i--) {
      arr[i + 1] = arr[i];
    }
    arr[position] = value;
  }

  private static void inputArrayItems() {
    Scanner scanner = new Scanner(System.in);
    print("Enter array size");
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      printString("Enter {0} element of array", i);
      arr[i] = scanner.nextInt();
    }
    printArray(arr);
  }

  private static void input2dArrayItems() {
    Scanner scanner = new Scanner(System.in);
    print("Enter array size");
    int n = scanner.nextInt();
    int[][] arr = new int[n][];
    for (int i = 0; i < n; i++) {
      printString("Enter {0} sub-array size", i + 1);
      int m = scanner.nextInt();
      arr[i] = new int[m];
      for (int j = 0; j < m; j++) {
        printString("enter element at [{0},{1}]: ", i, j);
        arr[i][j] = scanner.nextInt();
      }
    }
    printArray(arr);
  }

  private static void creatingArray() {
    // Method 1 :
    int[] arr1 = new int[10];
    int[] arr2 = new int[] {1, 2, 3, 4, 5};
    int[] arr3 = {1, 2, 3, 4, 5};
    int[] arr4 = create(5, 0);
    int[] arr5 = create(5, -1);
    printArray(arr5);
  }

  private static void printArray(int[][] arr) {
    for (int[] nums : arr) {
      printArray(nums);
    }
  }

  private static void printArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i != arr.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.print("]");
    System.out.println();
  }

  public static int[] create(int size, int initialValue) {
    int[] arr = new int[size];
    //    for (int i = 0; i < size; i++) {
    //      arr[i] = initialValue;
    //    }
    Arrays.fill(arr, initialValue);
    return arr;
  }
}
