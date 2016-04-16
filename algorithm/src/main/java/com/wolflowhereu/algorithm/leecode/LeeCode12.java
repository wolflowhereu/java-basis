package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode12 {
    /**
     * https://leetcode.com/problems/integer-to-roman/
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        String[][] c = {{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"0", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"0", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"0", "M", "MM", "MMM"}};

        StringBuilder roman = new StringBuilder();

        if (num / 1000 > 0) {
            roman.append(c[3][num / 1000]);
            num %= 1000;
        }

        if (num / 100 > 0) {
            roman.append(c[2][num / 100]);
            num %= 100;
        }

        if (num / 10 > 0) {
            roman.append(c[1][num / 10]);
            num %= 10;
        }

        if (num > 0) {
            roman.append(c[0][num]);
        }

        return roman.toString();
    }
}
