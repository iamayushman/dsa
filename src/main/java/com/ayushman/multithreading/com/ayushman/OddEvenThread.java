package com.ayushman.multithreading.com.ayushman;

import static com.ayushman.utils.PrintUtils.print;

public class OddEvenThread {

  int counter = 50;
  int limit = 100;

  public static void main(String[] args) {

    OddEvenThread oe = new OddEvenThread();

    new Thread(oe::printOddNumbers, "Odd").start();
    new Thread(oe::printEvenNumbers, "Even").start();

  }

  private void printOddNumbers() {
    synchronized (this) {
      while (counter <= limit) {
        if ((counter & 1) != 0) {
          try {
            wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
          }
        }
        print(Thread.currentThread().getName(), counter);
        counter++;
        notifyAll();
      }
    }
  }

  private void printEvenNumbers() {
    synchronized (this) {
      while (counter <= limit) {
        if ((counter & 1) == 0) {
          try {
            wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
          }
        }
        print(Thread.currentThread().getName(), counter);
        counter++;
        notifyAll();
      }
    }
  }
}
