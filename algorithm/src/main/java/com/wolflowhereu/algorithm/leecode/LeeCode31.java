package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode31 {
    /**
     * https://leetcode.com/problems/next-permutation/
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i = nums.length - 2;

        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            i--;
        }
        if (i >= 0) {
            int ii = nums.length - 1;
            while (ii > i) {
                if (nums[ii] > nums[i]) break;
                ii--;
            }
            int tmp = nums[i];
            nums[i] = nums[ii];
            nums[ii] = tmp;
        }

        int c = (i + nums.length + 1) / 2;

        for (int j = 1; j + i < c; j++) {
            int ii = nums.length - j;
            int tmp = nums[i + j];
            nums[i + j] = nums[ii];
            nums[ii] = tmp;
        }

    }

}
