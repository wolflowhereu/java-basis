package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode3 {
    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * problem3
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int max = 0;
        int now = 0;
        for (int i = 0; i < s.length(); i++) {
            int nowIndex = s.charAt(i) - 0;
            int lastIndex = map[nowIndex];
            int length = i - lastIndex;
            if (now > length) {
                now = i - lastIndex + 1;
            } else {
                now++;
                if (now > max) {
                    max = now;
                }
            }
            map[nowIndex] = i + 1;
        }
        return max;
    }

}
