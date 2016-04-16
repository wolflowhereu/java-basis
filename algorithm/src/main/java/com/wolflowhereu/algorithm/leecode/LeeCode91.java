package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-4-6.
 * @Discreption
 */
public class LeeCode91 {

    /**
     * https://leetcode.com/problems/decode-ways/
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() <= 0 || s.charAt(0) == '0') return 0;
        int backNum = s.charAt(s.length() - 1) - '0', sum = 1, backSum = 1;

        for (int i = s.length() - 2; i >= 0; i--) {
            int nowNum = s.charAt(i) - '0';
            if (nowNum != 1 && nowNum != 2 && backNum == 0) return 0;
            if ((nowNum == 1 || nowNum == 2) && backNum > 0 && backNum < 10 && (nowNum * 10 + backNum) < 27) {
                sum += backSum;
                backSum = sum - backSum;
            } else backSum = sum;
            if (backNum == 0) nowNum *= 10;
            backNum = nowNum;
        }
        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(numDecodings("0"), 0);
        Assert.assertEquals(numDecodings("10"), 1);
        Assert.assertEquals(numDecodings("11"), 2);
        Assert.assertEquals(numDecodings("110"), 1);
        Assert.assertEquals(numDecodings("230"), 0);
        Assert.assertEquals(numDecodings("24726"), 4);
    }
}
