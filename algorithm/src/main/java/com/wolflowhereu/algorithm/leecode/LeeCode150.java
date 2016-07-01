package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fan on 16-7-1.
 */
public class LeeCode150 {

    /**
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        int[] ls = new int[tokens.length + 1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "*":
                    ls[index - 2] *= ls[index - 1];
                    index--;
                    break;
                case "/":
                    ls[index - 2] /= ls[index - 1];
                    index--;
                    break;
                case "+":
                    ls[index - 2] += ls[index - 1];
                    index--;
                    break;
                case "-":
                    ls[index - 2] -= ls[index - 1];
                    index--;
                    break;
                default:
                    ls[index++] = Integer.parseInt(token);
                    break;
            }
        }

        return ls[0];
    }


    @Test
    public void test2() {

    }
}
