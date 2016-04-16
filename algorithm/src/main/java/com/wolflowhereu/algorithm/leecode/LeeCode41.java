package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode41 {

    /**
     * https://leetcode.com/problems/first-missing-positive/
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) flags[nums[i] - 1] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) return i + 1;
        }
        return nums.length + 1;
    }
}
