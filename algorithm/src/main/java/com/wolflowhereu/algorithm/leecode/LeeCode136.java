package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode136 {
    /**
     * https://leetcode.com/problems/single-number/
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
