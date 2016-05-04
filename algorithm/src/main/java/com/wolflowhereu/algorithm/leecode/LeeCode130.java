package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fan on 16-5-4.
 */
public class LeeCode130 {
    /**
     * https://leetcode.com/problems/surrounded-regions/
     *
     * @param board
     */

    private boolean[][] flags;

    public void solve(char[][] board) {
        if (board.length <= 0 || board[0].length <= 0) return;
        flags = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            solve(board, i, 0);
            solve(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            solve(board, 0, i);
            solve(board, board.length - 1, i);
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O' && !flags[i][j]) board[i][j] = 'X';
            }
        }

    }


    private void solve(char[][] board, int x, int y) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] == 'X' || flags[x][y]) return;
        flags[x][y] = true;
        if (x != 0 && y != 0 && y < board[0].length - 1)
            solve(board, x - 1, y);
        if (y != 0 && x < board.length - 1 && y < board[0].length - 1)
            solve(board, x + 1, y);
        if (x != 0 && y != 0 && x < board.length - 1)
            solve(board, x, y - 1);
        if (x != 0 && x < board.length - 1 && y < board[0].length - 1)
            solve(board, x, y + 1);
    }

    @Test
    public void test() {
        String[] s = new String[]{};
        char[][] board = new char[s.length][s[0].length()];
        for (int i = 0; i < s.length; i++) {
            board[i] = s[i].toCharArray();
        }

        System.out.println(board.length + " " + board[0].length);
        solve(board);
    }
}
