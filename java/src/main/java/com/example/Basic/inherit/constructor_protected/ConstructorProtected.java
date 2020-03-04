package com.example.Basic.inherit.constructor_protected;

import com.example.Basic.inherit.constructor_protected1.Child;
import com.example.Basic.inherit.constructor_protected1.Father;

/**
 * Created by BigFaceBear on 2019.08.27
 */
public class ConstructorProtected {
    private static final String TAG = "ConstructorProtected";

    public static void main(String[] args) {
        Child child = new Child();
        new Father(){};
        new Father(1) {
        };
        // 匿名内部类会自动
    }
}
