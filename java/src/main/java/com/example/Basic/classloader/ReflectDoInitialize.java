package com.example.Basic.classloader;

import java.lang.reflect.Method;

/**
 * Created by cuihaichen on 2020.08.25
 */
class ReflectDoInitialize {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = ClassLoader.getSystemClassLoader().loadClass("com.example.Basic.classloader.ClassDoInitialize");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("forName complete");

        try {
            Method nonStaticMethod = clazz.getDeclaredMethod("nonStaticMethod");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("getMethod complete");


    }
}
