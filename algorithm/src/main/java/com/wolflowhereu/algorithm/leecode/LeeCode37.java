package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode37 {
    /**
     * https://leetcode.com/problems/sudoku-solver/
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        final int[] map = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};
        int[][] marks = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            int mark1 = 0, mark2 = 0, mark3 = 0;
            for (int j = 0; j < board.length; j++) {
                mark1 = LeeCode36.calc(board, i, j, map, mark1);
                mark2 = LeeCode36.calc(board, j, i, map, mark2);
                int x = (i / 3 * 3) + (j / 3);
                int y = ((i % 3) * 3) + j % 3;
                mark3 = LeeCode36.calc(board, x, y, map, mark3);
            }

            for (int j = 0; j < board.length; j++) {
                int x = (i / 3 * 3) + (j / 3);
                int y = ((i % 3) * 3) + j % 3;
                mark(i, j, board, marks, mark1);
                mark(j, i, board, marks, mark2);
                mark(x, y, board, marks, mark3);
            }
        }

        solveSudoku(board, 0, 0, map, marks);
    }


    private boolean solveSudoku(char[][] board, int x, int y, int[] map, int[][] marks) {
        if (x >= board.length) return true;
        if (y >= board.length) {
            return solveSudoku(board, x + 1, 0, map, marks);
        }

        if (marks[x][y] > 0) {
            for (int i = 0; i < 9; i++) {
                if ((marks[x][y] & map[i]) == 0) {
                    board[x][y] = (char) ('1' + i);
                    if (isValidSudoku(board, map, x, y) && solveSudoku(board, x, y + 1, map, marks)) return true;
                    board[x][y] = '.';
                }
            }
            return false;
        }

        return solveSudoku(board, x, y + 1, map, marks);

    }

    private void mark(int x, int y, char[][] board, int[][] marks, int mark) {
        if (board[x][y] == '.') {
            marks[x][y] |= mark;
        } else {
            marks[x][y] = -1;
        }
    }


    private boolean isValidSudoku(char[][] board, int[] map, int x, int y) {

        int mark1 = 0, mark2 = 0, mark3 = 0;
        for (int i = 0; i < board.length; i++) {
            mark1 = LeeCode36.calc(board, x, i, map, mark1);
            mark2 = LeeCode36.calc(board, i, y, map, mark2);
            mark3 = LeeCode36.calc(board, (x / 3 * 3) + (i / 3), (y / 3 * 3) + i % 3, map, mark3);
            if (mark1 < 0 || mark2 < 0 || mark3 < 0) return false;
        }
        return true;
    }

}
