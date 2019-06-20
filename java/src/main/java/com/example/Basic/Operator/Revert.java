package com.example.Basic.Operator;

/**
 * Created by BigFaceBear on 2018.12.05
 */

public class Revert {
    public static void main(String[] args) {
        System.out.println(-1 + "");
        /*
         * 0b 00000000 00000000 00000000 00000000
         * 0b 11111111 11111111 11111111 11111111
         * 0b 10000000 00000000 00000000 00000001
         *
         */
        int i = -1;
        int j = 0;
        int k = i + j;
        System.out.println(k+"");

    }
}
