package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode137 {
    /**
     * https://leetcode.com/problems/single-number-ii/
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        for (; i < nums.length; i+=3) {
            if (nums[i]!=nums[i-1]) break;
        }
        return nums[i - 1];
    }


    @Test
    public void test() {

    }
}
