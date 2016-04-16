package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode79 {

    /**
     * https://leetcode.com/problems/word-search/
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board.length <= 0 || board[0].length <= 0) return false;
        if (word.length() > board.length * board[0].length) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (word.length() <= index) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] == word.charAt(index)) {
            board[x][y] = 0;
            if (dfs(board, word, x + 1, y, index+1) || dfs(board, word, x, y + 1, index+1) ||
                    dfs(board, word, x - 1, y, index+1) || dfs(board, word, x, y - 1, index+1))
                return true;
            board[x][y] = word.charAt(index);
        }
        return false;
    }

    @Test
    public void test() {

    }
}
