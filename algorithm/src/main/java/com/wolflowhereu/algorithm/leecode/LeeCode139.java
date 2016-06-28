package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode139 {

    /**
     * https://leetcode.com/problems/word-break/
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String word : wordDict) {
            if (word.length() > max) max = word.length();
            if (word.length() < min) min = word.length();
        }


        for (int end = min; end <= s.length(); end++) {
            for (int start = end - min; start >= 0 && start + max >= end; start--) {
                if (dp[start] && wordDict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    @Test
    public void test() {
        HashSet<String> objects = new HashSet<>();
        objects.add("leet");
        objects.add("code");
        System.out.println(wordBreak("leetcode", objects));
    }
}
