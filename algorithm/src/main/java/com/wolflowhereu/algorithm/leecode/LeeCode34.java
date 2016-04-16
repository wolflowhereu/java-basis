package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode34 {
    /**
     * https://leetcode.com/problems/search-for-a-range/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int index = searchMin(nums, 0, nums.length - 1, target);
        if (nums[index] == target) {
            result[0] = index;
            index = searchMin(nums, index, nums.length - 1, target + 1);
            if (nums[index] != target) index--;
            result[1] = index;
        }
        return result;
    }

    public static int searchMin(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (start >= end) return middle;

        if (target > nums[middle]) {
            return searchMin(nums, middle + 1, end, target);
        } else {
            return searchMin(nums, start, middle, target);
        }
    }
}
