package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fan on 16-7-1.
 */
public class LeeCode153_154 {

    /**
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1;

        while (start < end && nums[start] >= nums[end]) {
            int middle = (start + end) >> 1;
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else if (nums[middle] < nums[start]) {  // 153
                end = middle;
            } else {
                start++;
                end--;
            }
        }
        return nums[start];
    }
}
