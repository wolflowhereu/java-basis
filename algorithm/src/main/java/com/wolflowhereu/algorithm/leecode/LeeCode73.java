package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode73 {

    /**
     * https://leetcode.com/problems/set-matrix-zeroes/
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length<=0 || matrix[0].length<=0) return;
        boolean isFirstRow0 = false, isFirstColumn0 = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumn0 = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isFirstRow0 = true;
                break;
            }
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isFirstColumn0) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        if (isFirstRow0) for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;

    }
}
