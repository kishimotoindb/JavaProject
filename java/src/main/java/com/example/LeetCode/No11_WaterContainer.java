package com.example.LeetCode;

import java.util.Random;

/*
 * 盛最多水的容器
 */
public class No11_WaterContainer {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(500);
        }
        solution1(arr);
        solution2(arr);
    }

    // 从头到尾遍历
    static void solution1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            System.out.println("solution1: container no volume");
            return;
        }

        long max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int left = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int right = arr[j];
                int wide = j - i;
                long volume = wide * Math.min(left, right);
                //System.out.println("solution1: left " + left + " right " + right + " wide " + wide +
                //      " volume " + volume);
                if (volume > max) {
                    max = volume;
                }
            }
        }

        System.out.println("solution1: max volume " + max);
    }

    /*
     * 两层循环：
     * 外层用来计算容积，内层用来确定指针移动
     */
    static void solution2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            System.out.println("solution2: container no volume");
            return;
        }

        long max = 0;
        int pLeft = 0;
        int pRight = arr.length - 1;
        while (pLeft < pRight) {
            int leftWall = arr[pLeft];
            int rightWall = arr[pRight];
            long tmpVolume = Math.min(leftWall, rightWall) * (pRight - pLeft);
            if (tmpVolume > max) {
                max = tmpVolume;
            }

            // 收缩指针
            if (leftWall < rightWall) {
                do {
                    pLeft++;
                } while (pLeft < pRight && arr[pLeft] <= leftWall);
            } else if (leftWall > rightWall) {
                do {
                    pRight--;
                } while (pRight > pLeft && arr[pRight] <= rightWall);
            } else {
                do {
                    pLeft++;
                } while (pLeft < pRight && arr[pLeft] <= leftWall);

                if (pRight > pLeft) {
                    do {
                        pRight--;
                    } while (pRight > pLeft && arr[pRight] <= rightWall);
                }
            }
        }

        System.out.println("solution2: max volume " + max);
    }


}
