package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode11 {
    /**
     * https://leetcode.com/problems/container-with-most-water/
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;

        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);
            if (water > max) max = water;
            if (height[left] > height[right]) right--;
            else left++;
        }

        return max;
    }
}
