package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode42 {
    /**
     * https://leetcode.com/problems/trapping-rain-water/
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int result = 0, secHeight = 0, left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                secHeight = Math.max(secHeight, height[left]);
                result += secHeight - height[left];
                left++;
            } else {
                secHeight = Math.max(secHeight, height[right]);
                result += secHeight - height[right];
                right--;
            }
        }
        return result;
    }
}
