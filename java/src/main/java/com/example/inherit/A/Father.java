package com.example.inherit.A;

import com.example.inherit.B.Child;

/**
 * Created by cuihaichen on 17-6-2.
 */
/*
 *
 */
public abstract class Father<T extends FatherHolder> {
    protected void get(T t) {
    }

    protected abstract void set(T t);
}
