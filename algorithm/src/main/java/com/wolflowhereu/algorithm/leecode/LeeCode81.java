package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode81 {

    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (nums[middle] == target) return true;
            if (nums[end] > nums[middle]) {
                if (target > nums[middle] && target <= nums[end]) start = middle + 1;
                else end = middle - 1;
            } else if (nums[start] < nums[middle]) {
                if (target >= nums[start] && target < nums[middle]) end = middle - 1;
                else start = middle + 1;
            } else if (nums[start++] == target || nums[end--] == target) return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1}, 2));
    }


}
