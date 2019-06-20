package com.example.Basic.inner_class.second;

import com.example.Basic.inner_class.first.BaseInterface;

/**
 * Created by cuihaichen on 17-5-4.
 */

public class Second {
    protected class SecondInterface implements BaseInterface{
        @Override
        public String to(String s) {
            return null;
        }

        public void to2() {
        }
    }

    protected SecondInterface getSecondInterface() {
        return new SecondInterface();
    }
}
