package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * Created by BigFaceBear on 2020.03.04
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {3,4,2,1,5,6,7,8};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    // 《小灰的算法之旅》冒泡排序的优化，是有问题的，每次排序的结果与书里说的思想不一致。
    static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            int sortBorder = nums.length - 1;
            for (int j = 0; j < sortBorder; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    isSorted = false;
                    sortBorder = j;
                }
            }
            System.out.println(Arrays.toString(nums));
            if (isSorted) {
                break;
            }
        }
    }
}

/*
上面的优化是有问题的
[3, 2, 4, 1, 5, 6, 7, 8]
[2, 3, 4, 1, 5, 6, 7, 8]
[2, 3, 1, 4, 5, 6, 7, 8]
[2, 1, 3, 4, 5, 6, 7, 8]
[1, 2, 3, 4, 5, 6, 7, 8]
[1, 2, 3, 4, 5, 6, 7, 8]
1 2 3 4 5 6 7 8
 */
