package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode6 {
    /**
     * https://leetcode.com/problems/zigzag-conversion/
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int k = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int line = 0, i = 0; line < numRows; ) {
            int index = k * i;
            index += line;

            if (index < s.length()) {
                sb.append(s.charAt(index));
                i++;
                if (line > 0 && line < numRows - 1) {
                    index += k - 2 * line;
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
                    } else {
                        line++;
                        i = 0;
                        continue;
                    }
                }
            } else {
                line++;
                i = 0;
                continue;
            }


        }
        return sb.toString();
    }
}
