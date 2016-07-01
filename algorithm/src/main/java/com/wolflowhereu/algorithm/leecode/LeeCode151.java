package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fan on 16-7-1.
 */
public class LeeCode151 {

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0;
        while (end<s.length()) {
            if (s.charAt(end) == ' ') {
                while ((++end)<s.length() && s.charAt(end)==' '){}

                sb.insert(0, s.substring(start, end).trim() + " ");
                start = end;
            }else end++;
        }
        if (start<end){
            sb.insert(0, s.substring(start, end) + " ");
        }

        return sb.toString().trim();
    }

    @Test
    public void test2() {
        System.out.println(reverseWords("   a   b "));
    }

}
