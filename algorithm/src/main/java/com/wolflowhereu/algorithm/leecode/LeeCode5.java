package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode5 {
    /**
     * https://leetcode.com/submissions/detail/55571431/
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        int[] iLen = new int[s.length() * 2 + 1];
        int C = 0, R = 0;
        for (int center = 1; center < s.length() * 2 + 1; center++) {
            int mirror = 2 * C - R;
            iLen[center] = R > center ? Math.min(iLen[mirror], R - center) : 0;
            while (getCharCustomize(center - 1 - iLen[center], s) == getCharCustomize(center + 1 + iLen[center], s))
                iLen[center]++;
            if (center + iLen[center] > R) {
                C = center;
                R = center + iLen[center];
            }
        }

        int max = 0, center = 0;
        for (int i = 0; i < iLen.length; i++) {
            if (iLen[i] > max) {
                max = iLen[i];
                center = i;
            }
        }

        return s.substring((center - max) / 2, (center + max + 1) / 2);
    }

    private char getCharCustomize(int index, String s) {
        if (index < 0) return '^';
        if (index > s.length() * 2) return '$';
        if (index % 2 == 1) return s.charAt(index / 2);
        return '#';
    }
}
