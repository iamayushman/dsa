package com.ayushman.multithreading.com.ayushman;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.ayushman.utils.PrintUtils.print;

public class ReentrantExample {
  Lock lock = new ReentrantLock();

  public void outer() {
    lock.lock();
    try {
      print("outer");
      inner();
    } finally {
      lock.unlock();
    }
  }

  public void inner() {
    lock.lock();
    try {
      print("inner");
    } finally {
      lock.unlock();
    }
  }
}
