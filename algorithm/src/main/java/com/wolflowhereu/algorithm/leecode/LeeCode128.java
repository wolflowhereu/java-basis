package com.wolflowhereu.algorithm.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fan on 16-5-4.
 */
public class LeeCode128 {
    /**
     * https://leetcode.com/problems/longest-consecutive-sequence/
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            Integer num = nums[i] + 1;
            while (numSet.remove(num)) {
                count++;
                if (Integer.MAX_VALUE == num) break;
                num++;
            }
            num = nums[i] - 1;
            while (numSet.remove(num)) {
                count++;
                if (Integer.MIN_VALUE == num) break;
                num--;
            }
            if (count>max) max = count;
        }
        return max;
    }
}
