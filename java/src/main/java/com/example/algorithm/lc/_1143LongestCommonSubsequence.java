package com.example.algorithm.lc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuihaichen on 2020.07.26
 */
public class _1143LongestCommonSubsequence {
    public static void main(String[] args) {
        String string1 = "abcdefghiloilikjljlioluiolnlnigk";
        String string2 = "bceg";
        _1143LongestCommonSubsequence obj = new _1143LongestCommonSubsequence();
        System.out.println("count1: " + obj.longestCommonSubsequence(string1, string2));
        System.out.println("count2: " + obj.longestCommonSubsequence2(string1, string2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        List<String> subsequenceList = new LinkedList<>();
        String source = text1.length() < text2.length() ? text1 : text2;
        String target = text1.length() < text2.length() ? text2 : text1;
        generateSubsequenceList(source, "", -1, subsequenceList);
        String lcs = "";
        for (int i = 0; i < subsequenceList.size(); i++) {
            String candidate = subsequenceList.get(i);
            if (isSubsequence(target, candidate) && candidate.length() > lcs.length()) {
                lcs = candidate;
            }
        }
        return lcs.length();
    }

    void generateSubsequenceList(String source, String prev, int lastIndex, List<String> subsequenceList) {
        for (int i = lastIndex + 1; i < source.length(); i++) {
            String tmp = prev + source.charAt(i);
            generateSubsequenceList(source, tmp, i, subsequenceList);
            subsequenceList.add(tmp);
        }
    }

    boolean isSubsequence(String target, String subsequence) {
        int pointer = 0;
        for (int i = 0; i < subsequence.length(); i++) {
            char c = subsequence.charAt(i);
            boolean found = false;
            while (!found && pointer < target.length()) {
                if (target.charAt(pointer) == c) {
                    found = true;
                }
                pointer++;
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }


    /*
     * 自顶向下memo动态规划: 180ms
     *
     * 递归调用的时间损耗还是挺高的，自底向上瞬间时间就降到了十几毫秒
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return dynamicProgrammingTopDown(text1, text2, memo);
    }

    public int dynamicProgrammingTopDown(String text1, String text2, int[][] memo) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        if (memo[text1.length() - 1][text2.length() - 1] != -1) {
            return memo[text1.length() - 1][text2.length() - 1];
        }
        int count = 0;
        if (text1.charAt(text1.length() - 1) == text2.charAt(text2.length() - 1)) {
            count = 1 + dynamicProgrammingTopDown(text1.substring(0, text1.length() - 1), text2.substring(0, text2.length() - 1), memo);

        } else {
            count = Math.max(dynamicProgrammingTopDown(text1.substring(0, text1.length() - 1), text2, memo),
                    dynamicProgrammingTopDown(text1, text2.substring(0, text2.length() - 1), memo));
        }
        memo[text1.length() - 1][text2.length() - 1] = count;
        return count;
    }

    /*
     * 自底向上动态规划 15ms
     */
    public int longestCommonSubsequence3(String txt1, String txt2) {
        if (txt1.length() == 0 || txt2.length() == 0) {
            return 0;
        }
        int[][] memo = new int[txt1.length()][txt2.length()];

        for (int i = 0; i < txt1.length(); i++) {
            for (int j = 0; j < txt2.length(); j++) {
                memo[i][j] = getLongestCommonSubsequence(txt1, i, txt2, j, memo);
            }
        }
        return memo[txt1.length() - 1][txt2.length() - 1];
    }

    private int getLongestCommonSubsequence(String txt1, int i, String txt2, int j, int[][] memo) {
        if (txt1.charAt(i) == txt2.charAt(j)) {
            return 1 + (i - 1 < 0 || j - 1 < 0 ? 0 : memo[i - 1][j - 1]);
        } else {
            int count1 = i - 1 < 0 ? 0 : memo[i - 1][j];
            int count2 = j - 1 < 0 ? 0 : memo[i][j - 1];
            return Math.max(count1, count2);
        }
    }

    /*
     * 自底向上动态规划 8ms
     *
     * 将txt1和txt2存储为char[]数组之后，运行时间相比直接使用string.charAt()提升了一倍
     */
    public int longestCommonSubsequence4(String txt1, String txt2) {
        if (txt1.length() == 0 || txt2.length() == 0) {
            return 0;
        }
        int[][] memo = new int[txt1.length()][txt2.length()];
        char[] txt1Arr = txt1.toCharArray();
        char[] txt2Arr = txt2.toCharArray();

        for (int i = 0; i < txt1.length(); i++) {
            for (int j = 0; j < txt2.length(); j++) {
                memo[i][j] = getLongestCommonSubsequence(txt1Arr, i, txt2Arr, j, memo);
            }
        }
        return memo[txt1.length() - 1][txt2.length() - 1];
    }

    private int getLongestCommonSubsequence(char[] txt1, int i, char[] txt2, int j, int[][] memo) {
        if (txt1[i] == txt2[j]) {
            return 1 + (i - 1 < 0 || j - 1 < 0 ? 0 : memo[i - 1][j - 1]);
        } else {
            int count1 = i - 1 < 0 ? 0 : memo[i - 1][j];
            int count2 = j - 1 < 0 ? 0 : memo[i][j - 1];
            return Math.max(count1, count2);
        }
    }
}





















































