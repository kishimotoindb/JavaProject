package com.example.LeetCode;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by BigFaceBear on 2020.03.16
 */
public class No1TwoSum {

    public static void main(String[] args) {
        int[] nums=new int[]{2,2,10,3};
        int target = 4;
        getTarget(nums, target);
    }

    /*
     * Given an array of integers, return indices of the two numbers such that they
     * add up to a specific target.You may assume that each input would have exactly
     * one solution, and you may not use the same element twice.
     *
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    /*
     * 1.输入数组中可以有相同的值，比如[7,2,5,7]，target=4。
     *   nums有可能是相同值，比如target == 14;
     *   nums里有两个7;
     *   hashmap中m[7]的值为后一个7的位置；
     *   当第二个循环循环到第一个7时m.count会查找到第二个7，这时候会返回两个7分别的位置；
     *   所以nums本身重复不会有问题
     *
     * 2.不知道这个题可不可以有负数，如果有负数，还是使用hashmap，没有负数，可以直接使用数组
     *   映射nums，更节省内存
     *
     */
    static void getTarget(int[] nums, int target) {

//        用数组映射有个问题，原数组中有负数就没办法了
//        int[] mapArr = new int[target + 1];
//        for (int i = 0; i <= target; i++) {
//
//        }

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                result[0] = nums[i];
                result[1] = other;
                break;
            }
        }
        System.out.println("target " + target + "=" + result[0] + "+" + result[1]);
    }
}
