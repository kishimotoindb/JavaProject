package com.example.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by BigFaceBear on 2020.05.18
 */
public class _17PhoneNumber {

    HashMap<Character, Character[]> map = new HashMap<>();
    int[][] pointerAndLimit;

    void init(String digits) {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        pointerAndLimit = new int[digits.length()][2];
        for (int i = 0; i < digits.length(); i++) {
            pointerAndLimit[i][1] = map.get(digits.charAt(i)).length;
        }
    }

    public static void main(String[] args) {
        String digits = "2321";
        _17PhoneNumber instance = new _17PhoneNumber();
        instance.letterCombinations(digits);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList();
        }

        init(digits);
        HashSet<String> strs = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        boolean loop = true;
        while (loop) {
            sb.delete(0, sb.length());

            boolean carry = false;
            for (int j = 0; j < digits.length(); j++) {
                Character[] characters = map.get(digits.charAt(j));
                int pointer = pointerAndLimit[j][0];
                int limit = pointerAndLimit[j][1];
                sb.append(characters[pointer]);

                if (j == 0) {
                    if (pointer + 1 == limit) {
                        if (j == digits.length() - 1) {
                            loop = false;
                        } else {
                            pointerAndLimit[j][0] = 0;
                            carry = true;
                        }
                    } else {
                        pointerAndLimit[j][0] = pointer + 1;
                    }
                } else if (carry) {
                    if (pointer + 1 == limit) {
                        if (j == digits.length() - 1) {
                            loop = false;
                        } else {
                            pointerAndLimit[j][0] = 0;
                            carry = true;
                        }
                    } else {
                        pointerAndLimit[j][0] = pointer + 1;
                        carry = false;
                    }
                }
            }
            strs.add(sb.toString());
        }
        return new ArrayList<>(strs);
    }

    HashMap<String, String> map2 = new HashMap();

    public List<String> letterCombinations2(String digits) {

        map2.put("2", "abc");
        map2.put("3", "def");
        map2.put("4", "ghi");
        map2.put("5", "jkl");
        map2.put("6", "mno");
        map2.put("7", "pqrs");
        map2.put("8", "tuv");
        map2.put("9", "wxyz");

       return concateStr(digits);
    }

    public List<String> concateStr(String digits) {
        List<String> ret = new ArrayList<>();
        if (!digits.isEmpty()) {
            String strs = map2.get(digits.charAt(0) + "");
            List<String> subStrs = concateStr(digits.substring(1));
            for (int i = 0; i < strs.length(); i++) {
                String letter = strs.substring(i, i + 1);
                if (subStrs.isEmpty()) {
                    ret.add(letter);
                }else{
                    for (int j = 0; j < subStrs.size(); j++) {
                        ret.add(letter + subStrs.get(j));
                    }
                }
            }
        }
        return ret;


    }

}
