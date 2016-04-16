package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode85 {

    /**
     * https://leetcode.com/problems/maximal-rectangle/
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length <= 0 || matrix[0].length <= 0) return 0;
        int maxRectangle = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') dp[i + 1][j] = dp[i][j] + 1;
            }
        }

        for (int i = 1; i <= matrix.length; i++) {
            int area = new LeeCode84().largestRectangleArea(dp[i]);
            if (area > maxRectangle) maxRectangle = area;
        }
        return maxRectangle;
    }

    @Test
    public void test() {
        System.out.println(maximalRectangle(new char[][]{{'1', '1'}, {'1', '1'}, {'1', '1'}}));
    }


}
