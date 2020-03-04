package com.example.Basic.inherit.constructor_protected1;

/**
 * Created by BigFaceBear on 2019.08.27
 */
public class Father {
    protected Father() {
        System.out.println("father constructor");
    }

    protected Father(int i) {
        System.out.println("father constructor i");
    }

    private Father(String s) {
        System.out.println("father constructor string");
    }
}
