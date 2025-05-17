package com.ayushman.multithreading.com.ayushman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.ayushman.utils.PrintUtils.print;

public class BankAccount {
  private int balance;

  Lock lock = new ReentrantLock();

  BankAccount(int i) {
    this.balance = i;
  }

  public int getBalance() {
    return balance;
  }

  public void withdraw(int amount) {
    try {
      boolean locked = lock.tryLock(100, TimeUnit.MILLISECONDS);
      if (locked) {
        try {
          Thread.sleep(5_000);
          if (balance >= amount) {
            balance -= amount;
            print("Withdrawn ", amount);
          } else {
            print("Insufficient Balance.");
          }
        } catch (InterruptedException e) {
          print(Thread.currentThread().getName(), "Exception");
          Thread.currentThread().interrupt();
        } finally {
          print(Thread.currentThread().getName(), "Finally");
          lock.unlock();
        }
      } else {
        print(Thread.currentThread().getName(), "Cannot acquire lock");
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      Thread.currentThread().interrupt();
    }
  }

  public static void main(String[] args) {
    BankAccount account = new BankAccount(100);

    new Thread(() -> account.withdraw(50)).start();
    new Thread(() -> account.withdraw(50)).start();
    new Thread(() -> account.withdraw(50)).start();
  }
}
