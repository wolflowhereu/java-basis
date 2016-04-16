package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode76 {

    /**
     * https://leetcode.com/problems/minimum-window-substring/
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[][] map = new int[128][2];
        int tCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i)][0] == 0) {
                tCount++;
            }
            map[t.charAt(i)][0] += 1;
        }

        int start = 0, end = 0, sCount = 0, minStart = 0, minEnd = s.length();
        while (end < s.length()) {
            if (sCount == tCount) {
                int mapIndex = s.charAt(start);
                if (map[mapIndex][0] == 0) {
                    start++;
                    continue;
                }

                map[mapIndex][1] = map[mapIndex][1] - 1;
                if (map[mapIndex][1] == map[mapIndex][0] - 1) {
                    if ((minEnd - minStart) > (end - start)) {
                        minStart = start;
                        minEnd = end;
                    }
                    end++;
                    sCount--;
                }
                start++;
            } else {
                int mapIndex = s.charAt(end);
                if (map[mapIndex][0] == 0) {
                    end++;
                    continue;
                }
                map[mapIndex][1] = map[mapIndex][1] + 1;
                if (map[mapIndex][1] == map[mapIndex][0]) {
                    sCount++;
                    if (sCount == tCount) continue;
                }
                end++;
            }
        }

        if (minEnd >= s.length()) return "";
        return s.substring(minStart, minEnd + 1);
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
