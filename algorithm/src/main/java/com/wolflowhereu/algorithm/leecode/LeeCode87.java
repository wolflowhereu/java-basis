package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jx09.
 * @Date 16-4-5.
 * @Discreption
 */
public class LeeCode87 {

    /**
     * https://leetcode.com/problems/scramble-string/
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 1) return s1.equals(s2);
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (!Arrays.equals(chars1, chars2)) return false;
        for (int i = 1; i < s1.length(); i++) {
            if ((isScramble1(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble1(s1.substring(i), s2.substring(i))) ||
                    (isScramble1(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                            isScramble1(s1.substring(i), s2.substring(0, s2.length() - i)))) return true;
        }
        return false;
    }


    /**
     * https://leetcode.com/problems/scramble-string/
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int length = s1.length();
        boolean dp[][][] = new boolean[length][length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = length - i - 1; j >= 0; j--) {
                for (int k = length - i - 1; k >= 0; k--) {
                    dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }

        return false;
    }


    @Test
    public void test() {
        System.out.println(isScramble1("xstjzkfpkggnhjzkpfjoguxvkbuopi", "xbouipkvxugojfpkzjhnggkpfkzjts"));
    }
}
