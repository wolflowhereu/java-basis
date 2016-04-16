package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode62 {
    /**
     * https://leetcode.com/problems/unique-paths/
     * 1 10 55
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) return 0;
        int[] map = new int[m];
        map[0] = 1;
        while (n-- > 0) {
            for (int i = 1; i < m; i++) {
                map[i] += map[i - 1];
            }
        }
        return map[m - 1];
    }


    @Test
    public void test() {
        System.out.println(uniquePaths(5, 10));
    }
}
