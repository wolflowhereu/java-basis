package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode77 {
    List<List<Integer>> combines = new ArrayList<>();


    /**
     * https://leetcode.com/problems/combinations/
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return combines;
        dfs(1, n, k, new ArrayList<>());
        return combines;
    }


    public void dfs(int start, int n, int k, List<Integer> combine) {
        if (start + k - 1 > n) return;
        if (k == 0) {
            List<Integer> result = new ArrayList<>();
            result.addAll(combine);
            combines.add(result);
            return;
        }
        for (int i = start; i <= n; i++) {
            combine.add(i);
            dfs(i + 1, n, k - 1, combine);
            combine.remove(new Integer(i));
        }
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }
}
