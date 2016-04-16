package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode72 {

    /**
     * https://leetcode.com/problems/edit-distance/
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() <= 0) return word2.length();
        if (word2.length() <= 0) return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        if (word1.charAt(0) != word2.charAt(0)) dp[0][0] = 1;
        for (int i = 0; i < dp.length; i++) dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = i;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        return dp[word1.length()][word2.length()];
    }

    @Test
    public void test() {
        System.out.println(minDistance("spartan", "part"));
    }
}
