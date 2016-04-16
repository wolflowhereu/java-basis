package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode39 {
    /**
     *
     * https://leetcode.com/problems/combination-sum/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, candidates.length - 1, 0);
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target, int maxIndex, int offset) {
        List<List<Integer>> result = new ArrayList<>();
        if (maxIndex < 0 || candidates[0] > target) return result;
        for (int i = maxIndex; i >= 0; i--) {
            if (offset == 1 && i != maxIndex && i < candidates.length - 1 && candidates[i] == candidates[i + 1])
                continue;
            if (candidates[i] == target) {
                List<Integer> combinations = new ArrayList<>();
                combinations.add(candidates[i]);
                result.add(combinations);
            } else if (candidates[i] < target) {
                List<List<Integer>> tmp = combinationSum(candidates, target - candidates[i], i - offset, offset);
                if (tmp != null && tmp.size() > 0) {
                    for (List<Integer> list : tmp) {
                        list.add(candidates[i]);
                    }
                    result.addAll(tmp);
                }
            }
        }
        return result;
    }

}
