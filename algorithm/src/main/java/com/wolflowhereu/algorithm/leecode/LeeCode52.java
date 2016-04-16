package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode52 {
    static int count = 0;


    /**
     * https://leetcode.com/problems/n-queens-ii/
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        dfs(0, 0, 0, 0, n);
        return count;
    }

    public void dfs(int step, long left, long right, long line, int n) {
        if (step >= n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            long k = (1 << i);
            if (((left | right | line) & k) <= 0) {
                dfs(step + 1, (left | k) >> 1, (right | k) << 1, line | k, n);
            }
        }
    }

}
