package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-29.
 * @Discreption
 */
public class LeeCode55 {

    /**
     * https://leetcode.com/problems/jump-game/
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int fastSize = nums[0], index = 0;
        while (index <= fastSize) {
            if (nums[index]+index > fastSize) {
                fastSize = index + nums[index];
            }
            if (fastSize >= nums.length - 1) return true;

            index++;
        }
        if (fastSize >= nums.length - 1) return true;
        return false;
    }
}
