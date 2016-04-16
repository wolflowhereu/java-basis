package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode51 {
    /**
     * https://leetcode.com/problems/n-queens/
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        int[][] map = new int[n][n];

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cleanMap(map);
            markQueens(map, i, 0, 1);
            map[0][i] = 0;
            solveNQueens(map, 1, result);
        }

        return result;
    }

    private static List<String> getQueenList(int[][] map) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        return list;
    }


    private static void cleanMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = -1;
            }
        }
    }

    private static void solveNQueens(int[][] map, int y, List<List<String>> result) {

        if (y > map.length - 1) {
            result.add(getQueenList(map));
        }
        for (int i = 0; i < map.length && y < map.length; i++) {
            if (map[y][i] > 0) continue;
            map[y][i] = 0;
            markQueens(map, i, y, y + 1);
            solveNQueens(map, y + 1, result);
            cleanMarks(map, i, y, y + 1);
            map[y][i] = -1;
        }
    }

    private static void markQueens(int[][] map, int x, int y, int mark) {
        for (int i = 1; i + y < map.length; i++) {
            if (x - i >= 0 && map[y + i][x - i] < 0) map[y + i][x - i] = mark;
            if (x + i < map.length && map[y + i][x + i] < 0) map[y + i][x + i] = mark;
            if (map[y + i][x] < 0) map[y + i][x] = mark;
        }
    }


    private static void cleanMarks(int[][] map, int x, int y, int mark) {
        for (int i = 1; i + y < map.length; i++) {
            if (x - i >= 0 && map[y + i][x - i] == mark) map[y + i][x - i] = -1;
            if (x + i < map.length && map[y + i][x + i] == mark) map[y + i][x + i] = -1;
            if (map[y + i][x] == mark) map[y + i][x] = -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(5));
        System.out.println("[[Q...., ..Q.., ....Q, .Q..., ...Q.], [Q...., ...Q., .Q..., ....Q, ..Q..], [.Q..., ...Q., Q...., ..Q.., ....Q], [.Q..., ....Q, ..Q.., Q...., ...Q.], [..Q.., Q...., ...Q., .Q..., ....Q], [..Q.., ....Q, .Q..., ...Q., Q....], [...Q., Q...., ..Q.., ....Q, .Q...], [...Q., .Q..., ....Q, ..Q.., Q....], [....Q, .Q..., ...Q., Q...., ..Q..], [....Q, ..Q.., Q...., ...Q., .Q...]]");
    }

}
