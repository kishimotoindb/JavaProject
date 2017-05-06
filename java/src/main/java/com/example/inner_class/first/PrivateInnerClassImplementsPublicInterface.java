package com.example.inner_class.first;

/**
 * Created by cuihaichen on 17-5-4.
 */

public class PrivateInnerClassImplementsPublicInterface {
    private class PrivateClass implements BaseInterface {
        @Override
        public String to(String s) {
            return "to";
        }

        public String to2() {
            return "to2";
        }
    }

    public BaseInterface getBaseInterface() {
        return new PrivateClass();
    }
}
