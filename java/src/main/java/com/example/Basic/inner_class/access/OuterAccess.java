package com.example.Basic.inner_class.access;

public class OuterAccess {
    public static void main(String[] args) {
        AccessLimit.StaticInner staticInner = new AccessLimit.StaticInner();

        // field private: field不可见 staticInner.privateField=1;

        // Protected可见
        staticInner.protectField=1;
    }
}
