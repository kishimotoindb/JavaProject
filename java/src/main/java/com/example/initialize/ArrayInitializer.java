package com.example.initialize;

import java.util.Arrays;

/**
 * Created by cuihaichen on 17-4-14.
 */

public class ArrayInitializer {
    public static void main(String[] args) {
        /*ArrayContent[] array = new ArrayContent[5];
        int i = 0;
        for (int i1 = 0; i1 < array.length; i1++) {
            array[i1] = new ArrayContent(i1 + "");
        }
        Arrays.toString(array);*/

//        printArrayArgument(null);
//        printArrayArgument(new String[]{"1","2"});
//
//        printVariableArgumentLists();
//        printVariableArgumentLists(new String[]{"1","2"});
    }

    static void printArrayArgument(String[] strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    static void printVariableArgumentLists(String... strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class ArrayContent {
    String s;

    ArrayContent(String s) {
        this.s = s;
//        System.out.println(s);
    }

    @Override
    public String toString() {
        return s;
    }
}
