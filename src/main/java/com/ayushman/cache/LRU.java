package com.ayushman.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {

  int capacity;
  HashMap<Integer, String> cache = new HashMap<>();
  LinkedList<Integer> cacheOrder = new LinkedList<>();

  LRU(int capacity) {
    this.capacity = capacity;
  }

  public static void main(String[] args) {
    LRU cacher = new LRU(10);
    cacher.add(1, "Ram");
    cacher.add(2, "Shyam");
    cacher.add(3, "Ronny");
  }

  private void add(int key, String value) {
    if (cache.size() >= capacity) {
      Integer removed = cacheOrder.removeLast();
      cache.remove(removed);
    }
    cache.put(key, value);
    cacheOrder.addFirst(key);
  }

  private String get(int key) {
    String value = cache.get(key);
    if (value != null) {
      cacheOrder.remove(key);
      cacheOrder.addFirst(key);
      return value;
    }
    return null;
  }
}

