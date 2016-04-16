package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode44 {
    /**
     * https://leetcode.com/problems/wildcard-matching/
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch44(String s, String p) {

        int starPIndex = -1, startSIndex = 0, sIndex = 0, pIndex = 0;

        while (sIndex < s.length()) {
            if (pIndex >= p.length()) {
                if (starPIndex > 0) {
                    startSIndex++;
                    sIndex = startSIndex;
                    pIndex = starPIndex;
                    continue;
                }
                return false;
            }

            if (p.charAt(pIndex) == '*') {
                pIndex++;
                starPIndex = pIndex;
                startSIndex = sIndex;
                if (starPIndex >= p.length()) return true;
                continue;
            }

            if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
                pIndex++;
                sIndex++;
                continue;
            }

            if (starPIndex < 0) return false;

            startSIndex++;
            sIndex = startSIndex;
            pIndex = starPIndex;
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;

        return s.length() == sIndex && pIndex == p.length();
    }
}
