package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode66 {

    /**
     * https://leetcode.com/problems/plus-one/
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int plus = 1, i = digits.length - 1;
        while (plus > 0 && i >= 0) {
            digits[i] += plus;
            plus = digits[i] / 10;
            digits[i] %= 10;
            i--;
        }
        if (plus > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
