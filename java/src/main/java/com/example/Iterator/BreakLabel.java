package com.example.Iterator;

/**
 * Created by BigFaceBear on 2018.10.18
 */

public class BreakLabel {
    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {

            retry:
            while (i == 2) {
                continue retry;
            }

            System.out.println("i=" + i);
        }
    }
}
