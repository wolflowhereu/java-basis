package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode32 {
    /**
     * https://leetcode.com/problems/longest-valid-parentheses/
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int max = 0, leftI = -1, stackIndex = -1;

        int[] stack = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack[++stackIndex] = leftI;
                leftI = i;
            } else {
                if (stackIndex >= 0) {
                    leftI = stack[stackIndex--];
                    int size = i - leftI;
                    if (size > max) max = size;
                } else leftI = i;
            }
        }

        return max;
    }


}
