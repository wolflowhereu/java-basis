package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode46 {
    /**
     * https://leetcode.com/problems/permutations/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int count = factorial(nums.length);

        do {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            result.add(list);
            new LeeCode31().nextPermutation(nums);
        } while (--count > 0);

        return result;
    }

    private int factorial(int n) {
        if (n <= 0) return 1;
        else return factorial(n - 1) * n;
    }
}
