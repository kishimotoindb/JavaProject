package com.example.Basic.variable_length_args;

/**
 * Created by BigFaceBear on 2019.08.06
 */
public class VariableArgs {
    public static void main(String[] args) {
        // 参数中有null的情况
        // print(null);            // null pointer
        print(null, null);      // ok
        print("0", null, "1");  // ok
        print(null,"1");        // ok
    }

    static void print(String... p) {
        for (int i = 0; i < p.length; i++) {
            String s = p[i];
            System.out.println(s);
        }

    }
}
