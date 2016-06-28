package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 16-5-5.
 */
public class LeeCode131 {
    List<List<String>> result = new ArrayList<>();

    /**
     * https://leetcode.com/problems/palindrome-partitioning/
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }

        for (int length = 1; length < dp.length; length++) {
            for (int i = 0; i + length < dp.length; i++) {
                if (s.charAt(i) == s.charAt(i + length))
                    dp[i][i + length] = dp[i + 1][i + length - 1];
            }
        }
        partition(s, dp, 0, new ArrayList<>());

        return result;
    }


    private void partition(String s, boolean[][] dp, int start, List<String> partitionList) {

        if (start >= s.length()) {
            result.add(partitionList);
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                String partition = s.substring(start, end + 1);
                List<String> partitions = new ArrayList<>(partitionList);
                partitions.add(partition);
                partition(s, dp, end + 1, partitions);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(partition(""));
    }
}
