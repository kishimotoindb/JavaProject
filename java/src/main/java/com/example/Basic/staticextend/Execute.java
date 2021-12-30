package com.example.Basic.staticextend;

/**
 * @author cuihaichen on 12/30/21
 */
public class Execute {
  public static void main(String[] args) {

    System.out.println("执行父类的main方法: ");
    Parent.main(null);

    System.out.println("执行子类的main方法: ");
    Child.main(null);

    System.out.println("直接执行父类的nonstatic方法: ");
    new Parent().nonstatic();

    System.out.println("直接执行子类的nonstatic方法: ");
    new Child().nonstatic();

    System.out.println("通过父类执行子类的nonstatic方法: ");
    ((Parent)new Child()).nonstatic();

    /*
        执行输出结果：
        执行父类的main方法:
        parent main
        执行子类的main方法:
        child main
        直接执行父类的nonstatic方法:
        parent nonstatic
        直接执行子类的nonstatic方法:
        child nonstatic
        通过父类执行子类的nonstatic方法:
        child nonstatic

        结论：
        1.子类会继承父类所有内容。比如Child没有静态方法main，但是继承Parent后，Child.main()是能够调用的
        2.静态的内容只是不支持多态，非静态支持多态
     */
  }
}
