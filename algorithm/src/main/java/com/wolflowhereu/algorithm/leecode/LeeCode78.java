package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode78 {

    /**
     * https://leetcode.com/problems/subsets/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        Arrays.sort(nums);
        int maxBitNum = 1 << nums.length;
        int bitNum = 1;
        while (bitNum < maxBitNum) {
            int bit = 1, index = 0;

            List<Integer> sets = new ArrayList<>();
            result.add(sets);
            while (bit <= bitNum) {
                if ((bit & bitNum) > 0) sets.add(nums[index]);
                bit <<= 1;
                index++;
            }
            bitNum++;

        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }
}
