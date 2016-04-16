package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode4 {
    /**
     * problem4
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double median(int[] nums1, int[] nums2) {
        int index1 = nums1.length / 2;
        int index2 = nums2.length / 2 - (nums2.length + 1) % 2;
        if (nums1.length <= 0) {
            return ((double) (nums2[(nums2.length - 1) / 2] + nums2[nums2.length / 2])) / 2;
        }
        if (nums2.length <= 0) {
            return ((double) (nums1[(nums1.length - 1) / 2] + nums1[nums1.length / 2])) / 2;
        }


        int start = index1 < nums2.length - index2 - 1 ? 0 : index1 - nums2.length + index2 + 1;
        int end = index2 < nums1.length - index1 - 1 ? index1 + index2 : nums1.length - 1;


        while (start < end) {
            /**
             * 二分递归查找
             */
            int medianNum;
            if (nums1[index1] > nums2[index2]) {
                end = index1 - 1 > start ? index1 - 1 : start;
                medianNum = (start + end) / 2;
            } else if (nums1[index1] < nums2[index2]) {
                start = index1 + 1 < end ? index1 + 1 : end;
                medianNum = (start + end + 1) / 2;
            } else {
                start = end = index1;
                continue;
            }

            index2 += index1 - medianNum;
            index1 = medianNum;
        }

        /**
         * 定位到中值位置 缩小到长度为2-3的数组内
         */

        List<Integer> list = new ArrayList<>();

        list.add(nums1[index1]);
        list.add(index1 > 0 ? nums1[index1 - 1] : Integer.MIN_VALUE);
        list.add(index1 + 1 < nums1.length ? nums1[index1 + 1] : Integer.MAX_VALUE);

        list.add(nums2[index2]);
        list.add(index2 + 1 < nums2.length ? nums2[index2 + 1] : Integer.MAX_VALUE);
        list.add(index2 > 0 ? nums2[index2 - 1] : Integer.MIN_VALUE);

        if (nums1.length % 2 == 0) {
            list.add(index1 - 2 >= 0 ? nums1[index1 - 2] : Integer.MIN_VALUE);
        }
        if (nums2.length % 2 == 0) {
            list.add(index2 + 2 < nums2.length ? nums2[index2 + 2] : Integer.MAX_VALUE);
        }
        Collections.sort(list);
        return ((double) (list.get((list.size() - 1) / 2) + list.get(list.size() / 2))) / 2;
    }

}
