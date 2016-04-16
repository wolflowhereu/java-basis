package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fan on 16-4-16.
 */
public class LeeCode96 {

    /**
     * https://leetcode.com/problems/unique-binary-search-trees/
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - j - 1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }


    @Test
    public void test() {
        Assert.assertEquals(numTrees(0), 0);
        Assert.assertEquals(numTrees(1), 1);
        Assert.assertEquals(numTrees(2), 2);
    }

}
