package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode13 {
    /**
     * https://leetcode.com/problems/roman-to-integer/
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int result = 0, back = getRomanValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int now = getRomanValue(s.charAt(i));
            result += back >= now ? back : -back;
            back = now;
        }
        result += back;
        return result;
    }

    private int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
