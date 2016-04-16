package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-4-6.
 * @Discreption
 */
public class LeeCode90 {
    List<List<Integer>> result = new ArrayList<>();

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.add(Collections.emptyList());
        subsetsWithDup(nums, new ArrayList<>(), 0);
        return result;
    }

    private void subsetsWithDup(int[] nums, List<Integer> list, int k) {
        if (k > nums.length) return;

        for (int i = k; i < nums.length; i++) {
            if (i > k && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            List<Integer> sets = new ArrayList<>();
            sets.addAll(list);
            result.add(sets);
            subsetsWithDup(nums, list, i + 1);
            list.remove(new Integer(nums[i]));
        }
    }

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
