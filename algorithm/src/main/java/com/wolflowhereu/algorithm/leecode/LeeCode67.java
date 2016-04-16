package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode67 {

    final long max = 1l << 60;

    /**
     * https://leetcode.com/problems/add-binary/
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (; indexA >= 0 && indexB >= 0; indexA--, indexB--) {
            carry = addBinary(a.charAt(indexA), b.charAt(indexB), sb, carry);
        }
        while (indexA >= 0) {
            carry = addBinary(a.charAt(indexA--), '0', sb, carry);
        }
        while (indexB >= 0) {
            carry = addBinary(b.charAt(indexB--), '0', sb, carry);
        }
        if (carry > 0) sb.insert(0, '1');

        return sb.toString();
    }


    private int addBinary(char a, char b, StringBuilder sb, int carry) {
        if (a == '1') carry++;
        if (b == '1') carry++;
        if (carry % 2 == 1) sb.insert(0, '1');
        else sb.insert(0, '0');
        return carry / 2;
    }

    @Test
    public void test() {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101","110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000");
    }


}
