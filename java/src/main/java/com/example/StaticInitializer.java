package com.example;

/**
 * Created by cuihaichen on 17-4-12.
 */

public class StaticInitializer {
    public static void main(String[] args) {
//        System.out.println("Inside main()");
//        Cups.cup1.f(99);
        Cup.print();
    }

//    static Cups cups1 = new Cups(); // (2)
//    static Cups cups2 = new Cups(); // (2)
}

class Cup {
    static{
        s2 = "s22";
        a1 = new int[]{1, 2, 2};
    }

    static String s1 = "s11";
    static String s2="s21";
    static int[] a1;

    static{
        s1 = "s12";
    }


    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }

    static void print() {
        System.out.println(s1);
        System.out.println(s2);
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}