package com.example.algorithm.tt;

/**
 * Created by cuihaichen on 2020.06.30
 */
public class No253 {

    int[][] conditions = new int[][]{
            {-1, 0, 2, 0, 0, 0, 4, 0, 5},
            {0, -1, 0, 0, 0, 0, 0, 5, 0},
            {2, 0, -1, 0, 0, 0, 5, 0, 6},
            {0, 0, 0, -1, 0, 5, 0, 0, 0},
            {0, 0, 0, 0, -1, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, -1, 0, 0, 0},
            {4, 0, 5, 0, 0, 0, -1, 0, 8},
            {0, 5, 0, 0, 0, 0, 0, -1, 0},
            {5, 0, 6, 0, 0, 0, 8, 0, -1}
    };

    int totalCount = 0;

    public static void main(String[] args) {
        new No253().numberOfPatterns(1,4);
    }

    public int numberOfPatterns(int m, int n) {
        concat("", m, n);
        return totalCount;
    }

    void concat(String prev, int m, int n) {
        if (prev.length() >= n) return;

        String nextList = getNextList(prev);
        System.out.println("prev=" + prev + ", nextList=" + nextList);
        String curr;
        for (int i = 0; i < nextList.length(); i++) {
            char next = nextList.charAt(i);
            curr = prev + next;
            if (curr.length() >= m) {
                totalCount++;
                System.out.println(curr);
            }
            concat(curr, m, n);
        }
    }

    String getNextList(String prev) {
        if (prev.isEmpty()) return "123456789";

        StringBuilder sb = new StringBuilder();
        char last = prev.charAt(prev.length() - 1);
        int[] condition = conditions[last - '1'];
        for (int i = 0; i < 9; i++) {
            int num = i + 1;
            if(prev.contains(num+"")) continue;

            int precondition = condition[i];
            if (precondition == 0 && !prev.contains(num + "")) {
                sb.append(num + "");
            } else if (precondition > 0 && prev.contains(precondition + "")) {
                sb.append(num + "");
            }
        }
        return sb.toString();
    }
}
