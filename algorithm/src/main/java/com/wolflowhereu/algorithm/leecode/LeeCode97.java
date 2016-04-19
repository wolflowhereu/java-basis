package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode97 {
    /**
     * https://leetcode.com/problems/interleaving-string/
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length()) return false;

        dp[0][0] = true;
        for (int i = 0; i < s1.length() && dp[i][0]; i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i);
        }
        for (int i = 0; i < s2.length() && dp[0][i]; i++) {
            dp[0][i + 1] = s2.charAt(i) == s3.charAt(i);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int k = i + j;
                if (s1.charAt(i - 1) == s3.charAt(k - 1)) dp[i][j] |= dp[i - 1][j];
                if (s2.charAt(j - 1) == s3.charAt(k - 1)) dp[i][j] |= dp[i][j - 1];
            }
        }
        return dp[s1.length()][s2.length()];
    }


    @Test
    public void test() {
        Assert.assertTrue(isInterleave("", "", ""));
        Assert.assertTrue(isInterleave("abc", "123", "abc123"));
        Assert.assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assert.assertFalse(isInterleave("aabcc", "dbbca", "aadbbbaccc"));


    }
}
