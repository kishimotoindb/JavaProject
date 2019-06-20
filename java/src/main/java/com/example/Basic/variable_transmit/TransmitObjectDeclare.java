package com.example.Basic.variable_transmit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigFaceBear on 2019.05.26
 */
public class TransmitObjectDeclare {
    public static void main(String[] args) {
        TransmitObjectDeclare t = new TransmitObjectDeclare();
        List list = null;
        t.initialize(list);
        System.out.println("main list size " + (list != null ? list.size() : "null"));
        // 运行结果
        // initialize list size 1
        // main list size null

    }

    // 因为main方法中的list在传进来之前，并没有初始化分配地址，所以其实在调用的时候传进来的是null。
    // 也就是initialize方法中对list初始化，这个list并不能传回给main中的list。C语言的指针貌似不是
    // 这个逻辑，binder_open方法中给方法传的就是一个没有初始化的指针，但是后面又用了。
    void initialize(List list) {
        list = new ArrayList();
        list.add(new Object());
        System.out.println("initialize list size " + list.size());
    }
}
