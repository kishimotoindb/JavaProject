package com.example.algorithm.lc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by BigFaceBear on 2020.06.22
 */
public class SlidingWindow {

    public static void main(String[] args) {
        int[] ret = new SlidingWindow().maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5);
        System.out.println(Arrays.toString(ret));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return new int[0];
        } else if (n <= k) {
            int max = nums[0];
            for (int i = 1; i < k; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return new int[]{max};
        }


        int[] result = new int[n - k + 1];
        LinkedList<Integer> seq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            updateSeq(seq, nums, i, k);
            if (i >= k - 1) {
                result[i - k + 1] = seq.peek();
            }
        }
        return result;
    }

    void updateSeq(LinkedList<Integer> seq, int[] nums, int newElemIndex, int k) {
        Integer max;
        if (newElemIndex >= k) {
            int head = nums[newElemIndex - k];
            max = seq.peek();
            if (head == max) {
                seq.poll();
            }
        }


        max = seq.peek();
        int elem = nums[newElemIndex];
        if (max == null) {
            seq.offer(elem);
        } else if (elem > max) {
            seq.clear();
            seq.offer(elem);
        } else {
            ListIterator<Integer> itr = seq.listIterator(seq.size());
            while (itr.hasPrevious()) {
                Integer prev = itr.previous();
                if (prev < elem) {
                    itr.remove();
                } else {
                    seq.offer(elem);
                    break;
                }
            }
        }
    }
}
