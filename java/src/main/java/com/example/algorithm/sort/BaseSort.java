package com.example.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by BigFaceBear on 2020.03.04
 */
public class BaseSort {

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("source: " + Arrays.toString(nums));
        // bubbleSortOptimized(nums);
        //bubbleSortOptimizedWrong(nums);
        //cocktailSort(nums);
        //cocktailSortOptimized(nums);
        //insertionSortOptimized(nums);
        selectionSort(nums);
        System.out.println("result: " + Arrays.toString(nums));

    }

    /*
     * 冒泡排序优化版本，《小灰的算法之旅》中的实现
     *
     * 这个是有问题的，每次排序的结果与书里说的思想不一致。下面的
     * 算法每一轮排序后的输出如下：
     * [3, 2, 4, 1, 5, 6, 7, 8]
     * [2, 3, 4, 1, 5, 6, 7, 8]
     * [2, 3, 1, 4, 5, 6, 7, 8]
     * [2, 1, 3, 4, 5, 6, 7, 8]
     * [1, 2, 3, 4, 5, 6, 7, 8]
     * [1, 2, 3, 4, 5, 6, 7, 8]
     * 1 2 3 4 5 6 7 8
     */
    static void bubbleSortOptimized1(int[] nums) {
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

    /*
     * 冒泡排序优化版本
     *
     * 这个才是正确的优化实现，每一轮循环之后更新一次边界。
     *
     */
    static void bubbleSortOptimized(int[] nums) {

        boolean hasSwap = true;
        int border = nums.length - 1;

        for (int i = 0; i < nums.length - 1 && hasSwap; i++) {
            hasSwap = false;
            int tmpBorder = border;
            for (int j = 0; j < border; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    hasSwap = true;
                    tmpBorder = j;
                }
            }
            border = tmpBorder;
            System.out.println(Arrays.toString(nums));
        }
    }

    /*
     * 冒泡排序优化版本（错误版本）
     *
     * 每一轮循环更新左右两个边界
     *
     * 注：这个版本其实是有问题的，因为冒泡排序并不能在每一轮循环之后判断出左边界。冒泡只有可能
     * 判断出右边界。（如果是把大的元素右移）
     *
     * int[] nums = {1, 2, 3, 8, 11, 7, 9, 20, 21, 22}; （排不出正确的结果）
     * int[] nums = {1, 2, 3, 11, 8, 9, 7, 20, 21, 22}; （能排出正确的结果）
     *
     * 使用上面两个数组就可以验证左边界是无法确定的。因为每一轮循环过后，只有数组的右边是保证有序并且
     * 不会在有序的部分中插入新的元素，数组的左边是保证不了这个条件的，所以只通过第一次发生交换确定左
     * 边界是不合理的，比如上面的第一个数组，第一次发生交换是11和9，所以确定出的左边界index=4，但是
     * 到下一轮循环的时候，其实是需要从index=3，即元素8开始排的（8和7交换），但是因为上一轮将左边界
     * 定义为了4，所以8直接被忽略了。
     *
     * 错误的本质原因：
     * 数组左侧虽然有可能有序，但是不保证有序的元素位置不发生变化，可能右移。
     *
     * source: [1, 2, 3, 8, 11, 9, 7, 20, 21, 22]
     * circle: [1, 2, 3, 8, 9, 7, 11, 20, 21, 22], new start 4 new end 5
     * circle: [1, 2, 3, 8, 7, 9, 11, 20, 21, 22], new start 4 new end 4
     * circle: [1, 2, 3, 8, 7, 9, 11, 20, 21, 22], new start -1 new end 4
     * result: [1, 2, 3, 8, 7, 9, 11, 20, 21, 22]
     */
    static void bubbleSortOptimizedWrong(int[] nums) {

        boolean hasSwap = true;
        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i < nums.length - 1 && hasSwap; i++) {
            hasSwap = false;
            int tmpStart = -1;
            int tmpEnd = end;
            for (int j = start; j < end; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;

                    hasSwap = true;
                    tmpEnd = j;
                    if (tmpStart == -1) {
                        tmpStart = j;
                    }
                }
            }
            start = tmpStart;
            end = tmpEnd;
            System.out.println("circle: " + Arrays.toString(nums) + ", new start " + start
                    + " new end " + end);
        }
    }

    /*
     * 鸡尾酒排序
     */
    static void cocktailSort(int[] nums) {
        boolean hasChange = true;
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            int circle = i / 2;
            if (i % 2 == 0) {
                for (int j = circle; j < nums.length - 1 - circle; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                        hasChange = true;
                    }
                }
            } else {
                for (int j = nums.length - 2 - circle; j >= circle + 1; j--) {
                    if (nums[j] < nums[j - 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = tmp;
                        hasChange = true;
                    }
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    /*
     * 鸡尾酒排序
     *
     * 每轮循环后更新下一轮循环的左右边界
     * start表示本轮循环需要排序的第一个元素，end表示最后一个需要排序的元素：
     *
     * 1 2 3 9 4 5 7 20 21 22: start=3(elem=9) end=6(elem=7)
     */
    static void cocktailSortOptimized(int[] nums) {
        boolean hasChange = true;
        int leftBorder = 0;
        int rightBorder = nums.length - 2;
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            if (i % 2 == 0) {
                int tmpRight = nums.length - 1 - i / 2;
                for (int j = leftBorder; j <= rightBorder; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                        hasChange = true;
                        tmpRight = j;
                    }
                }
                rightBorder = tmpRight;
            } else {
                int tmpLeft = i / 2 + 1;
                for (int j = rightBorder; j > leftBorder; j--) {
                    if (nums[j - 1] > nums[j]) {
                        int tmp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = tmp;
                        hasChange = true;
                        tmpLeft = j;
                    }
                }
                leftBorder = tmpLeft;
            }

            System.out.println("circle " + i + ": " + Arrays.toString(nums)
                    + " nextLeft " + leftBorder + " nextRight " + rightBorder);
        }
    }

    /*
     * 插入排序
     */
    static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && (nums[j] < nums[j - 1]); j--) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }
    }

    /*
     * 插入排序优化
     *
     * 减少数组元素的交换次数
     */
    static void insertionSortOptimized(int[] nums) {
        for (int i = 1, j; i < nums.length; i++) {
            int current = nums[i];
            for (j = i - 1; j >= 0 && (current < nums[j]); j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = current;
        }
    }

    /*
     * 选择排序
     */
    static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            if (min != i) {
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
            System.out.println("circle " + i + ": " + Arrays.toString(nums));
        }
    }
}


