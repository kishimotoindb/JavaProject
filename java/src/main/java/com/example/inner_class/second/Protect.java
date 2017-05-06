package com.example.inner_class.second;

//import com.example.inner_class.first.CanAccessInnerClassPrivateMember;

/**
 * Created by cuihaichen on 17-5-4.
 */

public class Protect{
    void to2() {
//        Inner inner = new Inner();    //protected class Inner在这里是不可见的。
//        inner.i = 1;
        class InnerMethod{

        }
    }

    class InnerMethod{

    }
}
