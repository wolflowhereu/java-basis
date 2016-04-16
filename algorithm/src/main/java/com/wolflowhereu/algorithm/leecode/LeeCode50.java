package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode50 {
    /**
     * https://leetcode.com/problems/powx-n/
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n == -1) return 1 / x;

        if (n < 0) {
            if (n % 2 == 0) return 1 / myPow(x * x, -(n / 2));
            return 1 / (x * myPow(x * x, -(n / 2)));
        }

        if (n % 2 == 0) return myPow(x * x, n / 2);
        return x * myPow(x * x, n / 2);
    }

}
