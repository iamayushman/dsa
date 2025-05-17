package com.ayushman.multithreading.com.ayushman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.ayushman.utils.PrintUtils.print;

public class RaceCondition {
  public static void main(String[] args) {
    Counter counter;
    try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
      counter = new Counter();

      for (int i = 0; i < 10000; i++) {
        executorService.submit(counter::increment);
      }

      executorService.shutdown();
      boolean b = executorService.awaitTermination(60, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
    print(counter.getCount());
  }
}

class Counter {
  int count = 0;

  public synchronized void increment() {
    count = count + 1;
  }

  public int getCount() {
    return count;
  }

}
