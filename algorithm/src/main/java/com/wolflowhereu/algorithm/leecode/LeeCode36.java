package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode36 {
    /**
     * https://leetcode.com/problems/valid-sudoku/
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length <= 0 || board[0].length <= 0) return false;
        final int[] map = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};

        for (int i = 0; i < board.length; i++) {
            int mark1 = 0, mark2 = 0, mark3 = 0;
            for (int j = 0; j < board.length; j++) {
                mark1 = calc(board, i, j, map, mark1);
                mark2 = calc(board, j, i, map, mark2);
                mark3 = calc(board, (i / 3 * 3) + (j / 3), ((i % 3) * 3) + j % 3, map, mark3);
                if (mark1 < 0 || mark2 < 0 || mark3 < 0) return false;
            }
        }
        return true;
    }


    public static int calc(char[][] board, int x, int y, int[] map, int mark) {
        if (board[x][y] != '.') {
            int num = board[x][y] - '1';
            if ((mark & map[num]) > 0) return -1;
            return mark | map[num];
        }
        return mark;
    }



}
