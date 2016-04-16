package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode29 {
    /**
     * https://leetcode.com/problems/divide-two-integers/
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        long tmp1 = Math.abs((long) dividend);
        long tmp2 = Math.abs((long) divisor);

        if (tmp1 < tmp2) return 0;

        if (divisor == 0) return -1;

        long result = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;


        while (tmp1 > tmp2) {
            tmp2 <<= 1;
            result <<= 1;
        }

        if (tmp1 < tmp2) {
            tmp2 >>= 1;
            result >>= 1;
        }

        if (dividend < 0) tmp2 = -tmp2;
        result += divide(dividend - (int) tmp2, divisor);
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }
}
