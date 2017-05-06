package com.example.e23;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by cuihaichen on 17-5-5.
 */

public class B {
    U[] us = new U[5];
    int count = 0;

    void setU(U u) {
        if (count >= 5) return;
        us[count++] = u;
    }

    void setNull(int i) {
        if (i < 0 || i >= count) return;
        us[count] = null;
    }

    void callUs() {
        for (int i = 0; i < us.length; i++) {
            if (us[i] != null) {
                us[i].method1();
                us[i].method2();
                us[i].method3();
            }
        }
    }

    class inner {
    }

    public static void main(String[] args) {
        A[] as = new A[5];
        for (int i = 0; i < 5; i++) as[i] = new A();
        B b = new B();
        for (int i = 0; i < 5; i++) {
            b.setU(as[i].getU());
        }
    }
}
