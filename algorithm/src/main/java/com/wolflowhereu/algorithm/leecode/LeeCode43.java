package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode43 {
    /**
     * https://leetcode.com/problems/multiply-strings/
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        final long ary = 1000000000l;
        long[] nums1 = strToNums(num1);
        long[] nums2 = strToNums(num2);
        long[] resultArray = new long[num1.length() + num2.length()];

        for (int i = 0; i < nums1.length; i++) {
            long carry = 0;
            for (int j = 0; j < nums2.length; j++) {
                resultArray[i + j] += nums2[j] * nums1[i] + carry;
                carry = resultArray[i + j] / ary;
                resultArray[i + j] %= ary;
            }
            int k = nums2.length;
            while (carry > 0) {
                resultArray[i + k] += carry;
                carry = resultArray[i + k] / ary;
                resultArray[i + k] %= ary;
            }
        }

        StringBuilder sb = new StringBuilder();


        boolean isStart = false;
        for (int i = resultArray.length - 1; i >= 0; i--) {
            if (resultArray[i] > 0) isStart = true;
            if (isStart) {
                if (sb.length() > 0) {
                    sb.append(String.format("%09d", resultArray[i]));
                } else {
                    sb.append(resultArray[i]);
                }
            }
        }

        if (sb.length() <= 0) return "0";
        return sb.toString();

    }

    private static long[] strToNums(String num) {
        long[] nums = new long[(num.length() - 1) / 9 + 1];
        int index = 0;
        for (int end = num.length(); end > 0; end -= 9) {
            int start = end - 9 < 0 ? 0 : end - 9;
            nums[index++] = Long.parseLong(num.substring(start, end));
        }
        return nums;
    }

}
