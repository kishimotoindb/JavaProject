package com.example.Basic.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by haichen.cui on 2017.08.28
 */

public class IteratorNext {
    static List<String> list = new ArrayList<>();

    static {
        list.add("1");
        list.add("2");
        list.add("3");
    }

    public static void main(String[] args) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("2")) {
                iterator.remove();
            } else {
                System.out.println(next);
            }
        }

        //输出： 1 3
    }
}
