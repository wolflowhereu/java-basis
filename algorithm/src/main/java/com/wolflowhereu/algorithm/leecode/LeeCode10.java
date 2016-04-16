package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode10 {
    /**
     * https://leetcode.com/submissions/detail/56642134/
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (s.length() == 0) {
            if (p.length() > 1 && p.charAt(1) == '*') return isMatch(s, p.substring(2));
            return false;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) return true;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
        }

        return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));

    }
}
