package com.example;

public class MyClass {
    static char a;

    public static void main(String[] args) {
//        System.out.println("char a is" + a + ".");  //char默认是 /u0000 空字符
        new A();
    }
}

/*
 *  子父类的初始化顺序;
 *  c static created
 *  WithInnerA static code block
    WithInnerB static code block

    //父类的所有初始化均发生在B之前
    c created   //A中的成员变量
    WithInnerA code block
    WithInnerA constructor

    d created   //B中的成员变量
    WithInnerB code block
    WithInnerB constructor

    类加载顺序：
    1.静态成员变量
    2.静态代码块
    3.成员变量
    4.代码块
    5.构造方法
* */
class A {
    protected int a = 1;
    static C c = new C(1);

    static {
        c = new C(2);
        System.out.println("WithInnerA static code block");
    }

    {
        System.out.println("WithInnerA code block");
    }

    public A() {
        System.out.println("WithInnerA constructor");
    }

}

class  B extends A {
    int b = a;
    D d = new D();

    static {
        System.out.println("WithInnerB static code block");
    }

    {
        System.out.println("WithInnerB code block");
    }

    public B() {
        super();
        System.out.println("WithInnerB constructor");
    }

}

class C {
    {
        System.out.println("c created");
    }

    public C(int i) {
        System.out.println("C" + i);
    }
}

class D {
    {
        System.out.println("d created");
    }
}
