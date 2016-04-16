package com.wolflowhereu.algorithm.leecode;

import java.util.Arrays;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode16 {
    /**
     * https://leetcode.com/problems/3sum-closest/
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int tmp = nums[i] + nums[start] + nums[end];
                if (tmp == target) {
                    return target;
                }

                result = Math.abs(result - target) < Math.abs(tmp - target) ? result : tmp;
                if (tmp > target) end--;
                else start++;
            }

        }
        return result;
    }

}
