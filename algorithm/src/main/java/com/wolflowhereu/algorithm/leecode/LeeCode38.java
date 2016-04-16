package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode38 {
    /**
     * https://leetcode.com/problems/count-and-say/
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n < 1) return "";
        String result = "1";
        while (n-- > 1) {
            StringBuilder sb = new StringBuilder();
            int num = result.charAt(0) - '0', count = 1;
            for (int i = 1; i < result.length(); i++) {
                int cNum = result.charAt(i) - '0';
                if (num == cNum) count++;
                else {
                    sb.append(count).append(num);
                    num = cNum;
                    count = 1;
                }
            }
            sb.append(count).append(num);

            result = sb.toString();
        }
        return result;
    }
}
