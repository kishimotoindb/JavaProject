package com.example.algorithm.lc;

/**
 * Created by cuihaichen on 2020.07.27
 */
public class _longestCommonSubstring {

    /*
     * dp(i,j)= j adjacent i && dp(i,j-1)
     */
    int longestCommonSubstring(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] source = (text1.length() < text2.length() ? text1 : text2).toCharArray();
        char[] target = (text1.length() < text2.length() ? text2 : text1).toCharArray();
        boolean[][] memo = new boolean[source.length][source.length];
        int longest=0;
        for (int charCount = 1; charCount <= source.length; charCount++) {
            for (int startIndex = 0; startIndex < source.length; startIndex++) {

            }
        }


    }
}
