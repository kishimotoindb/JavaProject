package com.example.algorithm.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by cuihaichen on 2020.07.07
 * <p>
 * 第三题：找到最大的无重复字符的子串
 */
public class _3FindNotDuplicateSubstring {
    public static void main(String[] args) {
        int count = new _3FindNotDuplicateSubstring().lengthOfLongestSubstring2("abba");
        System.out.println("count: " + count);
    }

    int count;

    public int lengthOfLongestSubstring1(String s) {
        HashSet<Character> used = new HashSet<>();
        int start, end, k;
        start = end = k = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (used.contains(tmp)) {
                if (k > end - start) {
                    start = i - k;
                    end = i;

                }
                used.clear();
                i = i - k;
                k = 0;
            } else {
                used.add(tmp);
                k++;
            }

        }
        if (k > 0 && k > end - start) {
            start = s.length() - k;
            end = s.length();
        }

        return end - start;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> used = new HashMap<>();
        int start, end, k;
        start = end = k = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (used.containsKey(tmp)) {
                // 遇到重复，计算重复之前的子串长度是否比原有最长的子串长
                if (k > end - start) {
                    start = i - k;
                    end = i;
                }
                int newStart = used.get(tmp) + 1;
                int originalStart = i - k;
                k = k - (newStart - originalStart) + 1;
                used.put(tmp, i);
                removeCharBeforeStart(used, newStart);
            } else {
                used.put(tmp, i);
                k++;
            }

        }
        if (k > 0 && k > end - start) {
            start = s.length() - k;
            end = s.length();
        }

        return end - start;
    }

    private void removeCharBeforeStart(HashMap<Character, Integer> used, int start) {
        Iterator<Character> itr = used.keySet().iterator();
        while (itr.hasNext()) {
            Character key = itr.next();
            if (used.get(key) < start) {
                itr.remove();
            }
        }
    }

    public int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> used = new HashMap<>();
        int max, k;
        max = k = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (used.containsKey(tmp)) {
                // 遇到重复，计算重复之前的子串长度是否比原有最长的子串长
                if (k > max) {
                    max = k;
                }
                int newStart = used.get(tmp) + 1;
                int originalStart = i - k;
                k = k - (newStart - originalStart) + 1;
                used.put(tmp, i);
                removeCharBeforeStart(used, newStart);
            } else {
                used.put(tmp, i);
                k++;
            }

        }
        if (k > 0 && k > max) {
            max = k;
        }

        return max;
    }

    public int lengthOfLongestSubstringRef(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}
