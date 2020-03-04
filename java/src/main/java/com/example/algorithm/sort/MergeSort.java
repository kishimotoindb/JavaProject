package com.example.algorithm.sort;

import java.util.Random;

/**
 * Created by cuihaichen on 17-6-27.
 * 合并排序
 */

public class MergeSort {
    static int[] a = new int[20];
    static int[] b = new int[20];
    static Random r = new Random(System.currentTimeMillis());

    static {
        for (int i = 0; i < 20; i++) {
            a[i] = r.nextInt(1000);
            b[i] = r.nextInt(1000);
        }

        int tmp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] > b[j]) {
                    tmp = b[i];
                    b[i] = b[j];
                    b[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] result = MergeSortAlgorithm.sort(a, b);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}

class MergeSortAlgorithm {
    public static int[] sort(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (p1 >= a.length) {
                result[i] = b[p2++];
            } else if (p2 >= b.length) {
                result[i] = a[p1++];
            } else if (a[p1] <= b[p2]) {
                result[i] = a[p1++];
            } else {
                result[i] = b[p2++];
            }
        }
        return result;
    }
}


