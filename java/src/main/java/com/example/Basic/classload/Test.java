package com.example.Basic.classload;

public class Test {
    public static void main(String[] args) {
        /*
         * 加载静态内部类，如果没有使用外部类，同样不会加载外部类
         */
        new Outer.StaticInnerClass();
    }
}
