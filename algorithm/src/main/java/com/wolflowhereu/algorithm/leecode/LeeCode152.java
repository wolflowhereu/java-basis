package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fan on 16-7-1.
 */
public class LeeCode152 {

    /**
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length <= 0) return 0;
        int num1 = nums[0];
        int num2 = nums[0];
        int result = num1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            num1 *= num;
            num2 *= num;

            if (num < 0) {
                int tmp = num1;
                num1 = num2;
                num2 = tmp;
            }

            if (num > num1) {
                num1 = num;
            }
            if (num < num2) {
                num2 = num;
            }
            if (num1 > result) result = num1;
        }
        return result;
    }


    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{-2, -1,3,4,5,6,6}));
    }
}
