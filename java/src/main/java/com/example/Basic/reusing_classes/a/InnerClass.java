package com.example.Basic.reusing_classes.a;

/**
 * 问题列表
 * 1.内部类并不是伴随着外部类的加载而加载
 */

public class InnerClass {
    public static void main(String[] args) {
        new InnerClass();
        new InnerStatic();
    }

   static class Inheritance extends InnerClass{

    }

    static {
        System.out.println("inner class loaded");
    }

    InnerClass() {
        System.out.println("inner class constructor");
    }

    class InnerNonStatic {
        InnerNonStatic() {
            System.out.println("inner non-static class constructor");
        }
    }

    static class InnerStatic {
        static {
            System.out.println("inner static class loaded");
        }

        InnerStatic() {
            System.out.println("inner static class constructor");
        }
    }
}
