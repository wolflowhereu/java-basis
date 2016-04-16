package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode26 {
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }

        }

        return count;
    }

}
