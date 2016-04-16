package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode14 {
    /**
     * https://leetcode.com/problems/longest-common-prefix/
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) return "";
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            boolean isCommon = true;
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || c != strs[j].charAt(i)) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) result += c;
            else break;
        }
        return result;
    }
}
