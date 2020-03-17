package com.example.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cuihaichen on 2020.03.17
 */
public class SubList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        // 可以用来删除多余的元素
        list.subList(3, list.size()).clear();
        System.out.println(list.toString());
    }
}
