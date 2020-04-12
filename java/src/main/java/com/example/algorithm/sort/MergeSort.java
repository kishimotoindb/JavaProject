package com.example.algorithm.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntUnaryOperator;

/**
 * Created by cuihaichen on 17-6-27.
 * 归并排序
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
        // 1.合并两个已经排好序的数组
//        int[] result = mergeTwoSortedArr(a, b);
//        System.out.println(Arrays.toString(result));

        // 2.自底向上归并排序
        mergeBU();
    }

    /*
     * 合并两个已经排好序的数组（最简单的版本，空间复杂度最高）
     */

    static int[] mergeTwoSortedArr(int[] a, int[] b) {
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


    /*
     * 自底向上的归并排序
     */
    private static void mergeBU() {
        int[] src = new int[r.nextInt(20)];
        Arrays.setAll(src, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return r.nextInt(100);
            }
        });
        System.out.println("src: " + Arrays.toString(src));

        mergeBUImpl2(src);

    }

    static int[] mergeBUImpl1(int[] src) {
        int[] aux = new int[src.length];
        // 计算当前元素生成的二叉树的深度，即需要进行的归并轮数
        int depth = (int) Math.ceil(Math.log(src.length) / Math.log(2));

        for (int i = depth; i > 0; i--) {

            // 计算本轮归并的子数组长度
            int childArrLen = (int) Math.pow(2, depth - i);

            // 每轮循环对两个子数组进行归并操作。如果某一轮归并只有一个子数组，那么就不需要进行归并
            // 操作
            for (int j = 0; j < src.length; j += 2 * childArrLen) {
                if (j + childArrLen >= src.length) {
                    continue;
                }
                merge(src, aux, j, j + 2 * childArrLen);
            }

            System.out.println("seq " + i + ": " + Arrays.toString(src));
        }
        return src;
    }

    static void merge(int[] src, int[] aux, int lo, int high) {
        // 确定第二个子数组的起始索引
        int p2Start = (int) ((lo + high) / 2 + 0.5f);
        high = Math.min(src.length, high);
        System.arraycopy(src, lo, aux, lo, high - lo);

        int p1 = lo;
        int p2 = p2Start;
        for (int i = lo; i < high; i++) {
            if (p1 >= p2Start) {
                src[i] = aux[p2++];
            } else if (p2 >= high) {
                src[i] = aux[p1++];
            } else if (aux[p1] <= aux[p2]) {
                src[i] = aux[p1++];
            } else {
                src[i] = aux[p2++];
            }
        }
    }

    static int[] mergeBUImpl2(int[] src) {
        int[] aux = new int[src.length];
        int N = src.length;
        for (int sz = 1; sz < N; sz += sz) {

            // 每轮循环对两个子数组进行归并操作。如果内循环某一轮归并只有一个子数组（一个子
            // 数组的元素都凑不齐），那么这一轮内循环就不需要进行归并操作
            // j<N-sz与Impl1里面的j<N && j+sz>=N->continue是一致的
            for (int lo = 0; lo < N - sz; lo += 2 * sz) {
                merge2(src, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }

            System.out.println("child width " + sz + ": " + Arrays.toString(src));
        }
        return src;
    }

    static void merge2(int[] src, int[] aux, int lo, int mid, int high) {
        int p1 = lo;
        int p2 = mid + 1;

        System.arraycopy(src, lo, aux, lo, high - lo + 1);

        for (int i = lo; i <= high; i++) {
            if (p1 > mid)                   src[i] = aux[p2++];
            else if (p2 > high)             src[i] = aux[p1++];
            else if (less(aux[p1],aux[p2])) src[i] = aux[p1++];
            else                            src[i] = aux[p2++];

        }
    }

    private static boolean less(int l, int r) {
        return l < r;
    }
}


