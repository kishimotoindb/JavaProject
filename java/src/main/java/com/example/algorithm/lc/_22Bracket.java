package com.example.algorithm.lc;

import java.util.ArrayList;
import java.util.List;

public class _22Bracket {
    public static void main(String[] args) {
        _22Bracket bracket = new _22Bracket();
        bracket.gen(3);
    }

    List<String> ret = new ArrayList<>();

    private void gen(int count) {
        backtrace("", count, count);
        System.out.println(ret);
    }

    void backtrace(String combination, int lBracket, int rBracket) {
        if (lBracket == 0 && rBracket == 0) {
            ret.add(combination);
        }

        if (lBracket > 0) {
            backtrace(combination + "(", lBracket - 1, rBracket);
        }
        if (lBracket != rBracket) {
            backtrace(combination + ")", lBracket, rBracket-1);
        }
    }
}
