package com.example.algorithm.basis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihaichen on 2020.07.03
 */
public class Substring {



    public static void main(String[] args) {
        String source="the";
        new Substring().generate(source);
    }

    private static void generate(String source) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            ArrayList<String> sub = new ArrayList<>();
            result.add(sub);
            for (int j = 0; j < source.length(); j++) {
                sub.add(source.substring(i, j+1));
            }
        }
        System.out.println(result);
    }
}
