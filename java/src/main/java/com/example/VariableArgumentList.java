package com.example;

/**
 * Created by cuihaichen on 17-4-18.
 */

public class VariableArgumentList {
//    public static void main(String[] args) {
//        f("5", "6", "7");
//        f(new String[]{"1", "2"});
//    }

    static void f(String... strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
