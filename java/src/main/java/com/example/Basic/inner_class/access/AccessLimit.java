package com.example.Basic.inner_class.access;

public class AccessLimit {

    public static void main(String[] args) {
        NonStaticInner nonStaticInner = new AccessLimit().new NonStaticInner();
        nonStaticInner.privateField = 1;

        StaticInner staticInner = new StaticInner();
        staticInner.privateField = 1;

    }

    class NonStaticInner {
        // private对包裹类无效
        private int privateField;
        protected int protectField;
    }

    static class StaticInner {
        // private对包裹类无效
        private int privateField;
        protected int protectField;
    }
}
