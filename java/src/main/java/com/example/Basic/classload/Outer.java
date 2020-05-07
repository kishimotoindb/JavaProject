package com.example.Basic.classload;

public class Outer {

    static {
        System.out.println("staticOuter");
    }

    public static void main(String[] args) {
        System.out.println("Outer");

    }

    /*
     * 静态内部类在外部类加载的时候，如果没有被使用，不会被加载。
     * 加载静态内部类，如果没有使用外部类，同样不会加载外部类。
     * 秉承用到谁加载谁的原则
     */
    static class StaticInnerClass{
        static {
            System.out.println("StaticInnerClass");
        }

        public static void main(String[] args) {
            System.out.println("inner");
        }
    }
}
