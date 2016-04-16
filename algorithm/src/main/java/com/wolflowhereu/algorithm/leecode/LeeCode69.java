package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode69 {

    /**
     * https://leetcode.com/problems/sqrtx/
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int start = 0, end = x/2 + 1;
        while (start < end) {
            int middle = (start + end + 1) / 2;
            long result = ((long) middle) * middle;
            if (result == x) return middle;
            if (result > x) end = middle - 1;
            else start = middle;
        }
        return start;
    }


    @Test
    public void test() {
        int n = 2147483647;
        while ((int) Math.sqrt(n) == mySqrt(n)) {
            System.out.println(n);
            n++;
        }
        System.out.println(n);
    }
}
