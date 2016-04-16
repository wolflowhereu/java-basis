package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode80 {

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length<=2) return nums.length;
        int length = 1;

        for (int i = length; i < nums.length; i++) {
            if (nums[i] != nums[length - 1]) {
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }
}
