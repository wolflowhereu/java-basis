package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode35 {
    /**
     * https://leetcode.com/problems/search-insert-position/
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int index = LeeCode34.searchMin(nums, 0, nums.length - 1, target);
        if (nums[index] < target) index++;
        return index;
    }
}
