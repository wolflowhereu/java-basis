package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode115 {
    /**
     * https://leetcode.com/problems/distinct-subsequences/
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }


    @Test
    public void test() {
        Assert.assertEquals(numDistinct("a", "a"), 1);
        Assert.assertEquals(numDistinct("ccc", "c"), 3);
        Assert.assertEquals(numDistinct("rabbbit", "rabbit"), 3);
    }
}
