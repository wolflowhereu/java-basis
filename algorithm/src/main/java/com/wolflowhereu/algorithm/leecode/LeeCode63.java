package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode63 {
    /**
     * https://leetcode.com/problems/unique-paths-ii/
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid[0].length < 1 ||
                obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] map = new int[m];
        map[0] = 1;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) map[0] = 0;
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) map[j] = 0;
                else map[j] += map[j - 1];
            }
        }
        return map[m - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}, {0}}));
    }
}
