package com.example.Basic.reusing_classes.a;

/**
 * Created by cuihaichen on 17-5-2.
 */

public class BaseClass {
    public Object o1 = new Object();

    public static void main(String[] args) {

    }

    public BaseClass() {
        System.out.println("base class constructor");
//        Father();
//        System.out.println("base" + o1);
    }

    protected void father() {
        System.out.println("base class Father");
    }

    public void first() {
        father();
    }

}
