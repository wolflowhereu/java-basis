package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode75 {
    /**
     * https://leetcode.com/problems/sort-colors/
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums.length <= 0) return;
        int color = 0, start = 0, end = nums.length - 1;
        while (color <= end) {
            switch (nums[color]) {
                case 0: {
                    nums[color] = nums[start];
                    nums[start] = 0;
                    start++;
                    color++;
                    break;
                }
                case 2: {
                    nums[color] = nums[end];
                    nums[end] = 2;
                    end--;
                    break;
                }
                default:
                    color++;

            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 1, 0, 1, 1, 2, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));


    }
}
