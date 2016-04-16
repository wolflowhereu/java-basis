package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode64 {
    /**
     * https://leetcode.com/problems/minimum-path-sum/
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length <= 0 || grid[0].length <= 0) return 0;

        for (int i = 1; i < grid[0].length; i++) grid[0][i] += grid[0][i - 1];

        for (int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i - 1][0];
            for (int j = 1; j < grid[0].length; j++) grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
