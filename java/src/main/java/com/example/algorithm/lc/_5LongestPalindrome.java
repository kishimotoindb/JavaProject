package com.example.algorithm.lc;

/**
 * Created by cuihaichen on 2020.07.24
 */
public class _5LongestPalindrome {

    /*
     * 回文串为：babadklflksaklfjlkajslkfjlkfkl
     * 中心扩散：36 次计算
     * 动态规划：496 次计算
     * 动态规划的执行时间还是比中心扩散多了不少
     */
    public static void main(String[] args) {
        System.out.println(new _5LongestPalindrome().longestPalindromic("babadklflksaklfjlkajslkfjlkfkla") + ", count " + countNo1);
        System.out.println(new _5LongestPalindrome().longestPalindromicDP("babadklflksaklfjlkajslkfjlkfkla") + ", count " + countNo2);
    }

    static int countNo1 = 0;

    public String longestPalindromic(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int count = expandAroundCenter(s, i, i);
            if (count > end - start) {
                int radius = (count - 1) / 2;
                start = i - radius;
                end = i + radius + 1;
            }
            count = expandAroundCenter(s, i, i + 1);
            if (count > end - start) {
                int radius = (count - 2) / 2;
                start = i - radius;
                end = i + radius + 2;
            }
        }
        return s.substring(start, end);
    }

    int expandAroundCenter(String s, int pLeft, int pRight) {
        while (pLeft >= 0 && pRight < s.length() && s.charAt(pLeft) == s.charAt(pRight)) {
            pLeft--;
            pRight++;
            countNo1++;
        }
        return pRight - pLeft - 1;
    }

    static int countNo2 = 0;

    public String longestPalindromicDP(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        boolean[][] state = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            state[i][i] = true;
        }
        countNo2 += s.length();
        int start = 0, end = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                state[i][j] = isPalindromic(s, i, j, state);
                countNo2++;
                if (state[i][j] && (j - i > end - start)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    boolean isPalindromic(String s, int start, int end, boolean[][] state) {
        return s.charAt(start) == s.charAt(end) && (start + 1 >= end - 1 || state[start + 1][end - 1]);
    }
}
