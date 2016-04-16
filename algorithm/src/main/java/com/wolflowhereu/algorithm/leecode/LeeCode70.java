package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode70 {

    /**
     * https://leetcode.com/problems/climbing-stairs/
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int n1 = 1, n2 = 1, result = 1;
        while (n-- > 1) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }


    @Test
    public void test() {
        System.out.println(climbStairs(10));
    }
}
