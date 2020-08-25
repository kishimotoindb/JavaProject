package com.example.Basic.classloader;

/**
 * Created by cuihaichen on 2020.08.25
 */
class ClassDoInitialize {

    static {
        System.out.println("class ClassDoInitialize do initialize");
    }

    static final int COUNT=1;
    static final Outer OUTER = new Outer();

    void nonStaticMethod() {

    }
}
