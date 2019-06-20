package com.example.Basic.inner_class.interface_inner_class;

/**
 * Created by cuihaichen on 17-5-5.
 */

public interface InterfaceInnerClass {
    void interfaceMethod();

    class InnerClass implements InterfaceInnerClass {
        @Override
        public void interfaceMethod() {
            System.out.println("interfaceMethod");
        }

        public static void staticMethod() {
            new InnerClass().interfaceMethod();
        }
    }
}

class InnerClass   {

    private void interfaceMethod() {
        System.out.println("interfaceMethod");
    }

    //静态方法因为还是在InnerClass内，所以可以调用private的interfaceMethod()方法
    public static void staticMethod() {
        new InnerClass().interfaceMethod();
    }
}