package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode22 {
    /**
     * https://leetcode.com/problems/generate-parentheses/
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, result, "");
        return result;
    }

    private void generateParenthesis(int n, int count, List<String> result, String parenthesis) {

        if (n <= 0 && count <= 0) {
            result.add(parenthesis);
            return;
        }

        if (n > 0) {
            generateParenthesis(n - 1, count + 1, result, parenthesis + "(");
        }

        if (count > 0) generateParenthesis(n, count - 1, result, parenthesis + ")");
    }
}
