package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode58 {
    /**
     * https://leetcode.com/problems/length-of-last-word/
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                if (length==0) continue;
                break;
            }
            length++;
        }

        return length;
    }

    public static void main(String[] args) {

    }
}
