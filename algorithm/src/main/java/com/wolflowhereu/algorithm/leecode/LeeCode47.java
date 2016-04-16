package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode47 {
    /**
     * https://leetcode.com/problems/permutations-ii/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        while (true) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            if (result.size() > 0) {
                boolean isEnd = true;
                for (int i = 0; i < result.get(0).size(); i++) {
                    if (result.get(0).get(i) != list.get(i)) {
                        isEnd = false;
                        break;
                    }
                }
                if (isEnd) break;
            }
            result.add(list);
            new LeeCode31().nextPermutation(nums);
        }
        return result;
    }
}
