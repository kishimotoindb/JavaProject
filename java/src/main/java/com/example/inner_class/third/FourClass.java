package com.example.inner_class.third;

import com.example.inner_class.first.BaseInterface;
import com.example.inner_class.first.PrivateInnerClassImplementsPublicInterface;
import com.example.inner_class.second.Second;

/**
 * Created by cuihaichen on 17-5-4.
 */

public class FourClass {
    public static void main(String[] args) {
        BaseInterface third = new ThirdClass().third();
        PrivateInnerClassImplementsPublicInterface instance = new PrivateInnerClassImplementsPublicInterface();
        BaseInterface baseInterface = instance.getBaseInterface();
        new AnonymousInnerClass("") {
            {

            }

        };
    }

    static class AnonymousInnerClass {
        AnonymousInnerClass(String a) {
        }
    }

    interface A {
        void a();
        static void b() {

        }

        class Test implements A {
            @Override
            public void a() {

            }

            public static void main(String[] a) {
                new Test();
            }
        };
    }


}
