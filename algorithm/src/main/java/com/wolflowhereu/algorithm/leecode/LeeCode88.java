package com.wolflowhereu.algorithm.leecode;

/**
 * @author jx09.
 * @Date 16-4-5.
 * @Discreption
 */
public class LeeCode88 {

    /**
     * https://leetcode.com/problems/merge-sorted-array/
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        while (m>0 && n>0){
            if (nums1[m-1] > nums2[n-1]){
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }

        while (n > 0) {
            nums1[n-1] = nums2[n-1];
            n--;
        }
    }
}
