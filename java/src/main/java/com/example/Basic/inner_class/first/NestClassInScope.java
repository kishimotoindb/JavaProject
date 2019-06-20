package com.example.Basic.inner_class.first;

/**
 * Created by cuihaichen on 17-5-4.
 */

public class NestClassInScope {
    void to() {
        if (true) {
            class InnerMethod implements BaseInterface {
                @Override
                public String to(String s) {
                    return null;
                }
            }

        }
    }
}
