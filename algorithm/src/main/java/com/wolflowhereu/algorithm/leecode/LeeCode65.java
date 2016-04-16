package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode65 {
    /**
     * https://leetcode.com/problems/valid-number/
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;

        int has = 0b00000;
        int next = 0b0111;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '.': {
                    if ((next & 1) <= 0 || (has & 1) > 0) return false;
                    has |= 1;
                    next = 0;
                    if ((has & (1 << 4)) > 0) next = 0b1000;
                    break;
                }
                case '+': {
                    if ((next & (1 << 1)) <= 0 || (has & (1 << 1)) > 0) return false;
                    next = 0b0001;
                    has |= 1 << 1;
                    break;
                }
                case '-': {
                    if ((next & (1 << 2)) <= 0 || (has & (1 << 2)) > 0) return false;
                    has |= 1 << 2;
                    next = 0b0001;
                    break;
                }
                case 'e': {
                    if ((next & (1 << 3)) <= 0 || (has & (1 << 3)) > 0) return false;
                    has = 0b1001;
                    next = 0b110;
                    break;
                }

                default: {
                    if (c > '9' || c < '0') return false;
                    next = 0b1001;
                    has |= 1 << 4;
                }
            }
        }
        return (has & (1 << 4)) > 0;
    }


    @Test
    public void test() {
        System.out.println("0" + "    " + isNumber("0") + "=> true");
        System.out.println(" 0.1 " + "    " + isNumber(" 0.1 ") + "=> true");
        System.out.println("abc" + "    " + isNumber("abc") + "=> false");
        System.out.println("1 a" + "    " + isNumber("1 a") + "=> false");
        System.out.println("2e10" + "    " + isNumber("2e10") + "=> true");
        System.out.println("." + "    " + isNumber(".") + "=> false");
        System.out.println(".1" + "    " + isNumber(".1") + "=> true");
        System.out.println("1." + "    " + isNumber("1.") + "=> true");
        System.out.println("+.8" + "    " + isNumber("+.8") + "=> true");
        System.out.println(" -. " + "    " + isNumber(" -. ") + "=> false");
        System.out.println("46.e3" + "    " + isNumber("46.e3") + "=> true");
    }
}
