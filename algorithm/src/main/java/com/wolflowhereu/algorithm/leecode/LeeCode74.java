package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode74 {

    /**
     * https://leetcode.com/problems/search-a-2d-matrix/
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length<=0 || matrix[0].length <=0) return false;
        int start = 0, end = matrix.length - 1, row = 0, column = 0;
        while (start < end) {
            row = (start + end + 1) / 2;
            if (matrix[row][0] > target) end = row - 1;
            else start = row;
        }
        row = start;
        start = 0;
        end = matrix[row].length - 1;

        while (start < end) {
            column = (start + end + 1) / 2;
            if (matrix[row][column] == target) return true;
            if (matrix[row][column] > target) end = column - 1;
            else start = column;
        }
        column = start;
        return matrix[row][column] == target;
    }


    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{{1},{2}}, 1));
    }
}
