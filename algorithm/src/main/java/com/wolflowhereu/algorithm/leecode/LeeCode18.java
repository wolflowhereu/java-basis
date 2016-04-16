package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode18 {
    /**
     * https://leetcode.com/problems/4sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> threeResult = LeeCode15.threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
            for (List<Integer> list : threeResult) {
                list.add(0, nums[i]);
                result.add(list);
            }
        }

        return result;
    }
}
