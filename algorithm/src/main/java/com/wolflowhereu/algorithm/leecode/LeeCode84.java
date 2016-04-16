package com.wolflowhereu.algorithm.leecode;


import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-4-1.
 * @Discreption
 */
public class LeeCode84 {

    public int largestRectangleArea(int[] heights) {
        int[][] stack = new int[heights.length + 2][2];
        int top = 0, maxArea = 0;
        stack[0][1] = -1;

        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i];
            while (stack[top][0] > height) {
                int tmp = stack[top][0] * (i - stack[top - 1][1] -1);
                if (tmp > maxArea) maxArea = tmp;
                top--;
            }
            top++;
            stack[top][0] = height;
            stack[top][1] = i;
        }

        return maxArea;
    }

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{2,1,2}));
    }
}
