package com.example.initialize;

/**
 * Created by BigFaceBear on 2018.04.26
 */

public class FinalKeywordClass {
    final String fs;

    public FinalKeywordClass(int i) {
        if (i < 0) {
            fs = "负数";
        } else {
            fs = "整数";
        }

    }
}
