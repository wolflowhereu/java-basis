package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fan on 16-5-5.
 */
public class LeeCode132 {

    /**
     * https://leetcode.com/problems/palindrome-partitioning-ii/
     * @param s
     * @return
     */
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] dpMinCut = new int[s.length() + 1];


        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            dpMinCut[i + 1] = i + 1;
        }

        for (int end = 0; end < dp.length; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 1 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    dpMinCut[end + 1] = Math.min(dpMinCut[end + 1], dpMinCut[start] + 1);
                }
            }
        }

        return dpMinCut[s.length()] - 1;
    }


    @Test
    public void test() {
        Assert.assertEquals(3, minCut("ababbbabbaba"));
        Assert.assertEquals(1, minCut("ababb"));
    }
}
