package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode48 {
    /**
     * https://leetcode.com/problems/rotate-image/
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        symmetryX(matrix);
    }

    /**
     * 转置
     *
     * @param matrix
     */
    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    /**
     * 对称交换
     *
     * @param matrix
     */
    private void symmetryX(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int symmetryX = matrix.length - j - 1;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][symmetryX];
                matrix[i][symmetryX] = tmp;
            }
        }
    }

}
