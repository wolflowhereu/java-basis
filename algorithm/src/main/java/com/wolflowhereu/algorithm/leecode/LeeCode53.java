package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-29.
 * @Discreption
 */
public class LeeCode53 {

    /**
     * https://leetcode.com/problems/maximum-subarray/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) return 0;
        int max = nums[0], pre = 0;

        for (int num : nums) {
            int now = pre + num;
            max = now > max ? now : max;
            pre = now > 0 ? now : 0;
        }

        return max;
    }
}
