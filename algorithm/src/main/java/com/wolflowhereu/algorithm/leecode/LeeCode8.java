package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode8 {
    /**
     * https://leetcode.com/problems/string-to-integer-atoi/
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() <= 0) return 0;
        long result = 0;
        str = str.trim();
        boolean ne = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= '9' && c >= '0') {
                result *= 10;
                result += c - '0';
            } else if (c == '-' && i == 0) {
                ne = true;
            } else if (c == '+' && i == 0) {
                continue;
            } else break;

            if (result > Integer.MAX_VALUE) return ne ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (ne) result *= -1;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;

    }
}
