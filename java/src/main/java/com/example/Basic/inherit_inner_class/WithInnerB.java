package com.example.Basic.inherit_inner_class;

/**
 * Created by cuihaichen on 17-5-5.
 * Exercise 26
 */

public class WithInnerB {
    class InnerB extends WithInnerA.InnerA {
        //因为wia已经是创建完成的WithInnerA对象，这里的构造方法不需要构造WithInnerA对象，
        //所以这里指增加了InnerA的构造参数。
        InnerB(WithInnerA wia, int i) {
            wia.super(i);
        }
    }
}
