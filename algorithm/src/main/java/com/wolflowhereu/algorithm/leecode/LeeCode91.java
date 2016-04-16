package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-4-6.
 * @Discreption
 */
public class LeeCode91 {

    /**
     * https://leetcode.com/problems/decode-ways/
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() <= 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        switch (s.charAt(0)) {
            case '1':
            case '2':
                return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            default:
                return numDecodings(s.substring(1));
        }
    }

    @Test
    public void test() {
        System.out.println(numDecodings("11"));
        System.out.println(numDecodings("1"));
        System.out.println(numDecodings("111"));
        System.out.println(numDecodings("261"));
        System.out.println(numDecodings("271"));
        System.out.println(numDecodings("9"));
        System.out.println(numDecodings("101"));
    }
}
