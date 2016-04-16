package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode28 {
    /**
     * https://leetcode.com/problems/implement-strstr/
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() <= 0) return 0;
        int[] kmp = new int[needle.length()];

        for (int i = 1, k = 0; i < needle.length(); i++) {
            while (k > 0 && needle.charAt(i) != needle.charAt(k)) k = kmp[k - 1];
            if (needle.charAt(k) == needle.charAt(i)) k++;
            kmp[i] = k;
        }

        for (int i = 0, k = 0; i < haystack.length(); i++) {

            while (k > 0 && haystack.charAt(i) != needle.charAt(k)) k = kmp[k - 1];
            if (haystack.charAt(i) == needle.charAt(k)) k++;
            if (k >= needle.length()) return i - k + 1;

        }

        return -1;
    }

}
