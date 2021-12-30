package com.example.Basic.staticextend;

/**
 * @author cuihaichen on 12/30/21
 */
class Child extends Parent {
  public static void main(String[] args) {
    System.out.println("child main");
  }

  public void nonstatic() {
    System.out.println("child nonstatic");
  }
}
