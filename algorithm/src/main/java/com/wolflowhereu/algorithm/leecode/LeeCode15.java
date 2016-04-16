package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode15 {
    /**
     * https://leetcode.com/problems/3sum/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return threeSum(nums, 0);
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int tmp = nums[start] + nums[end] - target;
                if (tmp == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    do {
                        start++;
                    } while (start < end && nums[start - 1] == nums[start]);

                    do {
                        end--;
                    } while (start < end && nums[end + 1] == nums[end]);
                } else if (tmp > -nums[i]) {
                    do {
                        end--;
                    } while (start < end && nums[end + 1] == nums[end]);
                } else do {
                    start++;
                } while (start < end && nums[start - 1] == nums[start]);
            }

        }

        return result;
    }
}
