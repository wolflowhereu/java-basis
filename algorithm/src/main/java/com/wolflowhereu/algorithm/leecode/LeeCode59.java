package com.wolflowhereu.algorithm.leecode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode59 {

    /**
     * https://leetcode.com/problems/spiral-matrix-ii/
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, direct = 0, k = 1, x = 0, y = 0;
        int total = n * n;
        while (k <= total) {
            matrix[y][x] = k++;
            switch (direct) {
                case 0: {
                    if (x == right) {
                        direct++;
                        y++;
                        top++;
                    } else x++;
                    break;
                }
                case 1: {
                    if (y == bottom) {
                        direct++;
                        x--;
                        right--;
                    } else y++;
                    break;
                }
                case 2: {
                    if (x == left) {
                        direct++;
                        y--;
                        bottom--;
                    } else x--;
                    break;
                }
                case 3: {
                    if (y == top) {
                        direct = 0;
                        x++;
                        left++;
                    } else y--;
                    break;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Stream.of(generateMatrix(8)).forEach(ints -> {
            Stream.of(ints).forEach(ints1 -> System.out.print(Arrays.toString(ints1)));
            System.out.println();
        });
    }

}
