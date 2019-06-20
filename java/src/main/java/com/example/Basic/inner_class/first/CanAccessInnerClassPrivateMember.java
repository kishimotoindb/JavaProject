package com.example.Basic.inner_class.first;

/*
 * Determine whether an outer class has access to the private elements of
 * its inner class?
 * 1.对内部类定义所使用的修饰符，对外部类本身是没有任何意义的，其表示的仅仅是其他类进入内部类的权限。
 *   对于外部类来说，内部类不论采用什么修饰符，其均是可进入的。
 * 2.对内部类成员和方法所使用的修饰符，对外部类本身同样是没有任何意义的，其表示的也仅仅是其他类进入内
 *   部类成员或方法的权限。对于外部类来说，内部类成员或方法不论采用什么修饰符，其均是可进入的。
 * 3.当内部类为private时，对内部类成员使用修饰符其实是没有意义的，因为其他类根本看不见这个内部类，
 *   而外部类又可以随意进入内部类的成员。
 * 4.
 */

public class CanAccessInnerClassPrivateMember {

    void to() {
        Inner inner = new Inner();
        inner.i = 1;
    }

    protected class Inner {
         int i;
    }
}

