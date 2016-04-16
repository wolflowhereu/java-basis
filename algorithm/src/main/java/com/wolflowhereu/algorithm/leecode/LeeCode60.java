package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode60 {
    /**
     * https://leetcode.com/problems/permutation-sequence/
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {

        int[] factorial = {
                1, 2, 6, 24, 120, 720, 5040, 40320, 362880
        };

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = i + 1;
        }

        int factorialNum = factorial[n-1];

        while (n > 0 && k > 0) {
            factorialNum /= n;
            int index = (k - 1) / factorialNum;
            int nNum = seq[index];
            while (index < n - 1) {
                seq[index] = seq[index + 1];
                index++;
            }
            seq[index] = nNum;
            k %= factorialNum;
            n--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = seq.length - 1; i >= 0; i--) {
            sb.append(seq[i]);
        }

        return sb.toString();
    }


    private int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return factorial(n - 1) * n;
    }

    @Test
    public void test() {
        int f = factorial(5);
        for (int i = 0; i < f; i++) {
            System.out.println(getPermutation(5, i + 1));
        }
    }
}
