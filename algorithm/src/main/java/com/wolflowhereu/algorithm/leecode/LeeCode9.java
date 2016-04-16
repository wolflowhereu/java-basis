package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode9 {
    /**
     * https://leetcode.com/problems/palindrome-number/
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int k = 0, t = x;
        while (x > 0) {
            k *= 10;
            k += x % 10;
            x /= 10;
        }
        if (k == t) return true;
        return false;
    }

}
