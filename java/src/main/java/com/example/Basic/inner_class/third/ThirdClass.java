package com.example.Basic.inner_class.third;

import com.example.Basic.inner_class.second.Second;

/**
 * Created by cuihaichen on 17-5-4.
 */

public class ThirdClass extends Second {
    SecondInterface third() {
        System.out.println("method third in the ThirdClass");
        return getSecondInterface();
    }
}
