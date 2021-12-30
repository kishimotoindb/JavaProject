package com.example.Basic.Generic;

/**
 * 泛型通配符
 */
public class WildcardLearn {
  public static void main(String[] args) {
    Pair<Integer> pair = new Pair<>();
    Pair<?> p = pair;
    Pair<? extends Integer> p1 = pair;
    Pair<? super Integer> p2 = pair;
  }

  static class Pair<T> {
    T first;
    T second;
  }
}
