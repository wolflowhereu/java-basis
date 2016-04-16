package com.wolflowhereu.algorithm.leecode;

import java.util.Arrays;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode40 {
    /**
     * https://leetcode.com/problems/combination-sum-ii/
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return LeeCode39.combinationSum(candidates, target, candidates.length - 1, 1);
    }
}
