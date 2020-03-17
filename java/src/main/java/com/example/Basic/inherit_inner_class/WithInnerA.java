package com.example.Basic.inherit_inner_class;

/**
 * Created by cuihaichen on 17-5-5.
 */

public class WithInnerA {
    public WithInnerA(String s) {
        new InnerA(1).mF = 1;
        new InnerB().mF = 1;
    }

    public class InnerA {
        /*
         * 内部类的访问限制符只对其他类起作用，对自己的外部类不起作用。即内部类的访问限制符是用来
         * 限制外人的，对自己的包裹类是透明的
         */
        private int mF;

        public InnerA(int i) {
        }
    }

    private static class InnerB{
        private int mF;
    }
}
