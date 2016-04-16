package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode33 {
    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }


    public int search(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int middle = (start + end) / 2;
        if (nums[middle] == target) return middle;

        if (nums[start] <= nums[middle]) {
            if (target >= nums[start] && target < nums[middle])
                return search(nums, start, middle - 1, target);
            else return search(nums, middle + 1, end, target);
        } else {
            if (target > nums[middle] && target <= nums[end])
                return search(nums, middle + 1, end, target);
            else return search(nums, start, middle - 1, target);
        }
    }
}
