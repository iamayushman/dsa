package com.ayushman.multithreading.com.ayushman;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ExecutorDemo {
  public static void main(String[] args) {
    CompletableFuture<Integer> futures = CompletableFuture.supplyAsync(ExecutorDemo::process);
    futures.whenComplete(
        (d, e) -> {
          System.out.println(d);
        });
    futures.join();
  }

  private static int process() {
    try {
      sleep(3_000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
    return 1;
  }
}
