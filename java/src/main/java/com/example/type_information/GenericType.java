package com.example.type_information;

/**
 * Created by cuihaichen on 17-5-20.
 */

public class GenericType {
    Class<?> b = B.class;

    public static void main() {
        A b = new B();

    }
}

class A{

}

class B extends A{

}
