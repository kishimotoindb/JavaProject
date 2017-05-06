package com.example.reusing_classes.a;

import java.util.Objects;

/**
 * Created by cuihaichen on 17-5-2.
 */

public class BaseClass {
    public Object o1 = new Object();

    public static void main(String[] args) {

    }

    public BaseClass() {
        System.out.println("base class constructor");
//        father();
//        System.out.println("base" + o1);
    }

    protected void father() {
        System.out.println("base class father");
    }

    public void first() {
        father();
    }

}
