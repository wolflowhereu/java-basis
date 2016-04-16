package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode17 {
    /**
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() < 0) return result;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1') return result;
        }
        dfsGetStr(digits, new char[digits.length()], 0, map, result);
        return result;
    }

    private void dfsGetStr(String digits, char[] middleStr, int index, String[] map, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(middleStr));
            return;
        }

        for (int i = 0; i < map[digits.charAt(index) - '0'].length(); i++) {
            middleStr[index] = map[digits.charAt(index) - '0'].charAt(i);
            dfsGetStr(digits, middleStr, index + 1, map, result);
        }
    }

}
