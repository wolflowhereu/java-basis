package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-29.
 * @Discreption
 */
public class LeeCode54 {

    /**
     * https://leetcode.com/problems/spiral-matrix/
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix.length==0 || matrix[0].length==0) return result;
        int left = 0, right = matrix[0].length - 1, buttom = matrix.length - 1, top = 0;

        int direct = 0, x = 0, y = 0, total = matrix.length * matrix[0].length;

        while (result.size() < total) {
            result.add(matrix[y][x]);

            switch (direct) {
                case 0: {
                    if (x != right) {
                        x++;
                        break;
                    }
                    direct++;
                    top++;
                }
                case 1: {
                    if (y != buttom) {
                        y++;
                        break;
                    }
                    direct++;
                    right--;
                }
                case 2: {
                    if (x != left) {
                        x--;
                        break;
                    }
                    direct++;
                    buttom--;
                }
                case 3: {
                    if (y != top) {
                        y--;
                        break;
                    }
                    direct = 0;
                    left++;
                    x++;
                }
            }
        }
        return result;
    }
}
